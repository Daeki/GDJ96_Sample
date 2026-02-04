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
                    	<div class="col-md-4 offset-md-1">
                    		<form method="post">
                    			<input type="hidden" value="${dto.board_id}" name="board_id">
							  <div class="mb-3">
							    <label for="title" class="form-label">Title</label>
							    <input type="text" value="${dto.board_title}" class="form-control" id="title" name="board_title">
							    
							  </div>
							  <div class="mb-3">
							    <label for="writer" class="form-label">Writer</label>
							    <input type="text" value="${dto.board_writer}" class="form-control" id="writer" name="board_writer">
							  </div>
							  <div class="mb-3">
							    <label for="contents" class="form-label">Contents</label>
							    <textarea rows="5" cols="10" class="form-control" id="contents" name="board_contents">${dto.board_contents}</textarea>
							  </div>
							  <button type="submit" class="btn btn-primary">Submit</button>
							</form>
                    	
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