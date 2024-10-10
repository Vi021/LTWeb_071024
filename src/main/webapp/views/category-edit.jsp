<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="${pageContext.request.contextPath}/category/update"
	method="post" enctype="multipart/form-data">
	<div>
		<label for="cateid">Category ID</label><br>
		<input type="text" id="cateid" name="cateid" value="${cat.categoryid}" readonly>
		<br><br>
		<label for="catename">Category Name</label><br>
		<input type="text" id="catename" name="catename" value="${cat.categoryname}">
		<br><br>
		<label for="cateimgfile">Image</label><br>
			<c:choose>
				<c:when test="${cat.images.contains('http')}">
					<img height="150" width="200" src="${cat.images}"
						alt="Image not found" id="catImg" />
				</c:when>
				<c:otherwise>
					<c:url value="/image?filename=${cat.images}" var="imgUrl"></c:url>
					<img height="150" width="200" src="${imgUrl}"
						alt="Image not found" id="catImg" />
				</c:otherwise>
			</c:choose><br>
		<input type="file" onchange="chooseFile(this)" id="cateimgfile" name="cateimgfile"><br>
<%-- 		<input type="text" id="cateimglink" name="cateimglink" value="${cat.images}" readonly> --%>
		<br><br>
		<label for="status">Status</label><br>
		<input type="text" id="status" name="status" value="${cat.status}">
		<br><br>
		<input type="submit" value="Submit">
	</div>
</form>
