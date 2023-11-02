<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="bean.taikhoanbean"%>
<%@page import="bean.lichsumuahangbean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.lichsumuahangdao"%>
<%@page import="bo.loaibo"%>
<%@page import="bo.suabo"%>
<%@page import="bean.suabean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.suadao"%>
<%@page import="dao.loaidao"%>
<%@page import="bean.loaibean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<style>
body {
	width: 100vw;
	overflow-x: hidden;
}

* {
	box-sizing: border-box;
}

.box {
	display: flex;
}

.box__item {
	display: flex;
	flex-direction: column;
}

.img {
	margin-right: 16px;
}

.header {
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}

.table {
	width: 100vw;
}

.table__item {
	margin-top: 40px;
}

.paddingBottom {
	padding-bottom: 8px;
}

.container {
	display: flex;
	width: 100vw;
}

.containerItem {
	width: 200px;
}

.containerItem.maxWidth {
	flex: 1;
}

.pagination {
	display: flex;
	justify-content: center;
	width: 100%;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	border-radius: 5px;
	transition: background-color .3s;
	border: 1px solid #ddd; /* Gray */
	margin: 0 2px;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

.navContent {
	display: flex;
	flex-direction: column;
}

.box {
	display: flex;
}

.navItem {
	width: 100%;
	padding: 8px 0;
	border-bottom: 1px solid #ccc;
	text-decoration: none;
	text-transform: none;
}

a:hover {
	color: #23527c;
	text-decoration: none;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark ps-fixed">
		<div class="container">
			<a class="navbar-brand" href="htsua">HC-Shop</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">

					<li class="nav-item"><a class="nav-link" href="#">Tài
							khoản Customer</a></li>
					<li class="nav-item"><a class="nav-link"
						href="htgio">Giỏ hàng</a></li>
					<li class="nav-item"><a class="nav-link"
						href="lichsumuahangController">Lịch sử mua hàng</a></li>

					<c:if test="${dn != null}">
						<li class="nav-item"><a class="nav-link" href="#">Hello
								${dn.tendn}</a></li>
						<li class="nav-item"><a class="nav-link"
							href="dangxuatController">Logout</a></li>
					</c:if>
					<c:if test="${dn == null}">
						<li class="nav-item"><a class="nav-link"
							href="dangnhapController">Login</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Signup</a>
						</li>
					</c:if>
				</ul>

				<form action="timkiemController" method="post"
					class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm">
						<input value="${tk}" name="txttk" type="text" class="form-control"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Search...">
						<div class="input-group-append">
							<button type="submit" class="btn btn-secondary btn-number">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
					<a class="btn btn-success btn-sm ml-3" href="show"> <i
						class="fa fa-shopping-cart"></i> Cart <span
						class="badge badge-light">3</span>
					</a>
				</form>
			</div>
		</div>
	</nav>

	<div style="margin-top: 24px" class="container">
		<table border="1" width="800" valign="top" class="table table-light">

		<thead>
			<tr style="background-color: #435d7d; color: #fff;">
				<th scope="col">STT</th>
				<th scope="col">Mã Khách Hàng</th>
				<th scope="col">Tên Sữa</th>
				<th scope="col">Giá</th>
				<th scope="col">Số Lượng Mua</th>
				<th scope="col">Thành Tiền</th>
				<th scope="col">Xác nhận thanh toán</th>
			</tr>
		</thead>
		<tbody>
				<c:if test="${dslichsu != null}">
					<c:forEach items="${dslichsu}" var="s" varStatus="stt">
						<tr>
						<td>${stt.count}</td>
						<td>${s.matk}</td>
						<td>${s.tensua}</td>
						<td>${s.gia}</td>
						<td>${s.soluongmua}</td>
						<td>${s.thanhtien}</td>
						<td>
							<c:if test="${s.damua == true}">
						<h6>Đã xác nhận thanh toán</h6>
					</c:if>
					<c:if test="${s.damua == false}">
						<h6>Chưa xác nhân thanh toán</h6>
					</c:if>
						</td>
						</tr>
					</c:forEach>
				</c:if>
			
			<c:if test="${dslichsu == null}">
				<h6>Bạn chưa có đơn hàng, mời bạn <a href="htsua">đặt mua hàng tại đây</a></h6>
			</c:if>
		</tbody>
	</table>
	</div>

</body>
</html>
