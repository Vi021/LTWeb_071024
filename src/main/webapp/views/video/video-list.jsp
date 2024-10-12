<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<button style="float: right; margin: 10px" 
onclick="location.href='${pageContext.request.contextPath}/video/add'">Add Video</button>

<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Poster</th>
		<th>VideoID</th>
		<th>Title</th>
		<th>Description</th>
		<th>Status</th>
		<th>Views</th>
		<th>CategoryID</th>
		<th>Action</th>
	</tr>
	<tr>

	<c:forEach items="${listvid}" var="video" varStatus="STT" >
 		<tr>
 			<td>${STT.index+1}</td>

 			<td>
 				<c:choose>
					<c:when test="${video.poster.contains('http')}">
						<img height="150" width="200" src="${video.poster}"
							alt="Image not found" />
					</c:when>
					<c:otherwise>
						<c:url value="/image?filename=${video.poster}" var="imgUrl"></c:url>
						<img height="150" width="200" src="${imgUrl}"
							alt="Image not found" />
					</c:otherwise>
				</c:choose>
			</td>

 			<td>${video.videoid}</td>

 			<td>${video.title}</td>

			<td>${video.description}</td>

 			<td>
 				<c:if test="${video.active}">
 					<span>Active</span></c:if>
 				<c:if test="${!video.active}">
 					<span>Locked</span></c:if>
 			</td>

			<td>${video.views}</td>

			<td>${video.category.categoryid}</td>

			<td>
			<a href="<c:url value='/video/edit?id=${video.videoid}'/>">Edit</a>
			 | <a href="<c:url value='/video/delete?id=${video.category.categoryid}'/>">Delete</a>
			</td>

 		</tr>
 	</c:forEach>
</table>
