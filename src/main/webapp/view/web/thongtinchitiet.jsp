<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style>
.gallery-wrap .img-big-wrap img {
	height: 450px;
	width: auto;
	display: inline-block;
	cursor: zoom-in;
}

.gallery-wrap .img-small-wrap .item-gallery {
	width: 60px;
	height: 60px;
	border: 1px solid #ddd;
	margin: 7px 2px;
	display: inline-block;
	overflow: hidden;
}

.gallery-wrap .img-small-wrap {
	text-align: center;
}

.gallery-wrap .img-small-wrap img {
	max-width: 100%;
	max-height: 100%;
	object-fit: cover;
	border-radius: 4px;
	cursor: zoom-in;
}

.img-big-wrap img {
	width: 100% !important;
	height: auto !important;
}

.ps-fixed2 {
	position: fixed;
	width: 100%;
	z-index: 1000;
	box-shadow: 2px 2px 4px #000;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	height: 78px;
}

.text-color {
	color: #f1a21f !important;
	font-weight: 500;
}

.list-cate:hover {
	background-color: #007bff;
	cursor: pointer;
	transition: all 0.8s;
}

.cate-link {
	text-decoration: none !important;
}

.mg-top-96 {
	margin-top: 96px;
}
</style>
</head>
<body>
	<!--begin of menu-->
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
	<div class="container mg-top-96">
		<div class="row">
			<div class="col-sm-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group category_block">
						<li class="list-group-item text-white list-cate"><a
							class="text-color cate-link" href="htsua">Tất cả sản phẩm</a></li>
						<c:forEach items="${dsloai}" var="l">
							<c:if test="${maloai == l.maloai}">
								<li class="list-group-item text-white list-cate active"><a
									class="text-color cate-link"
									href="categoryController?maloai=${l.maloai}">${l.tenloai}</a></li>
							</c:if>
							<c:if test="${maloai != l.maloai}">
								<li class="list-group-item text-white list-cate"><a
									class="text-color cate-link"
									href="categoryController?maloai=${l.maloai}">${l.tenloai}</a></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Mặt
						hàng mới</div>
					<div class="card-body">
						<img class="img-fluid" src="${last.anh}" />
						<h5 class="card-title">${last.tensua}</h5>
						<p class="card-text">${last.tenncc}</p>
						<p class="bloc_left_price">${last.gia}vnđ</p>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="container">
					<div class="card">
						<div class="row">
							<aside class="col-sm-5 border-right">
								<article class="gallery-wrap">
									<div class="img-big-wrap">
										<div>
											<a href="#"><img src="${milk.anh}"></a>
										</div>
									</div>
									<!-- slider-product.// -->
									<!-- <div class="img-small-wrap">
                                            <div class="item-gallery"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc"> </div>
                                            <div class="item-gallery"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc"> </div>
                                            <div class="item-gallery"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc"> </div>
                                            <div class="item-gallery"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCepDDx2BVt6xaS4HE-_i43nybyVabVS6B3d8M33F9BF_YY_jC1xaIZsNuR_o&usqp=CAc"> </div>
                                        </div> -->
									<!-- slider-nav.// -->
								</article>
								<!-- gallery-wrap .end// -->
							</aside>
							<aside class="col-sm-7">
								<article class="card-body p-5">
									<h3 class="title mb-3">${milk.tensua}</h3>

									<p class="price-detail-wrap">
										<span class="price h3 text-warning"> <span
											class="currency">VN </span></br>
										<span class="num">${milk.gia} vnđ</span>
										</span>
										<!--<span>/per kg</span>-->
									</p>
									<!-- price-detail-wrap .// -->
									<dl class="item-property">
										<dt>Thông tin chi tiết</dt>
										<dd>
											<p>${milk.thongtin}</p>
										</dd>
									</dl>
									<!--                                        <dl class="param param-feature">
                                            <dt>Model#</dt>
                                            <dd>12345611</dd>
                                        </dl>   item-property-hor .// 
                                        <dl class="param param-feature">
                                            <dt>Color</dt>
                                            <dd>Black and white</dd>
                                        </dl>   item-property-hor .// 
                                        <dl class="param param-feature">
                                            <dt>Delivery</dt>
                                            <dd>Russia, USA, and Europe</dd>
                                        </dl>   item-property-hor .// -->

									<hr>
									<div class="row">
										<div class="col-sm-5">
											<dl class="param param-inline">
												<dt>Quantity:</dt>
												<dd>
													<select class="form-control form-control-sm"
														style="width: 70px;">
														<option>1</option>
														<option>2</option>
														<option>3</option>
													</select>
												</dd>
											</dl>
											<!-- item-property .// -->
										</div>
										<!-- col.// -->

									</div>
									<!-- row.// -->
									<hr>
									<a href="#" class="btn btn-lg btn-primary text-uppercase">
										Buy now </a> 
										<a href="giohangController?masua=${milk.masua}&tensua=${milk.tensua}&gia=${milk.gia}&anh=${milk.anh}"
										class="btn btn-lg btn-outline-primary text-uppercase"> <i
										class="fas fa-shopping-cart"></i> Add to cart
									</a>
								</article>
								<!-- card-body.// -->
							</aside>
							<!-- col.// -->
						</div>
						<!-- row.// -->
					</div>
					<!-- card.// -->


				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<footer style="background-color: #343a40; margin-top: 24px"
		class="text-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-lg-4 col-xl-3">
					<h5>About</h5>
					<hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
					<p class="mb-0">Le Lorem Ipsum est simplement du faux texte
						employé dans la composition et la mise en page avant impression.</p>
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
