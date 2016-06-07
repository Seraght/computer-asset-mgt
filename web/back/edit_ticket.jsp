<%-- 
    Document   : index
    Created on : Mar 27, 2016, 10:11:19 PM
    Author     : Seraght
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="/header_tag.html" %>
    <body>
        <jsp:include page="/menu_top.jsp" />
        <%@ include file="/back/menu_left_backend.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            
            <h1 class="page-header">รายละเอียดการแจ้งซ่อม</h1>
            ${message}
            <form class="form-horizontal" action="/cam/updateticketadmin" method="post">
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
                        <p class="form-control-static">${ticket.ticketTitle}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" >รายละเอียดของปัญหา</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${ticket.ticketDescription}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">สถานะการแจ้งซ่อม</label>
                    <div class="col-sm-4">
                        <select class="form-control" name="ticketStatus">
                            <c:choose>
                                <c:when test="${ticket.ticketStatus == 1}">
                                    <c:set var="choose1" value="selected"/>
                                </c:when>
                                <c:when test="${ticket.ticketStatus == 2}">
                                    <c:set var="choose2" value="selected"/>
                                </c:when>
                                <c:when test="${ticket.ticketStatus == 3}">
                                    <c:set var="choose3" value="selected"/>
                                </c:when>
                                <c:when test="${ticket.ticketStatus == 4}">
                                    <c:set var="choose4" value="selected"/>
                                </c:when>
                            </c:choose>
                            <option value="1" ${choose1}>เปิดใหม่</option>
                            <option value="2" ${choose2}>รับเรื่อง</option>
                            <option value="3" ${choose3}>ส่งซ่อม</option>
                            <option value="4" ${choose4}>แก้ไขแล้ว</option>
                            <option value="5" ${choose5}>ปิดงาน</option>
                        </select>
                    </div>
                </div>   
                <div class="form-group">
                    <label class="col-sm-2 control-label">รายละเอียดการแจ้งซ่อม</label>
                    <div class="col-sm-10">
                        <textarea rows="6" cols="50" name="ticketSolveDetail" class="form-control" id="ticketSolveDetail">${ticket.ticketSolveDetail}</textarea>
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
