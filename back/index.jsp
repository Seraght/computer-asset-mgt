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
            <h1 class="page-header">Dashboard</h1>

            <div class="row placeholders">

                <div class="col-xs-6 col-sm-6 placeholder">
                    <p class="bg-info">สรุปการแจ้งปัญหา</p>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>สถานะ</th>
                                    <th>จำนวน</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>รวมทั้งหมด</td>
                                    <td>${count_ticket.count_sum}</td>
                                </tr>
                                <tr>
                                    <td>ปัญหาที่แจ้งเข้ามาใหม่</td>
                                    <td>${count_ticket.count_new}</td>
                                </tr>
                                <tr>
                                    <td>ปัญหาที่แก้ไขแล้ว</td>
                                    <td>${count_ticket.count_solve}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="col-xs-6 col-sm-6 placeholder">
                    <p class="bg-warning">สรุปสถานะการส่งมอบ</p>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>สถานะ</th>
                                    <th>จำนวน</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>รวมทั้งหมด</td>
                                    <td>${count_deliver.count_sum}</td>
                                </tr>
                                <tr>
                                    <td>ส่งมอบ</td>
                                    <td>${count_deliver.count_deliver}</td>
                                </tr>
                                <tr>
                                    <td>รับมอบ</td>
                                    <td>${count_deliver.count_accept}</td>
                                </tr>
                                <tr>
                                    <td>ยังไม่รับมอบ</td>
                                    <td>${count_deliver.count_deliver - count_deliver.count_accept}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-6 placeholder">
                    <p class="bg-success">สรุปการบริหารครุภัณฑ์คอมพิวเตอร์</p>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>สถานะ</th>
                                    <th>จำนวน</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>รวมทั้งหมด</td>
                                    <td>${count_asset.count_sum}</td>
                                </tr>
                                <tr>
                                    <td>คอมพิวเตอร์</td>
                                    <td>${count_asset.count_pc}</td>
                                </tr>
                                <tr>
                                    <td>โน้ตบุ้ค</td>
                                    <td>${count_asset.count_notebook}</td>
                                </tr>
                                <tr>
                                    <td>แท็ปเล็ต, โทรศัพท์เคลื่อนที่</td>
                                    <td>${count_asset.count_tablet}</td>
                                </tr>
                                <tr>
                                    <td>ปริ้นเตอร์</td>
                                    <td>${count_asset.count_printer}</td>
                                </tr>
                                <tr>
                                    <td>แสกนเนอร์</td>
                                    <td>${count_asset.count_scanner}</td>
                                </tr>
                                <tr>
                                    <td>เนตเวิร์ค</td>
                                    <td>${count_asset.count_network}</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="/js_tag.html" %>
</body>
</html>
