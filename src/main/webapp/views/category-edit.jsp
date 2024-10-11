<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<script src="utils.js"></script>

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
				<c:when test="${cat.image.contains('http')}">
					<img height="150" width="200" src="${cat.image}"
						alt="Image not found" id="catImg" />
				</c:when>
				<c:otherwise>
					<c:url value="/image?filename=${cat.image}" var="imgUrl"></c:url>
					<img height="150" width="200" src="${imgUrl}"
						alt="Image not found" id="catImg" />
				</c:otherwise>
			</c:choose><br>
		<input type="file" onchange="chooseFile(this)" id="cateimgfile" name="cateimgfile"><br>
<%-- 		<input type="text" id="cateimglink" name="cateimglink" value="${cat.image}" readonly> --%>
		<br><br>
		<label for="status">Status<br>
		<input type="radio" name="status" value="true" id="status"
			<c:if test="${cat.status == true}">
				   checked="checked"
			</c:if>
		>Active
		<input type="radio" name="status" value="false" id="status"
			<c:if test="${cat.status == false}">
				   checked="checked"
			</c:if>
		>Locked
		</label>
		<br><br>
		<input type="submit" value="Submit">
	</div>
</form>
