<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Thống kê</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        
     </head>   
        <!------ Include the above in your HEAD tag ---------->
        
        <style>
            img{
                width: 200px;
                height: 120px;
            }
            .mw-600{
            	max-width: 600px;
            	width: 500px;
            	
            }
            .feature{
            	display: flex;
            	justify-content: space-around;
            }
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
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Thống kê</h2>
                        </div>
         
                    </div>
                </div>
                <form action="thongkeController" method="post" >
                	<table class="table table-striped table-hover">
                    <thead>
                        <tr style="background-color: #435d7d; color: #fff">
                            
                            <th>Bán chạy nhất</th>
                            <th>Ảnh</th>
                            <th>Số lượng bán</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        	<c:forEach items="${dsbanchay}" var="s">
                            <tr>
                                
                                <td class="">${s.tensua}</td>
                                <td class=""><img src="${s.anh}"></td>
                                <td class="">${s.tongsoluongmua}</td>
                                
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
                </form>
                
                <form action="thongkeController" method="post">
                	<table class="table table-striped table-hover">
                    <thead>
                        <tr style="background-color: #435d7d; color: #fff">
                            
                            <th>Bán chậm nhất</th>
                            <th>Ảnh</th>
                            <th>Số lượng bán</th>
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                        	<c:forEach items="${dsbancham}" var="s">
                            <tr>
                                
                                <td class="">${s.tensua}</td>
                                <td class=""><img src="${s.anh}"></td>
                                <td class="">${s.tongsoluongmua}</td>
                                
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                
                <form action="thongkeController" method="post">
                	<table class="table table-striped table-hover">
                    <thead>
                        <tr style="background-color: #435d7d; color: #fff">
                            
                            
                            <th>Số hóa đơn bán được</th>
                            <th>Tổng tiền thu được</th>
                            <th>KH mua nhiều nhất</th>
                          
                        </tr>
                    </thead>
                    <tbody>	
                            <tr>
                                <td class="">${slhoadon}</td>
                                <td class="">${tongtien} vnđ</td>
                                <td class="">${khmuanhieunhat}</td>
                                
                            </tr>
                    </tbody>
                </table>
                </form>
                
                <!--  form action="thongkeController" method="post" >
                	<table class="table table-striped table-hover">
                    <thead>
                        <tr style="background-color: #435d7d; color: #fff">
                            
                            <th>Bán chậm nhất</th>
                            <th>Ảnh</th>
                            <th>Số lượng</th>
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                        
                            <tr>
                                
                                <td class="">${suabancham}</td>
                                <td class=""><img src="${anhsuabanchamnhat}"></td>
                                <td class="">${soluongbancham}</td>
                                
                                
                            </tr>
                        
                    </tbody>
                </table>
                </form>-->
                
                
               <nav class="nav-flex-1" aria-label="Page navigation example">
				  	<ul class="pagination">
						<c:forEach begin="1" end="${endPage}" var="i">
							<c:if test="${tag==i}">
								<li class="page-item active">
								 	<a class="page-link" href="quanlysuaController?trang=${i}">${i}</a>
								 </li>
							</c:if>	
							<c:if test="${tag != i}">						
								 <li class="page-item">
								 	<a class="page-link" href="quanlysuaController?trang=${i}">${i}</a>
								 </li>
							</c:if>	
  						</c:forEach>
  					</ul>
			</nav>	
            </div>
           			
        </div>
        <!-- Delete Modal HTML -->
        
        <script src="js/manager.js" type="text/javascript"></script>
        <script>
        $(document).ready(function () {
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            $("#selectAll").click(function () {
                if (this.checked) {
                    checkbox.each(function () {
                        this.checked = true;
                    });
                } else {
                    checkbox.each(function () {
                        this.checked = false;
                    });
                }
            });
            checkbox.click(function () {
                if (!this.checked) {
                    $("#selectAll").prop("checked", false);
                }
            });
        });

        </script>
    </body>
</html>