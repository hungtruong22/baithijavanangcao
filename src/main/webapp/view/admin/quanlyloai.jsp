<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Sữa</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/manager.css" rel="stylesheet" type="text/css"/>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
         <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        
        
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
                            <h2>Danh sách Loại</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal">
                            <i class="material-icons">&#xE147;</i> <span>Thêm Loại</span></a>
                            <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal">
                            <i class="material-icons">&#xE15C;</i> <span>Xóa Loại</span></a>						
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>Mã Loại</th>
                            <th>Tên Loại</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${dstrang}" var="l">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>${l.maloai}</td>
                                <td>${l.tenloai}</td>
                                
                                <td>
                                    <a href="sualoaiController?maloai=${l.maloai}"  class="edit" data-toggle="modal">
                                    <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="xoaloaiController?maloai=${l.maloai}" class="delete" data-toggle="modal">
                                    <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
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
           			<div class="feature">
           				 <!-- Edit Modal HTML -->
			        <div id="addEmployeeModal" class="">
			            <div class="modal-dialog mw-600">
			                <div class="modal-content">
			                    <form action="themloaiController" method="post">
			                        <div style="background-color: #28a745" class="modal-header">						
			                            <h4 class="modal-title">Thêm loại</h4>
			                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                        </div>
			                        <div class="modal-body">
			                        	<div class="form-group">
			                                <label>Mã loại</label>
			                                <input name="maloai" type="text" class="form-control" required>
			                            </div>					
			                            <div class="form-group">
			                                <label>Tên loại</label>
			                                <input name="tenloai" type="text" class="form-control" required>
			                            </div>
			                        </div>
			                        <div class="modal-footer">
			                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
			                            <input type="submit" class="btn btn-success" value="Add">
			                        </div>
			                    </form>
			                </div>
			            </div>
			        </div>
			        
			        
			         <!-- Edit Modal HTML -->
			        <div id="editEmployeeModal" class="">
			            <div class="modal-dialog mw-600">
			                <div class="modal-content">
			                    <form action="editloaiController" method="post">
			                        <div style="background-color: #FFC107" class="modal-header">						
			                            <h4 class="modal-title">Chỉnh sửa loại</h4>
			                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                        </div>
			                        <div class="modal-body">
			                        	<div class="form-group">
			                                <label>Mã loại</label>
			                                <input name="mal" value="${loai.maloai}" type="text" class="form-control" readonly required>
			                            </div>					
			                            <div class="form-group">
			                                <label>Tên loại</label>
			                                <input name="tenl" value="${loai.tenloai}" type="text" class="form-control" required>
			                            </div>			                            	
			                        </div>
			                        <div class="modal-footer">
			                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
			                            <input type="submit" class="btn btn-info" value="Save">
			                        </div>
			                    </form>
			                </div>
			            </div>
			        </div>
           			</div>
        
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Delete Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Are you sure you want to delete these Records?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>
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