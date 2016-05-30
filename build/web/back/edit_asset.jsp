<%-- 
    Document   : index
    Created on : Mar 27, 2016, 10:11:19 PM
    Author     : Seraght
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/header_tag.html" %>
    <body>
        <jsp:include page="/menu_top.jsp" />
        <%@ include file="/back/menu_left_backend.jsp"%>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">แก้ไขครุภัณฑ์</h1>

            <form class="form-horizontal" action="/cam/editassetreal" method="post">

                <div class="form-group">
                    <input type="hidden" class="form-control" id="assetID" name="assetID" value="${computer.assetID}">
                    <label for="inputAssetNumber" class="col-sm-2 control-label">หมายเลขครุภัณฑ์</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="assetNumber" name="assetNumber" value="${computer.assetNumber}">
                    </div>
                    <label for="inputTypeID" class="col-sm-2 control-label">ประเภทครุภัณฑ์</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="typeID">
                            <c:forEach items="${properties}" var="p" varStatus="vs" >
                                <c:choose>
                                    <c:when test="${computer.typeID == p.assetTypeID}">
                                        <option value="${p.assetTypeID}" selected="">${p.assetType}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${p.assetTypeID}">${p.assetType}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                        
                    </div>
                    <button type="button" class="btn btn-primary" id="myBtn">+</button>
                </div>
                <div class="form-group">
                    <label for="inputModel" class="col-sm-2 control-label">รุ่น</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="model" value="${computer.spec["model"]}" name="model">
                    </div>
                    <label for="inputBrand" class="col-sm-2 control-label">ยี่ห้อ</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="brand">
                            <c:forEach items="${brand}" var="b" varStatus="vs" >
                                <c:choose>
                                    <c:when test="${computer.spec["brand"] == b.assetBrand}">
                                        <option value="${b.assetBrand}" selected>${b.assetBrand}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${b.assetBrand}">${b.assetBrand}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="button" class="btn btn-primary" id="myBtnBrand">+</button>
                </div>
                <div class="form-group">
                    <label for="inputPrice" class="col-sm-2 control-label">Serial Number</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="serial" value="${computer.serial}" name="serial">
                    </div>
                    <label for="inputPrice" class="col-sm-2 control-label">ราคา</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="price" value="${computer.price}" name="price">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDescription" class="col-sm-2 control-label">รายละเอียดเพิ่มเติม</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="description" value="${computer.spec["description"]}" name="description">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>

            <%@include file="/js_tag.html" %>
            <!-- Modal Asset Type-->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-pencil"></span> เพิ่มประเภทสินทรัพย์</h4>
                        </div>
                        <form role="form" action="/cam/addassettype" method="post">
                            <div class="modal-body">

                                <input type="text" class="form-control" id="type" placeholder="โปรดระบุชื่อประเภทของสินทรัพย์ที่ต้องการเพิ่ม" name="type">

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> เพิ่ม</button>
                                <button type="submit" class="btn btn-danger btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> ยกเลิก</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Modal Asset Brand-->
            <div class="modal fade" id="myModalBrand" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title"><span class="glyphicon glyphicon-pencil"></span> เพิ่มยี่ห้อ</h4>
                        </div>
                        <form role="form" action="/cam/addassetbrand" method="post">
                            <div class="modal-body">

                                <input type="text" class="form-control" id="brand" placeholder="โปรดระบุชื่อยี่ห้อที่ต้องการเพิ่ม" name="brand">

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> เพิ่ม</button>
                                <button type="submit" class="btn btn-danger btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> ยกเลิก</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%@include file="/js_tag.html" %>
            <script>
                $(document).ready(function () {
                    $("#myBtn").click(function () {
                        $("#myModal").modal();
                    });
                });
            </script>
            <script>
                $(document).ready(function () {
                    $("#myBtnBrand").click(function () {
                        $("#myModalBrand").modal();
                    });
                });
            </script>
    </body>
</html>
