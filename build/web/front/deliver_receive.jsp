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
        <%@ include file="/front/menu_left_backend.jsp"%>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h1 class="page-header">รับมอบครุภัณฑ์</h1>
            <c:choose>
                <c:when test="${message==null}">
                    
                    <form class="form-horizontal" action="/cam/acceptdeliver" method="post">

                        <div class="form-group">
                            <h4 class="col-sm-2 control-label">ชื่อผู้รับมอบ</h4>
                            <div class="col-sm-4">
                                <h4 class="form-control-static">${person.firstName}&nbsp;${person.lastName}</h4>
                            </div>
                            <input type="hidden" class="form-control" id="deliverID" value="${deliver.deliverID}" name="deliverID">
                        </div>
                        <div class="form-group">
                            <h4 class="col-sm-2 control-label">ครุภัณฑ์ที่ส่งมอบ</h4>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">หมายเลขครุภัณฑ์</label>
                            <div class="col-sm-4">
                                <p class="form-control-static">${computer.assetNumber}</p>
                                
                                <input type="hidden" class="form-control" id="assetNumber" value="${computer.assetNumber}" name="assetNumber">
                            </div>
                            <label class="col-sm-2 control-label">ยี่ห้อ - รุ่น</label>
                            <div class="col-sm-4">
                                <p class="form-control-static">${computer.spec["brand"]}&nbsp;${computer.spec["model"]}</p>
                            </div>

                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default" >รับมอบ</button>

                            </div>
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    ${message}
                </c:otherwise>
            </c:choose>
        </div>

        <%@include file="/js_tag.html" %>
    </body>
</html>
