/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-25 11:47:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <title>用户登录</title>\r\n");
      out.write("  <style>\r\n");
      out.write("    * {\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    html {\r\n");
      out.write("      height: 100%;\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      overflow: hidden;\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      padding: 0;\r\n");
      out.write("      background: url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/image/1.gif\") no-repeat 0px 0px;\r\n");
      out.write("      background-repeat: no-repeat;\r\n");
      out.write("      background-size: 100% 100%;\r\n");
      out.write("      -moz-background-size: 100% 100%;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div style=\"width:400px;height:270px; margin:auto;position:absolute;top:0;bottom:0;left:0;right:0;border:1px solid black;background-color:#87CEEB;\">\r\n");
      out.write("  <div style=\"position:absolute;width:400px;height:50px;font-size:30px;background-color:#00BFFF;text-align:center\">用&nbsp;&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录</div>\r\n");
      out.write("  <div style=\"position:absolute;left:10px;top:70px;width:100px;height:30px;font-size:25px;\">account</div>\r\n");
      out.write("  <div style=\"position:absolute;left:10px;top:120px;width:100px;height:30px;font-size:25px;\">password</div>\r\n");
      out.write("  <form method=\"get\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/login\">\r\n");
      out.write("    <input type=\"text\" name=\"account\" id=\"account\" style=\"position:absolute;left:140px;top:70px;width:200px;height:30px;font-size:20px;\"><br/>\r\n");
      out.write("    <input type=\"password\" name=\"password\" id=\"password\" style=\"position:absolute;left:140px;top:120px;width:200px;height:30px;font-size:20px;\"><br/>\r\n");
      out.write("    <input type=\"submit\" value=\"登    录\" style=\"position:absolute;left:70px;top:170px;width:260px;height:50px;font-size:30px;background-color:#3CB371;\">\r\n");
      out.write("    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/toAddUser\" style=\"text-decoration:none; position:absolute;left:0px;top:245px;background-color:#87CEEB;border:1px solid\">注册新用户 </a>\r\n");
      out.write("    <input type=\"button\" value=\"忘记密码\" style=\"position:absolute;left:320px;top:245px;background-color:#87CEEB;border:none\">\r\n");
      out.write("  </form>\r\n");
      out.write("</div>\r\n");
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
