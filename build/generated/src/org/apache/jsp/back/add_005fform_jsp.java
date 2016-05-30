package org.apache.jsp.back;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/header_tag.html");
    _jspx_dependants.add("/back/menu_left_backend.jsp");
    _jspx_dependants.add("/js_tag.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <link rel=\"icon\" href=\"/cam/images/favicon.ico\">\n");
      out.write("\n");
      out.write("        <title>Computer Asset Management - Board of Investment Thailand</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"/cam/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n");
      out.write("        <link href=\"/cam/css/ie10-viewport-bug-workaround.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this template -->\n");
      out.write("        <link href=\"/cam/css/dashboard.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\n");
      out.write("        <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\n");
      out.write("        <script src=\"/cam/js/ie-emulation-modes-warning.js\"></script>\n");
      out.write("    </head>");
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/menu_top.jsp", out, false);
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-3 col-md-2 sidebar\">\n");
      out.write("            <ul class=\"nav nav-sidebar\">\n");
      out.write("                <li class=\"active\"><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/back\">หน้าแรก<span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"nav nav-sidebar\">\n");
      out.write("                <li>ระบบแจ้งซ่อม</li>\n");
      out.write("                <li><a href=\"/cam/viewallticket\">รายการแจ้งซ่อมทั้งหมด</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"nav nav-sidebar\">\n");
      out.write("                <li>จัดการครุภัณฑ์</li>\n");
      out.write("                <li><a href=\"/cam/back/add_form.jsp\">เพิ่มครุภัณฑ์</a></li>\n");
      out.write("                <li><a href=\"/cam/back/search_form.jsp\">ค้นหาครุภัณฑ์</a></li>\n");
      out.write("                \n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"nav nav-sidebar\">\n");
      out.write("                <li>ระบบส่งมอบครุภัณฑ์</li>\n");
      out.write("                <li><a href=\"/cam/back/search_deliver.jsp\">รายการส่งมอบ</a></li>\n");
      out.write("                <li><a href=\"/cam/matchdeliver\">ส่งมอบครุภัณฑ์</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\n");
      out.write("            <h1 class=\"page-header\">เพิ่มครุภัณฑ์</h1>\n");
      out.write("\n");
      out.write("            <form class=\"form-horizontal\" action=\"/cam/addasset\" method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputAssetNumber\" class=\"col-sm-2 control-label\">หมายเลขครุภัณฑ์</label>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"assetNumber\" placeholder=\"58-1-001-01\" name=\"assetNumber\">\n");
      out.write("                    </div>\n");
      out.write("                    <label for=\"inputTypeID\" class=\"col-sm-2 control-label\">ประเภทครุภัณฑ์</label>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <select class=\"form-control\" name=\"typeID\">\n");
      out.write("                            <option value=\"1\">คอมพิวเตอร์</option>\n");
      out.write("                            <option value=\"2\">โน้ตบุ้ค</option>\n");
      out.write("                            <option value=\"3\">แท็ปเล็ต, โทรศัพท์เคลื่อนที่</option>\n");
      out.write("                            <option value=\"4\">ปริ้นเตอร์</option>\n");
      out.write("                            <option value=\"5\">แสกนเนอร์</option>\n");
      out.write("                            <option value=\"6\">เนตเวิร์ค</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary\" id=\"myBtn\">+</button>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputModel\" class=\"col-sm-2 control-label\">รุ่น</label>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"model\" placeholder=\"Optiplex 7010DT\" name=\"model\">\n");
      out.write("                    </div>\n");
      out.write("                    <label for=\"inputBrand\" class=\"col-sm-2 control-label\">ยี่ห้อ</label>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"brand\" placeholder=\"Dell\" name=\"brand\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputPrice\" class=\"col-sm-2 control-label\">ราคา</label>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"price\" placeholder=\"10,000\" name=\"price\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"inputDescription\" class=\"col-sm-2 control-label\">รายละเอียดเพิ่มเติม</label>\n");
      out.write("                    <div class=\"col-sm-10\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" id=\"description\" placeholder=\"ใส่รายละเอียดเพิ่มเติม\" name=\"description\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <!-- Modal -->\n");
      out.write("            <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"mySmallModalLabel\">\n");
      out.write("  <div class=\"modal-dialog modal-sm\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n");
      out.write("        <h4 class=\"modal-title\"><span class=\"glyphicon glyphicon-pencil\"></span> เพิ่มยี่ห้อ</h4>\n");
      out.write("\t  </div>\n");
      out.write("\t  <form role=\"form\" action=\"/cam/addbrand\" method=\"post\">\n");
      out.write("\t  <div class=\"modal-body\">\n");
      out.write("\t  \n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" id=\"brand\" placeholder=\"โปรดระบุชื่อยี่ห้อที่ต้องการเพิ่ม\">\n");
      out.write("\t  \n");
      out.write("\t  </div>\n");
      out.write("\t  <div class=\"modal-footer\">\n");
      out.write("\t\t<button type=\"submit\" class=\"btn btn-success\"><span class=\"glyphicon glyphicon-off\" aria-hidden=\"true\"></span> เพิ่ม</button>\n");
      out.write("\t\t<button type=\"submit\" class=\"btn btn-danger btn-default\" data-dismiss=\"modal\"><span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span> ยกเลิก</button>\n");
      out.write("\t  </div>\n");
      out.write("\t  </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("            ");
      out.write("<!-- Bootstrap core JavaScript\n");
      out.write("    ================================================== -->\n");
      out.write("<!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("<script>window.jQuery || document.write('<script src=\"/js/jquery.min.js\"><\\/script>')</script>\n");
      out.write("<script src=\"/cam/js/bootstrap.min.js\"></script>\n");
      out.write("<!-- Just to make our placeholder images work. Don't actually copy the next line! -->\n");
      out.write("<script src=\"/cam/js/holder.min.js\"></script>\n");
      out.write("<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n");
      out.write("<script src=\"/cam/js/ie10-viewport-bug-workaround.js\"></script>");
      out.write("\n");
      out.write("            <script>\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $(\"#myBtn\").click(function () {\n");
      out.write("                        $(\"#myModal\").modal();\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
