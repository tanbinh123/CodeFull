<%-- 
    Document   : sidebả
    Created on : Oct 13, 2019, 10:09:44 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="sidebar-container">
    <div class="sidemenu-container navbar-collapse collapse fixed-menu">
        <div id="remove-scroll">
            <ul class="sidemenu  page-header-fixed" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
                <li class="sidebar-toggler-wrapper hide">
                    <div class="sidebar-toggler">
                        <span></span>
                    </div>
                </li>
                <li class="sidebar-user-panel">
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="assets\img\dp.jpg" class="img-circle user-img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p> ${sessionScope.USER.fullname}</p>
                            <a href="#"><i class="fa fa-circle user-online"></i><span class="txtOnline"> Online</span></a>
                        </div>
                    </div>
                </li>
                <li class="nav-item start ">
                    <a href="#" class="nav-link nav-toggle">
                        <i class="material-icons">dashboard</i>
                        <span class="title">Quản Lý Mặt hàng</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub-menu">
                        <li class="nav-item">
                            <a href="view-cart.jsp" class="nav-link ">
                                <span class="title">Các mặt hàng</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="user-cart.jsp" class="nav-link ">
                                <span class="title">Giỏ hàng của bạn</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>