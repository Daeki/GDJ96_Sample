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
					<h1 class="mt-4">${cat}</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                    <div class="row">
                    	<div class="col-md-7">
                    		<table class="table table-hover">
                    			<thead>
                    				<th>No</th>
                    				<th>Title</th>
                    				<th>Writer</th>
                    				<th>Date</th>
                    				<th>Hit</th>
                    			
                    			
                    				
                    			</thead>
                    			<tbody>
                    				<c:forEach items="${list}" var="dto">
                    				<tr>
                    					<td>${dto.board_id}</td>
                    					<td>
                    					<c:catch>
                    					<c:forEach begin="1" end="${dto.board_depth}">--</c:forEach>
                    					</c:catch>
                    					<a href="./detail?board_id=${dto.board_id}">${dto.board_title}
                    					</a></td>
                    					<td>${dto.board_writer}</td>
                    					<td>${dto.board_date}</td>
                    					<td>${dto.board_hit}</td>
                    				</tr>	
                    				</c:forEach>
                    			</tbody>
                    			
                    		
                    		</table>
                    		
                    		<a class="btn btn-danger" href="./write">Write</a>
                    	
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