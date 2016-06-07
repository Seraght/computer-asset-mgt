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
        <%@ include file="/front/menu_left_backend.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            
            <h1 class="page-header">รายละเอียดการส่งมอบ</h1>
            ${message}
            <form class="form-horizontal" action="#" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">หมายเลขการส่งมอบ #</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${deliver.deliverID}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">ชื่อผู้รับ</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${deliver.p.firstName}&nbsp;${deliver.p.lastName}</p>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">หมายเลขครุภัณฑ์</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${deliver.c.assetYear}-${deliver.c.assetGet}-${deliver.c.assetNumber}-${deliver.c.typeID}</p>
                    </div>
                </div>    
                <div class="form-group">
                    <label class="col-sm-2 control-label">สถานะการรับมอบ</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${deliver.deliverStatus}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">วันที่ส่งมอบ</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${deliver.deliverDate}</p>
                    </div>
                </div>   
                <div class="form-group">
                    <label class="col-sm-2 control-label">วันที่รับมอบ</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${deliver.acceptDate}</p>
                    </div>
                </div> 
            </form>
        </div>

        <%@include file="/js_tag.html" %>
    </body>
</html>
