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
            <h1 class="page-header">ค้นหาครุภัณฑ์</h1>
            <form class="form-horizontal" action="/cam/searchasset" method="post">
                <div class="form-group">
                    <label for="inputAssetYear" class="col-sm-2 control-label">ปีงบประมาณที่จัดซื้อ</label>
                    <div class="col-sm-2">
                        <jsp:useBean id="now" class="java.util.Date" />
                        <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
                        <select class="form-control" name="assetYear">
                            <option value=""></option>
                            <c:forEach var="i" begin="0" end="10" >
                                <option value=" ${year+543-i}"> ${year+543-i}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label for="inputAssetGet" class="col-sm-1 control-label">การได้มา</label>
                    <div class="col-sm-2">

                        <select class="form-control" name="assetGet">
                            <option value="0"></option>
                            <c:forEach items="${get}" var="g" varStatus="vs" >
                                <option value="${g.assetGetID}">${g.assetGet}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label for="inputTypeID" class="col-sm-2 control-label">ประเภทครุภัณฑ์</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="typeID">
                            <option value="0"></option>
                            <c:forEach items="${properties}" var="p" varStatus="vs" >
                                <option value="${p.assetTypeID}">${p.assetType}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputModel" class="col-sm-2 control-label">รุ่น</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="model" placeholder="Optiplex 7010DT" name="model">
                    </div>
                    <label for="inputBrand" class="col-sm-2 control-label">ยี่ห้อ</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="brand">
                            <option value=""></option>
                            <c:forEach items="${brand}" var="b" varStatus="vs" >
                                <option value="${b.assetBrand}">${b.assetBrand}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="form-group">
                    <label for="inputSerial" class="col-sm-2 control-label">Serial Number</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="serial" placeholder="กรอก Serial Number" name="serial">
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
        <script>
            $(document).ready(function () {
                $('a[data-confirm]').click(function (ev) {
                    var href = $(this).attr('href');
                    if (!$('#dataConfirmModal').length) {
                        $('body').append('<div id="dataConfirmModal" class="modal fade" role="dialog" aria-labelledby="dataConfirmLabel" aria-hidden="true" tabindex="-1"><div class="modal-dialog modal-sm"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h3 id="dataConfirmLabel">ยืนยันการลบครุภัณฑ์</h3></div><div class="modal-body"></div><div class="modal-footer"><a class="btn btn-primary" id="dataConfirmOK">OK</a><button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button></div></div></div></div>');
                    }
                    $('#dataConfirmModal').find('.modal-body').text($(this).attr('data-confirm'));
                    $('#dataConfirmOK').attr('href', href);
                    $('#dataConfirmModal').modal({show: true});
                    return false;
                });
            });
        </script>
    </body>
</html>
