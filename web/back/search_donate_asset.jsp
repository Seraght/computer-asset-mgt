<%-- 
    Document   : index
    Created on : Mar 27, 2016, 10:11:19 PM
    Author     : Seraght
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <%@include file="/header_tag.html" %>
    <body>
        <jsp:include page="/menu_top.jsp" />
        <%@ include file="/back/menu_left_backend.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h1 class="page-header">ค้นหาครุภัณฑ์บริจาค</h1>
            <form class="form-horizontal" action="/cam/viewdonateasset" method="post">
                <div class="form-group">
                    <label for="inputAssetGet" class="col-sm-2 control-label">สถานะของครุภัณฑ์บริจาค</label>
                    <div class="col-sm-2">

                        <select class="form-control" name="assetStatus">
                            <option value="Stock">ครุภัณฑ์ที่สามารถบริจาคได้</option>
                            <option value="Donate">ครุภัณฑ์ที่บริจาคแล้ว</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>

            <h3 class="sub-header">${message}</h3>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${computers!=null}">
                        <c:choose>
                            <c:when test="${computers[0].assetStatus == 'Stock'}">
                                <form class="form-horizontal" action="/cam/donateasset" method="get">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th align="center">ลำดับที่</th>
                                                <th>รหัสครุภัณฑ์</th>
                                                <th>ยี่ห้อ</th>
                                                <th>รุ่น</th>
                                                <th>ชนิด</th>
                                                <th>อายุการใช้งาน (ปี)</th>
                                                <th>วันที่สั่งซื้อ</th>
                                                <th>บริจาค</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="now" value="<%=new java.util.Date()%>" />
                                            <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
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
                                                    <c:set var="buyYear" value="${fn:substring(c.assetBuyDate, 0, 4)}" />
                                                    <td>${year - buyYear}</td>
                                                    <td>${c.assetBuyDate}</td>
                                                    <td><input type="checkbox" name="donateAsset" value="${c.assetYear}-${c.assetGet}-${c.assetNumber}-${c.typeID}"></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="form-group">
                                        <label for="inputDonateDate" class="col-sm-offset-7 col-sm-2 control-label">วันที่บริจาค</label>
                                        <div class="col-sm-2">
                                            <input type="text" id="dp1" class="span2 datepicker form-control"  name="donateTime">
                                        </div>
                                        <button type="submit" class="btn btn-default ">Submit</button>
                                    </div>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th align="center">ลำดับที่</th>
                                            <th>รหัสครุภัณฑ์</th>
                                            <th>ยี่ห้อ</th>
                                            <th>รุ่น</th>
                                            <th>ชนิด</th>
                                            <th>อายุการใช้งาน (ปี)</th>
                                            <th>วันที่สั่งซื้อ</th>
                                            <th>วันที่บริจาค</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="now" value="<%=new java.util.Date()%>" />
                                        <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
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
                                                <td>${c.brand}</td>
                                                <td>${c.model}</td>
                                                <td>${c.typeName}</td> 
                                                <c:set var="buyYear" value="${fn:substring(c.assetBuyDate, 0, 4)}" />
                                                <td>${year - buyYear}</td>
                                                <td>${c.assetBuyDate}</td>
                                                <td>${c.donateDate}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:otherwise>
                        </c:choose>
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
        <script>
            $(function () {
                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd'
                });
            });
        </script>
    </body>
</html>
