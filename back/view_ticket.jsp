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
            <h4 class="sub-header">${message}</h4>
            <div class="table-responsive">
                <c:choose>
                    <c:when test="${tickets!=null}">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>ลำดับที่</th>
                                    <th>วันที่-เวลา</th>
                                    <th>เรื่องที่แจ้ง</th>
                                    <th>ชื่อผู้แจ้ง</th>
                                    <th>สถานะ</th>
                                    <th>แก้ไข</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${tickets}" var="t" varStatus="vs" >
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
                                        <td>${t.ticketDate}</td>
                                        <td>${t.ticketTitle}</td>
                                        <td>${t.firstName}&nbsp;${t.lastName}</td>
                                        <td>${t.ticketStatusName}</td>
                                        <td align="center"><a href="/cam/editticketstatus?ticketID=${t.ticketID}"><img src="images/edit_icon_mini.png" class="img-responsive"></a></td> 
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
