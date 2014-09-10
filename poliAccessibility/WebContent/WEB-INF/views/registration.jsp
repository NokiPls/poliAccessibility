<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Homepage</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/skel.css" />" rel="stylesheet">
<link href="<c:url value="/css/style-wide.css" />" rel="stylesheet">
</head>
<body>

	<!-- Header  ho modificato div in header e aggiunto il ruolo-->
	<div id="header">

		<!-- Logo  aggiunta nav-->
		<header role="banner">
			<h1>
				<a href="index.html" id="logo">E-commerce <em>accessibility</em></a>
			</h1>
		</header>
		<!-- Nav -->
		<nav id="nav" role="navigation">
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Homepage</a></li>
				<li><a href="">Products</a>
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/products?type=vision">Vision
								Impaired</a>
							<ul>
								<li><a href="${pageContext.request.contextPath}/category">Braille
										Displays</a></li>
								<li><a href="${pageContext.request.contextPath}/category">Braille
										Embossers</a></li>
								<li><a href="${pageContext.request.contextPath}/category">Screen
										Magnification</a></li>
								<li><a
									href="${pageContext.request.contextPath}/category?category=reader">Screen
										Readers</a></li>
							</ul></li>
						<li><a href="${pageContext.request.contextPath}/contactUs">Autism</a></li>
					</ul>
				<li><a href="index.html">Contact Us</a></li>
				<li class="current"><a
					href="${pageContext.request.contextPath}/userRegistration">Registration</a></li>
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
						<h2>Accessible E-commerce</h2>
						<br>
						<p>accessibility project</p>
					</header>

					<c:url var="url" value="/person" />
					<form:form action="addPerson" method="post"
						modelAttribute="personForm">
						<label>Name:</label>
						<form:input path="name" />
						<label>Surname:</label>
						<form:input path="surname" />
						<label>Address:</label>
						<form:input path="address" />
						<label>Ccn:</label>
						<form:input path="ccn" />
						<label>Ccexp:</label>
						<form:input path="ccexp" />
						<label>User Name:</label>
						<form:input path="userName" />
						<label>Password:</label>
						<form:input path="passw" />
						<input type="submit" />
					</form:form>


				</article>
			</section>
		</div>
	</div>


	<!-- Footer -->

	<div id="footer">
		<footer class="copyright" role="contentinfo">

			<p>Accessibility project 2013/14</p>

		</footer>
	</div>

</body>
</html>