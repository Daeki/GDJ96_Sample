<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/template/css.jsp"></c:import>
</head>
<body class="sb-nav-fixed">
	<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
	<div id="layoutSidenav">
		<c:import url="/WEB-INF/views/template/nav_side.jsp"></c:import>
		<div id="layoutSidenav_content">
			<main>
				 <div class="container-fluid px-4">
					<h1 class="mt-4">Dashboard</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                    <div class="row">
                    	<div>
                    		<div class="card">
							  <div class="card-header">
							    ${dto.board_title}
							  </div>
							  <div class="card-body">
							    ${dto.board_contents}
							  </div>
							  
							  <div class="card-footer">
							  	<a class="btn btn-primary" href="./update?board_id=${dto.board_id}">Update</a>
							  	<form action="./delete" method="post">
							  		<input type="hidden" name="board_id" value="${dto.board_id}">
							  		<button class="btn btn-danger">DELETE</button>
							  	</form>
							  	<a class="btn btn-success" href="./reply?board_id=${dto.board_id}">답글</a>
							  </div>
							</div>
                    	
                    	</div>
                    </div>
				 
				 </div>
			</main>
			<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>
	</div>
	
	
	<c:import url="/WEB-INF/views/template/script.jsp"></c:import>
</body>
</html>