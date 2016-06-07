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
            <h3>${message}</h3>
            <form class="form-horizontal" action="/cam/reviewsend" method="post">
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
                    <div class="col-sm-4">
                        <p class="form-control-static">${ticket.assetYear}-${ticket.assetGet}-${ticket.assetNumber}-${ticket.assetType}</p>
                    </div>
                </div>	
                <div class="form-group">
                    <label class="col-sm-2 control-label">ปัญหาที่แจ้ง</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${ticket.ticketStatusName}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">รายละเอียดของปัญหา</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${ticket.ticketDescription}</p>

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">รายละเอียดการซ่อม</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${ticket.ticketSolveDetail}</p>

                    </div>
                </div>
                <%--<div class="form-group">
                    <label class="col-sm-2 control-label">ระยะเวลาแก้ไข</label>
                    <div class="col-sm-4">
                        <p class="form-control-static">${ticket.ticketOngoingDate - ticket.ticketDate}</p>

                    </div>
                </div>--%>
                <div class="form-group">
                    <label class="col-sm-2 control-label">ให้คะแนน</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="review">
                            <option value="5">ดีมาก</option>
                            <option value="4">ดี</option>
                            <option value="3">ปานกลาง</option>
                            <option value="2">แย่</option>
                            <option value="1">แย่มาก</option>
                        </select>
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
