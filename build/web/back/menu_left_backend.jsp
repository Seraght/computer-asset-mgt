<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="${pageContext.request.contextPath}/back">หน้าแรก<span class="sr-only">(current)</span></a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li>ระบบแจ้งซ่อม</li>
                <li><a href="/cam/viewallticket">รายการแจ้งซ่อมทั้งหมด</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li>จัดการครุภัณฑ์</li>
                <li><a href="/cam/addform">เพิ่มครุภัณฑ์</a></li>
                <li><a href="/cam/searchform">ค้นหาครุภัณฑ์</a></li>
                <li><a href="/cam/viewdeleteasset">ครุภัณฑ์ที่ถูกลบ</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li>ระบบส่งมอบครุภัณฑ์</li>
                <li><a href="/cam/back/search_deliver.jsp">รายการส่งมอบ</a></li>
                <li><a href="/cam/matchdeliver">ส่งมอบครุภัณฑ์</a></li>
            </ul>
        </div>