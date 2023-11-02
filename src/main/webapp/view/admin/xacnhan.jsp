<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<style>
	.nav-flex-1{
            	display: flex;
            	justify-content: center;
            	align-items: center;
            }
</style>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark ps-fixed">
            <div class="container">
                <a class="navbar-brand" href="htsua">HC-Shop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        
                        	<li class="nav-item">
                            <a class="nav-link" href="#">Tài khoản Admin</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="quanlysuaController">QL Sữa</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="quanlyloaiController">QL Loại</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="xacnhanController">Xác nhận</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="danhsachchuyentienController">KH chuyển tiền</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="thongkeController">Thống kê</a>
                        	</li>
                        
                        <c:if test="${dn != null}">
                        	<li class="nav-item">
                            <a class="nav-link" href="#">Hello ${dn.tendn}</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="dangxuatController">Logout</a>
                        </li>
                        </c:if>
                        <c:if test="${dn == null}">
                        	<li class="nav-item">
                            <a class="nav-link" href="dangnhapController">Login</a>
                        </li>
                        	<li class="nav-item">
                            <a class="nav-link" href="#">Signup</a>
                        </li>
                        </c:if>
                    </ul>

                    <form action="timkiemController" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value="${tk}" name="txttk" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>

		<div class="container">
			<table border="1" width="800" valign="top" class="table table-light" class="table table-hover">
			<thead>
			<tr style="background-color: #435d7d;color: #fff">
				<th scope="col">STT</th>
				<th scope="col">Tên Khách Hàng</th>
				<th scope="col">Tên Sữa</th>
				<th scope="col">Giá</th>
				<th scope="col">Số Lượng Mua</th>
				<th scope="col">Thành Tiền</th>
				<th scope="col">Xác Nhận Thanh Toán</th>
			</tr>
		</thead>
		<tbody>	
	<%--!  varStatus: để đếm số thứ tự
			.index: bắt đầu từ 0
			.count: bắt đầu từ 1--%>
   		<c:forEach items="${dsxn}" var="xn" varStatus="stt">
		<tr>
			<td>${stt.count}</td>
			<td>${xn.tendn}</td>
			<td>${xn.tensua}</td>
			<td>${xn.ngaymua}</td>
			<td>${xn.gia}</td>
			<td>${xn.thanhtien}</td>
			<td><a
				href="xacnhanchuyentienController?machuyentien=${xn.macthd}">
					Xác nhận </a></td>
		</tr>
		
		</c:forEach>
		<tbody>
	</table>
		</div>
</body>
</html>

