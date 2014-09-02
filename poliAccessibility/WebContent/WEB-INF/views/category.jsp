<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<noscript>
	<link href="<c:url value="/css/style.css" />" rel="stylesheet">
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
				<a href="index.html" id="logo">E-commerce <em>accessibility</em></a>
			</h1>
		</header>
		<!-- Nav -->
		<nav id="nav" role="navigation">
			<ul>
				<li><a href="/">Homepage</a></li>
				<li class="current"><a href="">Products</a>
					<ul>

						<li><a href="/category">Vision Impaired</a>
							<ul>
								<li><a href="/category">Braille Displays</a></li>
								<li><a href="/category">Braille Embossers</a></li>
								<li><a href="/category">Screen Magnification</a></li>
								<li><a href="/category">Screen Readers</a></li>
							</ul></li></li>
				<li><a href="/category">Autism</a></li>
			</ul>
			<li><a href="/contactUs">Contact Us</a></li>
		</nav>

	</div>

	<!-- Main -->
	<div class="wrapper style1">
		<div class="container">
			<section id="content" role="main">

				<!-- Content -->
				<c:forEach var="i" items="${product}" varStatus="status">
					<article role=article>
						<header>
							<h2><c:out value="${i.name}"></c:out></h2>
							<p><c:out value="${i.briefDescription}"></c:out></p>
						</header>

						<span class="image featured"><img src="<c:out value="${i.imageURL}"></c:out>"
							alt="Always provide alt text for accessibility ;-)" /></span>
							

						<p><c:out value="${i.longDescription}"></c:out></p>


					</article>
				</c:forEach>
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