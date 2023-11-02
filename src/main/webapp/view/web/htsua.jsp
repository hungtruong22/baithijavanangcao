<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HC-Shop</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
    .pd-top-100{
    	padding-top: 100px;
    }
    .ps-fixed{
    	position: fixed;
    	width: 100%;
    	z-index: 1000;
    	box-shadow: 2px 2px 4px #000;
    }
    .text-color{
    	color: #f1a21f!important;
    	font-weight: 500;
    }
    .list-cate:hover{
    	background-color: #007bff;
    	cursor: pointer;
    	transition: all 0.8s;
    }
    .cate-link{
    	text-decoration: none!important;
    }
    .anh{
    	width: 100%;
    	height: 140px;
    }
    </style>
    <body>
        <!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark ps-fixed">
            <div class="container">
                <a class="navbar-brand" href="htsua">HC-Shop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <c:if test="${dn.isadmin == true}">
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
                        </c:if>
                        <c:if test="${dn.iscustomer == true}">
                        	<li class="nav-item">
                            <a class="nav-link" href="#">Tài khoản Customer</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="htgio">Giỏ hàng</a>
                        	</li>
                        	<li class="nav-item">
                            <a class="nav-link" href="lichsumuahangController">Lịch sử mua hàng</a>
                        	</li>
                        </c:if>
                        
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
                        <c:if test="${dn.iscustomer == true}">
                        <a class="btn btn-success btn-sm ml-3" href="show">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">3</span>
                        </a>
                        </c:if>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center pd-top-100">
            <div class="container ">
                <h1 class="jumbotron-heading">Thế giới sữa Huế</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 30 năm cung cấp các sản phầm sữa chất lượng tại Huế</p>
            </div>
        </section>
        <!--end of menu-->
       
        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase">
                        <i class="fa fa-list"></i> Categories</div>
                        <ul class="list-group category_block">
                        	<li class="list-group-item text-white list-cate">
                                <a class="text-color cate-link" href="htsua">Tất cả sản phẩm</a>
                                </li>
                                
                            <c:forEach items="${dsloai}" var="l">
                            <c:if test="${maloai == l.maloai}">
                                <li class="list-group-item text-white list-cate active">
                                <a class="text-color cate-link" href="categoryController?maloai=${l.maloai}">${l.tenloai}</a>
                                </li>
                                </c:if>
                             <c:if test="${maloai != l.maloai}">
                             	 <li class="list-group-item text-white list-cate">
                                <a class="text-color cate-link" href="categoryController?maloai=${l.maloai}">${l.tenloai}</a>
                                </li>
                             </c:if>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">Mặt hàng mới</div>
                        <div class="card-body">
                            <img class="img-fluid" src="${last.anh}" />
                            <h5 class="card-title">${last.tensua}</h5>
                            <p class="card-text">${last.tenncc}</p>
                            <p class="bloc_left_price">${last.gia} vnđ</p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-9">
                    <div class="row">
                        <c:forEach items="${dssua}" var="s">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div style="margin-bottom: 12px" class="card">
                                    <img class="card-img-top" src="${s.anh}" alt="Card image cap">
                                    <div class="card-body">
                                        <h4 class="card-text">
                                        <a href="chitietthongtinController?sid=${s.masua}" title="View Product">${s.tensua}
                                        </a>
                                        </h4>
                                        <p class="card-title show_txt">${s.thongtin}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block">${s.gia} vnđ</p>
                                            </div>
                                            <div class="col">
                                                <a href="giohangController?masua=${s.masua}&tensua=${s.tensua}&gia=${s.gia}&anh=${s.anh}" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
               			
               				<nav aria-label="Page navigation example">
				  			<ul class="pagination">
								<c:forEach begin="1" end="${endPage}" var="i">
								<c:if test="${tag==i}">
									<li class="page-item active">
								 	<a class="page-link" href="htsua?trang=${i}">${i}</a>
								 	</li>
								</c:if>	
								<c:if test="${tag != i}">						
								 	<li class="page-item">
								 	<a class="page-link" href="htsua?trang=${i}">${i}</a>
								 	</li>
								 </c:if>	
  								</c:forEach>
  							</ul>
							</nav>	
               			
                </div>               
            </div>
            
        </div>

        <!-- Footer -->
        <footer style="background-color: #343a40; margin-top: 24px" class="text-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-4 col-xl-3">
                        <h5>About</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <p class="mb-0">
                            Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression.
                        </p>
                    </div>

                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                        <h5>Informations</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                        <h5>Others links</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><a href="">Link 1</a></li>
                            <li><a href="">Link 2</a></li>
                            <li><a href="">Link 3</a></li>
                            <li><a href="">Link 4</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 col-lg-3 col-xl-3">
                        <h5>Contact</h5>
                        <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                        <ul class="list-unstyled">
                            <li><i class="fa fa-home mr-2"></i> My company</li>
                            <li><i class="fa fa-envelope mr-2"></i> email@example.com</li>
                            <li><i class="fa fa-phone mr-2"></i> + 33 12 14 15 16</li>
                            <li><i class="fa fa-print mr-2"></i> + 33 12 14 15 16</li>
                        </ul>
                    </div>
                    <div class="col-12 copyright mt-3">
                        <p class="float-left">
                            <a href="#">Back to top</a>
                        </p>
                     
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>

