/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-26 02:54:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class connection_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>联系我们</title>\r\n");
      out.write("  <style>\r\n");
      out.write("    body{\r\n");
      out.write("      background-image: url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/5.jpg\");\r\n");
      out.write("      background-size: 100% 100%;\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      height: 100%;\r\n");
      out.write("      background-repeat: no-repeat;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2 >联系我们</h2>\r\n");
      out.write("<br>我们搭建了一个图书馆与读者联系的桥梁，您对图书馆的意见和建议，或者在使用图书馆资源过程中遇到的问题，都可以\r\n");
      out.write("<br>来图书馆或者电话、e-mail等形式向图书馆咨询和反映。读者对图书馆的意见和建议都将成为我们发展的动力，谢谢!\r\n");
      out.write("<h3>一、咨询服务内容、地点、电话</h3>\r\n");
      out.write("<br>\r\n");
      out.write("<div\r\n");
      out.write("        class=\"container\" style=\"width: 330px; position:relative; left: 30%; top: 5%; background-color: white\">\r\n");
      out.write("  <table class=\"tablelist\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">内容</th>\r\n");
      out.write("      <th style=\"width: 140px; text-align: center\">地点</th>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">电话</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">捐书</th>\r\n");
      out.write("      <th style=\"width: 140px; text-align: center\">308室</th>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">11209</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">赔书</th>\r\n");
      out.write("      <th style=\"width: 140px; text-align: center\">201室</th>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">12345</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">资产</th>\r\n");
      out.write("      <th style=\"width: 140px; text-align: center\">212室</th>\r\n");
      out.write("      <th style=\"width: 50px; text-align: center\">18976</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("\r\n");
      out.write("    </thead>\r\n");
      out.write("  </table>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<h3>二、E-mail咨询 请将问题通过主页的馆长信箱发给我们，你将会在1-2个工作日内收到我们的回复。</h3>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}