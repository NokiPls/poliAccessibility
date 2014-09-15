<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
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
				<a href="${pageContext.request.contextPath}/" id="logo">E-commerce
					<em>accessibility</em>
				</a>
			</h1>
		</header>
		<!-- Nav -->
		<nav id="nav" role="navigation">
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Homepage</a></li>
				<li class="current"><a href="">Products</a>
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/products?type=Vision%20Impaired">Vision
								Impaired</a></li>
						<li><a
							href="${pageContext.request.contextPath}/products?type=Hearing%20and%20Speech">Hearing
								and Speech</a></li>
					</ul>
				<li><a href="${pageContext.request.contextPath}/contactUs">Contact
						Us</a></li>
				<li><a
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
						<br>
						<p>Confirm your identity to proceed with the order.</p>
					</header>

					<c:url var="url" value="/person" />
					<form:form action="login" method="post" modelAttribute="personForm">
						<label>User Name:</label>
						<form:input path="userName" placeholder="User Name" value="${userName}"
							required="true" />
						<label>Password:</label>
						<form:input type="password" placeholder="Password" path="passw"
							required="true" />

						<p>${error}</p>

						<input type="submit" />
					</form:form>

					<p>Not registered yet?</p>
					<br> <a
						href="${pageContext.request.contextPath}/userRegistration">Register
						an account.</a>

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