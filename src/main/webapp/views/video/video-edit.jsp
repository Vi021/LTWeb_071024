<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<script src="../utils.js"></script>

<form action="${pageContext.request.contextPath}/video/update"
	method="post" enctype="multipart/form-data">
	<div>
		<label for="vidid">Video ID</label><br>
		<input type="text" id="vidid" name="vidid" value="${vid.videoid}" readonly>
		<br><br>

		<label for="title">Title</label><br>
		<input type="text" id="title" name="title" value="${vid.title}">
		<br><br>

		<label for="posterfile">Poster</label><br>
			<c:choose>
				<c:when test="${vid.poster.contains('http')}">
					<img height="150" width="200" src="${vid.poster}"
						alt="Image not found" id="showImg" />
				</c:when>
				<c:otherwise>
					<c:url value="/image?filename=${vid.poster}" var="imgUrl"></c:url>
					<img height="150" width="200" src="${imgUrl}"
						alt="Image not found" id="showImg" />
				</c:otherwise>
			</c:choose><br>
		<input type="file" onchange="showImage(this)" id="posterfile" name="posterfile"><br>
 		<input type="text" id="posterlink" name="posterlink" value="${vid.poster}" readonly>
		<br><br>

		<label for="desc">Description</label><br>
		<input type="text" id="desc" name="desc" value="${vid.description}">
		<br><br>

		<label for="views">Views</label><br>
		<input type="number" id="views" name="views" value="${vid.views}">
		<br><br>

		<label for="catid">Category ID</label><br>
		<input type="text" id="catid" name="catid" value="${vid.category.categoryid}">
		<br><br>

		<label>Status<br>
		<input type="radio" name="status" value="true" id="statusActive"
			<c:if test="${vid.active == true}">
				   checked="checked"
			</c:if>
		>Active
		<input type="radio" name="status" value="false" id="statusLocked"
			<c:if test="${vid.active == false}">
				   checked="checked"
			</c:if>
		>Locked
		</label>
		<br><br>

		<input type="submit" value="Submit">
	</div>
</form>
