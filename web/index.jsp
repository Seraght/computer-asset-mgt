<%-- 
    Document   : index
    Created on : May 5, 2016, 10:46:43 AM
    Author     : Seraght
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/header_tag.html" %>
    <link rel="stylesheet" href="/css/normalize.css">
    <style>
        /* CSS Document */

        body {
            width:100px;
            height:100px;
            background: -webkit-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* Chrome 10+, Saf5.1+ */
            background:    -moz-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* FF3.6+ */
            background:     -ms-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* IE10 */
            background:      -o-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* Opera 11.10+ */
            background:         linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* W3C */
            font-family: 'Raleway', sans-serif;
        }

        p {
            color:#CCC;
        }

        .spacing {
            padding-top:0px;
            padding-bottom:7px;
        }
        .middlePage {
            width: 680px;
            height: 500px;
            position: absolute;
            top:0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
        }

        .logo {
            color:#CCC;
        }
    </style>
    <script src="/js/prefixfree.min.js"></script>
    <body>
        <div class="middlePage">
            <div class="page-header">
                <h1 class="logo">Computer Asset Management System <small>สำนักงานคณะกรรมการส่งเสริมการลงทุน</small></h1>
            </div>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">

                    <div class="row">

                        <div class="col-md-5" >
                            <h3 class="panel-title spacing">คำแนะนำ</h3>
                            <small>- แนะนำให้ใช้ Google Chrome หรือ Firefox</small><br>
                            <small>- สำหรับ Internet Explorer หากกดปุ่ม "Login" แล้วนิ่ง ให้ติดตั้ง Internet Explorer เวอร์ชั่น 10 ขึ้นไป</small><br>
                            <small>- ดาวน์โหลดโปรแกรมเวอร์ชั่นล่าสุดได้ที่ http://browsehappy.com</small><br>
                            <small>- หากติดปัญหาในการใช้งานระบบ สามารถแจ้งได้ที่ เบอร์โทรศัพท์ 8415 หรือ <a href="mailto:nuttapong.j@boi.go.th" target="_top">nuttapong.j@boi.go.th</a></small>
                        </div>

                        <div class="col-md-7" style="border-left:1px solid #ccc;height:160px">
                            <h3 class="panel-title spacing">บัญชีผู้ใช้งาน</h3>
                            <form class="form-horizontal" method="post" action="/cam/login">
                                <fieldset>

                                    <input id="textinput" name="username" type="text" placeholder="Username" class="form-control input-md spacing" required="required">
                                    <br>
                                    <input id="textinput" name="password" type="password" placeholder="Password" class="form-control input-md spacing" required="required">
                                    <br>
                                    <button id="singlebutton" name="singlebutton" class="btn btn-info btn-sm pull-right">Login</button>


                                </fieldset>
                            </form>
                        </div>

                    </div>

                </div>
            </div>


        </div>

        <%@include file="/js_tag.html" %>
    </body>
</html>
