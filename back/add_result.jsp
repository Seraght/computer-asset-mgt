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
            <p>${message}</p>
            <a class="btn btn-default" href="/cam/addform" role="button">Back</a>
        </div>

        <%@include file="/js_tag.html" %>
    </body>
</html>
