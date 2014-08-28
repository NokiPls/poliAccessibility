<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Personal Profile</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/fonts.css" />" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial"
	rel="stylesheet" />


</head>
<body>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<img src="<c:url value="/img/glasses.jpg"/>" height="100" width="100" class="imageborder">
				<h1>
					<a href="/gmfb">Facilitate</a>
				</h1>
				<div id="menu">
					<ul>
						<li class="active"><a href="/gmfb" title="">Nome Utente
						</a></li>
						<li><a href="aboutUs" title="">About Us</a></li>
						<li><a href="javascript:logoutFacebook()">Disconnect</a></li>
					</ul>
				</div>
			</div>
		</div>

	</div>
	<div id="page-wrapper">

		<div class="title">
			<h2>Personal Profile</h2>
		</div>
		
		<form id="disconnectionForm"
			action="${pageContext.request.contextPath}/signout">
			<a href="friendsList" class="button">See your friends</a> <input
				type="hidden" name="_method" value="delete">

		</form>

	</div>
	<div class="wrapper"></div>
	<div id="copyright" class="container">
		<p>POLIMI - Advanced Web Technology</p>

	</div>
</body>
</html>
