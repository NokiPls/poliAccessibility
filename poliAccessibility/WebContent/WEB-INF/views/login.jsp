<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US">
<head>
<title>Login</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/${js}.js"></script>
<noscript>
	<link href="<c:url value="/css/${css}.css" />" rel="stylesheet">
	<link href="<c:url value="/css/skel.css" />" rel="stylesheet">
	<link href="<c:url value="/css/style-wide.css" />" rel="stylesheet">
</noscript>
</head>
<body>

	<!-- Header  ho modificato div in header e aggiunto il ruolo-->
	<div id="header">

		<!-- Logo  aggiunta nav-->
		<header role="banner">
			<h1>
				<a href="${pageContext.request.contextPath}/" id="logo">E-commerce
					<em>accessibility</em>
				</a>
			</h1>
		</header>
		<!-- Navigation -->
		<nav id="nav" role="navigation">
			<ul>
				<li><a href="${pageContext.request.contextPath}/" title="Home">Homepage</a></li>
				<li class="current"><a
					href="${pageContext.request.contextPath}/allProducts"
					title="All products">Products</a>
				<li><a href="${pageContext.request.contextPath}/contactUs"
					title="Contact us">Contact Us</a></li>
				<li><a
					href="${pageContext.request.contextPath}/userRegistration"
					title="Registration">Registration</a></li>
				<li><a
					href="${pageContext.request.contextPath}/switchFont?font=${font}&page=login"
					title="Switch
						to ${font} font">Switch to ${font} font</a></li>
				<li><a
					href="${pageContext.request.contextPath}/switchContrast?contrast=${contrast}&page=login"
					title="Switch
						to ${contrast} contrast">Switch to
						${contrast} contrast</a></li>
			</ul>
		</nav>
	</div>

	<!-- Main -->
	<div class="wrapper style1">
		<div class="container">
			<section id="content" role="main">

				<!-- Content -->
				<article role=article>
					<header>
						<h1>Confirm your identity to proceed with the order.</h1>
					</header>

					<c:url var="url" value="/person" />
					<div class="error">${error}</div>
					<form:form action="login" method="post" modelAttribute="personForm">
						<label for="userName">User Name:</label>
						<form:input path="userName" placeholder="User Name"
							value="${userName}" required="true" id="userName" />
						<label for="passw">Password:</label>
						<form:input type="password" placeholder="Password" path="passw"
							required="true" id="passw" />
						<input type="submit" value="Login" />
					</form:form>

					<h3>Not registered yet?</h3>
					<a href="${pageContext.request.contextPath}/userRegistration">Register
						an account.</a>

				</article>
			</section>
		</div>
	</div>


	<!-- Footer -->

	<div id="footer">
		<div class="container">
			<div class="row ">
				<div class="6u">
					<div class="row collapse-at-2">
						<section class="6u">
							<h3>Accessibility project 2013/14</h3>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>