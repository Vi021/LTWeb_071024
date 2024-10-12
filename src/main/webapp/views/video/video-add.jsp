<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="../utils.js"></script>

<form action="${pageContext.request.contextPath}/video/insert"
	method="post" enctype="multipart/form-data">
	<div>
		<label for="vidid">Video ID</label><br>
		<input type="text" id="vidid" name="vidid">
		<br><br>

		<label for="title">Title</label><br>
		<input type="text" id="title" name="title">
		<br><br>

		<label for="poster">Poster</label><br>
		<img alt="No image selected" src="" height="150" width="200" id="showImg"><br>
		<input type="file" onchange="showImage(this)" id="poster" name="posterfile">
		<br><br>

		<label for="desc">Description</label><br>
		<input type="text" id="desc" name="desc">
		<br><br>

		<label for="views">Views</label><br>
		<input type="number" id="views" name="views">
		<br><br>

		<label for="catid">Category ID</label><br>
		<input type="number" id="catid" name="catid">
		<br><br>

        <label>Status<br>
            <input type="radio" name="status" value="true" id="statusActive">Active
            <input type="radio" name="status" value="false" id="statusLocked">Locked
        </label>
		<br><br>

		<input type="submit" value="Submit">
	</div>
</form>
