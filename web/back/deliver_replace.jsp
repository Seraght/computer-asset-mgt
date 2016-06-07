<%-- 
    Document   : index
    Created on : Mar 27, 2016, 10:11:19 PM
    Author     : Seraght
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/header_tag.html" %>
    <body>
        <jsp:include page="/menu_top.jsp" />
        <%@ include file="/back/menu_left_backend.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h1 class="page-header">ทดแทนครุภัณฑ์</h1>
            ${message}
            <form class="form-horizontal" action="#" method="post">
                <h3>ครุภัณฑ์เดิม</h3>

                <div class="form-group">
                    <label class="col-sm-2 control-label">หมายเลขครุภัณฑ์</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${oldDeliver.c.assetYear}-${oldDeliver.c.assetGet}-${oldDeliver.c.assetNumber}-${oldDeliver.c.typeID}</p>
                    </div>
                </div>    
                <div class="form-group">
                    <label class="col-sm-2 control-label">ยี่ห้อ</label>
                    <div class="col-sm-2">
                        <p class="form-control-static">${oldDeliver.c.spec["brand"]}</p>
                    </div>
                    <label class="col-sm-2 control-label">รุ่น</label>
                    <div class="col-sm-2">
                        <p class="form-control-static">${oldDeliver.c.spec["model"]}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">วันที่ส่งมอบ</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${oldDeliver.deliverDate}</p>
                    </div>
                </div>   
                <div class="form-group">
                    <label class="col-sm-2 control-label">วันที่รับมอบ</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${oldDeliver.acceptDate}</p>
                    </div>
                </div> 
            </form>
            <form class="form-horizontal" action="/cam/replaceasset" method="post">
                <h3>ครุภัณฑ์ทดแทน</h3>

                <div class="form-group">
                    <label class="col-sm-2 control-label">หมายเลขครุภัณฑ์</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${newDeliver.c.assetYear}-${newDeliver.c.assetGet}-${newDeliver.c.assetNumber}-${newDeliver.c.typeID}</p>
                        <input type="hidden" name="assetGet" value="${newDeliver.c.assetGet}">
                        <input type="hidden" name="assetYear" value="${newDeliver.c.assetYear}">
                        <input type="hidden" name="assetNumber" value="${newDeliver.c.assetNumber}">
                        <input type="hidden" name="typeID" value="${newDeliver.c.typeID}">
                        <input type="hidden" name="personID" value="${oldDeliver.p.officerID}">
                        <input type="hidden" name="deliverID" value="${oldDeliver.deliverID}">
                        <input type="hidden" name="oldAssetYear" value="${oldDeliver.c.assetYear}">
                        <input type="hidden" name="oldAssetGet" value="${oldDeliver.c.assetGet}">
                        <input type="hidden" name="oldAssetNumber" value="${oldDeliver.c.assetNumber}">
                        <input type="hidden" name="oldTypeID" value="${oldDeliver.c.typeID}">
                    </div>
                </div>    
                <div class="form-group">
                    <label class="col-sm-2 control-label">ยี่ห้อ</label>
                    <div class="col-sm-2">
                        <p class="form-control-static">${newComputer.spec["brand"]}</p>
                    </div>
                    <label class="col-sm-2 control-label">รุ่น</label>
                    <div class="col-sm-2">
                        <p class="form-control-static">${newComputer.spec["model"]}</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-3">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
        </div>

        <%@include file="/js_tag.html" %>
    </body>
</html>
