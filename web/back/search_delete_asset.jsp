<%-- 
    Document   : index
    Created on : Mar 27, 2016, 10:11:19 PM
    Author     : Seraght
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <%@include file="/header_tag.html" %>
    <body>
        <jsp:include page="/menu_top.jsp" />
        <%@ include file="/back/menu_left_backend.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h3 class="sub-header">${message}</h3>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${computers!=null}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th align="center">ลำดับที่</th>
                                    <th>รหัสครุภัณฑ์</th>
                                    <th>ยี่ห้อ</th>
                                    <th>รุ่น</th>
                                    <th>ชนิด</th>
                                    <th>ลบ</th>
                                    <th>แก้ไข</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${computers}" var="c" varStatus="vs" >
                                    <c:choose>
                                        <c:when test="${vs.count%2==0}">
                                            <c:set var="bg" value="#FCFCFC" />
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="bg" value="#EEEEEE" />
                                        </c:otherwise>
                                    </c:choose>
                                    <tr style="background-color: ${bg}">
                                        <td>${vs.count}</td>
                                        <td>${c.assetYear}-${c.assetGet}-${c.assetNumber}-${c.typeID}</td>
                                        <td>${c.spec["brand"]}</td>
                                        <td>${c.spec["model"]}</td>
                                        <td>${c.typeName}</td> 
                                        <td><a href="/cam/removeasset?assetYear=${c.assetYear}&assetGet=${c.assetGet}&assetNumber=${c.assetNumber}&typeID=${c.typeID}" data-confirm="คุณยืนยันที่จะลบครุภัณฑ์หรือไม่ (ครุภัณฑ์ที่ถูกลบ จะย้ายไปอยู่ในหัวข้อ 'ครุภัณฑ์ที่ถูกลบ')"><span class="glyphicon glyphicon-trash"></span></a></td>
                                        <td><a href="/cam/editasset?assetYear=${c.assetYear}&assetGet=${c.assetGet}&assetNumber=${c.assetNumber}&typeID=${c.typeID}"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <%--<c:otherwise>
                        <table style="width:80%; margin-left: 30pt; background-color: beige">
                            <tr><td><h3 style="color: red">${message}</h3><hr></td></tr>
                            <tr><td><p style="padding-left: 50px">จะต้องใส่ % เพื่อทำการค้นหาข้อมูลทั้งหมด</p></td></tr>
                        </table>
                    </c:otherwise>--%>
                </c:choose>
            </div>
        </div>

        <%@include file="/js_tag.html" %>
        
    </body>
</html>
