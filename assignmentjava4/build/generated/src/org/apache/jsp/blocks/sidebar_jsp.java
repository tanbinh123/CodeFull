package org.apache.jsp.blocks;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sidebar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("\n");
      out.write("<div class=\"sidebar-container\">\n");
      out.write("    <div class=\"sidemenu-container navbar-collapse collapse fixed-menu\">\n");
      out.write("        <div id=\"remove-scroll\">\n");
      out.write("            <ul class=\"sidemenu  page-header-fixed\" data-keep-expanded=\"false\" data-auto-scroll=\"true\" data-slide-speed=\"200\" style=\"padding-top: 20px\">\n");
      out.write("                <li class=\"sidebar-toggler-wrapper hide\">\n");
      out.write("                    <div class=\"sidebar-toggler\">\n");
      out.write("                        <span></span>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"sidebar-user-panel\">\n");
      out.write("                    <div class=\"user-panel\">\n");
      out.write("                        <div class=\"pull-left image\">\n");
      out.write("                            <img src=\"assets\\img\\dp.jpg\" class=\"img-circle user-img-circle\" alt=\"User Image\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pull-left info\">\n");
      out.write("                            <p> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USER.fullname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-circle user-online\"></i><span class=\"txtOnline\"> Online</span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item start \">\n");
      out.write("                    <a href=\"index.jsp\" class=\"nav-link nav-toggle\">\n");
      out.write("                        <i class=\"material-icons\">dashboard</i>\n");
      out.write("                        <span class=\"title\">Trang Chủ</span>\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item start \">\n");
      out.write("                    <a href=\"#\" class=\"nav-link nav-toggle\">\n");
      out.write("                        <i class=\"material-icons\">dashboard</i>\n");
      out.write("                        <span class=\"title\">Quản Lý USER-PRODUCT</span>\n");
      out.write("                        <span class=\"arrow\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <ul class=\"sub-menu\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"update-user.jsp\" class=\"nav-link \">\n");
      out.write("                                <span class=\"title\">Update thành viên</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"list-user.jsp\" class=\"nav-link \">\n");
      out.write("                                <span class=\"title\">Danh sách thành viên</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"insert-user.jsp\" class=\"nav-link \">\n");
      out.write("                                <span class=\"title\">Thêm thành viên</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"show-product.jsp\" class=\"nav-link \">\n");
      out.write("                                <span class=\"title\">Mặt hàng</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a href=\"insert-product.jsp\" class=\"nav-link \">\n");
      out.write("                                <span class=\"title\">Thêm mặt hàng</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
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
