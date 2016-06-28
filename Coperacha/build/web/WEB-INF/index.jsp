<%-- 
    Document   : index
    Created on : 27-jun-2016, 16:25:18
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Coperacha S.A.</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
</head>
<body id="top">
    <form id="form1" runat="server">
<div class="wrapper">
  <div id="header">
    <div id="logo">
      <h1 style="width: 354px">Coperacha S.A.</h1>
      <p>Comience su proyecto aquí</p>
    </div>
    <div id="topnav">
      <ul>
        <li class="active"><a href="index.jsp">Inicio</a></li>
        <li><a href="login.jsp">Iniciar Sesión</a></li>
      </ul>
    </div>
    <br class="clear" />
  </div>
</div>

<div class="wrapper">
  <div id="intro">
      <asp:ContentPlaceHolder ID="ContentPlaceHolder1" runat="server">
      </asp:ContentPlaceHolder>
    <br class="clear" />
      <br />
  </div>
</div>
<div class="wrapper">
  <div id="container">
    <br class="clear" />
  </div>
</div>
<div class="wrapper">
  <div id="footer">
  </div>
</div>
<div class="wrapper">
  <div id="copyright">
    <p class="fl_left">Copyright &copy; 2016 - All Rights Reserved - Coperacha S.A.</p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
    <br class="clear" />
  </div>
</div>
    </form>
</body>
</html>