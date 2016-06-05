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
            <h1 class="page-header">ส่งมอบครุภัณฑ์</h1>

            <form class="form-horizontal" action="/cam/deliver" method="post">
                <div class="form-group col-md-6">
                    <label for="personList" class="col-sm-5 control-label col-sm-offset-2">ชื่อเจ้าหน้าที่</label>
                    <div class="col-sm-8 col-sm-offset-2 ">
                        <select class="form-control" name="personID">
                            <option value="${personID}">${personName}</option>
                            <c:choose>
                                <c:when test="${listPersons!=null}">
                                    <c:forEach items="${listPersons}" var="lp" >
                                        <option value="${lp.officerID}">${lp.firstName}&nbsp;${lp.lastName}</option>
                                    </c:forEach>
                                </c:when>
                            </c:choose>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="assetList" class="col-sm-6 control-label col-sm-offset-2">หมายเลขครุภัณฑ์</label>
                    <div class="col-sm-8 col-sm-offset-2">
                        <select class="form-control" name="assetID">
                            <option value="${assetID}">${assetYear}-${assetGet}-${assetNumber}-${typeID}</option>
                            <c:choose>
                                <c:when test="${listComputers!=null}">
                                    <c:forEach items="${listComputers}" var="lc" >
                                        <option value="${lc.assetID}">${lc.assetYear}-${lc.assetGet}-${lc.assetNumber}-${lc.typeID}</option>
                                    </c:forEach>
                                </c:when>
                            </c:choose>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-3">
                        <button type="submit" class="btn btn-default">Deliver</button>
                    </div>
                </div>
            </form>

            <%@include file="/js_tag.html" %>
    </body>
</html>
