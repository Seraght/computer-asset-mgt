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
            
            <h1 class="page-header">รายละเอียดการแจ้งซ่อม</h1>
            ${message}
            <form class="form-horizontal" action="/cam/updateticket" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">หมายเลขแจ้งซ่อม #</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${ticket.ticketID}</p>
                        <input type="hidden" class="form-control" id="ticketID" value="${ticket.ticketID}" name="ticketID">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">ชื่อผู้แจ้ง</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${ticket.p.firstName}&nbsp;${ticket.p.lastName}</p>
                    </div>
                    <label class="col-sm-2 control-label">หมายเลขครุภัณฑ์</label>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="assetYear" value="${ticket.assetYear}" name="assetYear">
                    </div>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="assetGet" value="${ticket.assetGet}" name="assetGet">
                    </div>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="assetNumber" value="${ticket.assetNumber}" name="assetNumber">
                    </div>
                    <div class="col-sm-1">
                        <input type="text" class="form-control" id="assetType" value="${ticket.assetType}" name="assetType">
                    </div>
                </div>	
                <div class="form-group">
                    <label class="col-sm-2 control-label">ปัญหาที่แจ้ง</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="ticketTitle">
                            <option value="คอมพิวเตอร์">คอมพิวเตอร์</option>
                            <option value="อินเทอร์เน็ต">อินเทอร์เน็ต</option>
                            <option value="ปริ้นเตอร์">ปริ้นเตอร์</option>
                            <option value="โปรแกรม">โปรแกรม</option>
                            <option value="อื่นๆ">อื่นๆ</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">รายละเอียดของปัญหา</label>
                    <div class="col-sm-10">
                        <textarea rows="6" cols="50" name="ticketDescription" class="form-control" id="ticketDescription">${ticket.ticketDescription}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" >Submit</button>

                    </div>
                </div>
            </form>
        </div>

        <%@include file="/js_tag.html" %>
    </body>
</html>
