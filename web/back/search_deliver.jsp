<%-- 
    Document   : index
    Created on : Mar 27, 2016, 10:11:19 PM
    Author     : Seraght
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <%@include file="/header_tag.html" %>
    <body>
        <jsp:include page="/menu_top.jsp" />
        <%@ include file="/back/menu_left_backend.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">เรียกดูรายการส่งมอบ</h1>
            <form class="form-horizontal" action="/cam/persondeliver" method="post">
                <div class="form-group">
                    <label for="statusPerson" class="col-sm-2 control-label">ต้นหาจากเจ้าหน้าที่สำนักงาน</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="statusPerson">
                            <option value="2">ทั้งหมด</option>
                            <option value="0">ยังไม่มีครุภัณฑ์</option>
                            <option value="1">มีครุภัณฑ์แล้ว</option>
                        </select>
                    </div>
                    <div class="col-sm-offset-2 col-sm-4">
                        <button type="submit" class="btn btn-default">Search</button>
                    </div>
                </div>
            </form>
            <form class="form-horizontal" action="/cam/assetdeliver" method="post">
                <div class="form-group">
                    <label for="statusAsset" class="col-sm-2 control-label">ต้นหาจากครุภัณฑ์คอมพิวเตอร์</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="statusAsset">
                            <option value="0">ทั้งหมด</option>
                            <option value="Stock">ยังไม่มีผู้ครองครอง</option>
                            <option value="Deliver">มีผู้ครอบครอง</option>
                        </select>
                    </div>
                    <div class="col-sm-offset-2 col-sm-4">
                        <button type="submit" class="btn btn-default">Search</button>
                    </div>
                </div>
            </form>
            <h4 class="sub-header">${message}</h4>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${computers!=null}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ลำดับที่</th>
                                    <th>รหัสครุภัณฑ์</th>
                                    <th>ยี่ห้อ</th>
                                    <th>รุ่น</th>
                                    <th>ดูรายละเอียด</th>
                                    <th>ส่งมอบ</th>
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
                                        <c:choose>
                                            <c:when test="${c.hasOwner == 1}">
                                                <td align="center"><a href="/cam/viewdeliver?assetYear=${c.assetYear}&assetGet=${c.assetGet}&assetNumber=${c.assetNumber}&typeID=${c.typeID}"><img src="images/detail_icon.png" class="img-responsive"></a></td> 
                                                    </c:when>
                                                    <c:otherwise>
                                                <td></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${c.hasOwner == 0}">
                                                <td align="center"><a href="/cam/matchdeliver?assetYear=${c.assetYear}&assetGet=${c.assetGet}&assetNumber=${c.assetNumber}&typeID=${c.typeID}"><img src="images/edit_icon_mini.png" class="img-responsive"></a></td> 
                                                    </c:when>
                                                    <c:otherwise>
                                                <td></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                </c:choose>
            </div>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${persons!=null}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ลำดับที่</th>
                                    <th>รหัสประจำตัว</th>
                                    <th>ชื่อ</th>
                                    <th>นามสกุล</th>
                                    <th>ดูรายละเอียด</th>
                                    <th>ส่งมอบ</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${persons}" var="p" varStatus="vs" >
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
                                        <td>${p.officerNumber}</td>
                                        <td>${p.firstName}</td>
                                        <td>${p.lastName}</td>
                                        <c:choose>
                                            <c:when test="${p.hasAsset == 1}">
                                                <td align="center"><a href="/cam/viewdeliver?personID=${p.officerID}"><img src="images/detail_icon.png" class="img-responsive"></a></td> 
                                                    </c:when>
                                                    <c:otherwise>
                                                <td></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${p.hasAsset == 0}">
                                                <td align="center"><a href="/cam/matchdeliver?personID=${p.officerID}&Firstname=${p.firstName}&Lastname=${p.lastName}"><img src="images/edit_icon_mini.png" class="img-responsive"></a></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                <td></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                </c:choose>
            </div>
        </div>

        <%@include file="/js_tag.html" %>
    </body>
</html>
