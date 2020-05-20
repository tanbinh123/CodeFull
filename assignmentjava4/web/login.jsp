<%-- 
Document   : login
Created on : Sep 17, 2019, 10:52:42 PM
Author     : thanh
--%>
<%@ page import="com.poly.Util.RequestAction" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (request.getSession().getAttribute("USER") != null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <meta name="description" content="Responsive Admin Template">
        <meta name="author" content="SmartUniversity">
        <title>Smile Admin | Bootstrap Responsive Admin Template</title>
        <!-- google font -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet" type="text/css">
        <!-- icons -->
        <link href="fonts\font-awesome\css\font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="fonts\material-design-icons\material-icon.css" rel="stylesheet" type="text/css">
        <!-- bootstrap -->
        <link href="assets\plugins\bootstrap\css\bootstrap.min.css" rel="stylesheet" type="text/css">
        <!-- style -->
        <link rel="stylesheet" href="assets\css\pages\extra_pages.css">
        <!-- favicon -->
        <link rel="shortcut icon" href="assets\img\favicon.ico"> 
    </head>
    <body>
        <div class="form-title">
            <h1>HỆ THỐNG QUẢN TRỊ</h1>
        </div>
        <!-- Login Form-->
        <a href="WEB-INF/web.xml"></a>
        <div class="login-form text-center">
            <div class="toggle"><i class="fa fa-user-plus"></i>
            </div>
            <div class="form formLogin">
                <h2>Đăng Nhập Tài khoản</h2>
                <%
                    if (request.getSession().getAttribute("ERROR") != null) {
                %>
                <div class="alert alert-danger">
                    <% out.println(request.getSession().getAttribute("ERROR")); %>
                </div>
                <%
                        request.getSession().removeAttribute("ERROR");
                    }
                %>
                <form action="UserController" method="POST">
                    <input type="text" placeholder="Tài khoản" name="username"
                           value='<%
                               if (request.getSession().getAttribute("username") != null) {
                                   out.println(request.getSession().getAttribute("username"));
                                   request.getSession().removeAttribute("username");
                               }
                           %>'
                           >
                     <input type="password" placeholder="Mật khẩu" name="password"> 
                    <div class="remember text-left">
                        <div class="checkbox checkbox-primary">
                            <input id="checkbox2" type="checkbox" checked="">
                            <label for="checkbox2">
                                Ghi nhớ tài khoản
                            </label>
                        </div>
                    </div>
                    <input type="hidden" name="_action" value="${RequestAction.LOGIN}"> 
                    <button type="submit">Đăng nhập</button>
                    <div class="forgetPassword"><a href="javascript:void(0)">Quên mật khẩu</a>
                    </div>
                </form>
            </div>
            <div class="form formRegister">
                <h2>Tạo tài khoản</h2>
                <form action="UserController" method="POST">
                    <input type="text" placeholder="Tên Tài Khoản">
                    <input type="password" placeholder="Password">
                    <input type="text" placeholder="Full Name">
                    <input type="tel" placeholder="Phone Number">
                    <input type="text" placeholder="Email">
                    <!--<input type="hidden" name="_action" value="//"-->
                    <button>Đăng kí</button>
                </form>
            </div>
            <div class="form formReset">
                <h2>Reset your password?</h2>
                <form>
                    <input type="email" placeholder="Email Address">
                    <button>Send Verification Email</button>
                </form>
            </div>
        </div>
        <!-- start js include path -->
        <script src="assets\plugins\jquery\jquery.min.js"></script>
        <script src="assets\js\pages\extra_pages\pages.js"></script>
        <!-- end js include path -->
    </body>
</html>
