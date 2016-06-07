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

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">


                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            สรุปจำนวนครุภัณฑ์
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-donut-chart"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->

                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            สถานะของครุภัณฑ์
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-donut-chart2"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->

                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            สถิติการแจ้งซ่อม
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-bar-chart"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
                
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            ระยะเวลาการซ่อม
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-bar-chart2"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->


        </div>
    </div>
</div>
<%@include file="/js_tag.html" %>
<script>
    $(function () {
        Morris.Donut({
            element: 'morris-donut-chart',
            data: [{
                    label: "คอมพิวเตอร์",
                    value: ${count_asset.count_pc}
                }, {
                    label: "โน้ตบุ้ค",
                    value: ${count_asset.count_notebook}
                }, {
                    label: "ปริ้นเตอร์",
                    value: ${count_asset.count_printer}
                }, {
                    label: "แสกนเนอร์",
                    value: ${count_asset.count_scanner}
                }, {
                    label: "แท็ปเลต, โทรศัพท์มือถือ",
                    value: ${count_asset.count_tablet}
                }, {
                    label: "เนตเวิร์ค",
                    value: ${count_asset.count_network}
                }],
            resize: true
        });

        Morris.Donut({
            element: 'morris-donut-chart2',
            data: [{
                    label: "คลังเก็บของ",
                    value: ${count_asset.count_stock}
                }, {
                    label: "ส่งมอบ",
                    value: ${count_asset.count_deliver}
                }, {
                    label: "ลบ",
                    value: ${count_asset.count_delete}
                }, {
                    label: "บริจาค",
                    value: ${count_asset.count_donate}
                }],
            resize: true
        });

        Morris.Bar({
            element: 'morris-bar-chart',
            data: [{
                    y: 'ประเภทการแจ้งเรื่อง',
                    a: ${count_ticket.count_new},
                    b: ${count_ticket.count_ongoing},
                    c: ${count_ticket.count_pending},
                    d: ${count_ticket.count_resolve},
                    e: ${count_ticket.count_close}
                }],
            xkey: 'y',
            ykeys: ['a', 'b', 'c', 'd', 'e'],
            labels: ['เปิดใหม่', 'รับเรื่อง','ส่งซ่อม','แก้ไขแล้ว','ปิดงาน'],
            resize: true
        });
        
        Morris.Bar({
            element: 'morris-bar-chart2',
            data: [{
                    y: 'ประเภทการแจ้งเรื่อง',
                    a: ${count_time.count_0},
                    b: ${count_time.count_15},
                    c: ${count_time.count_30},
                    d: ${count_time.count_60}
                }],
            xkey: 'y',
            ykeys: ['a', 'b', 'c', 'd'],
            labels: ['ภายใน 15 นาที', 'ภายใน 30 นาที','ภายใน 60 นาที','1 ชั่วโมงขึ้นไป'],
            resize: true
        });
    });
</script>
</body>
</html>
