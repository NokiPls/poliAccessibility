<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Products</title>
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
				<li><a href="index.html">Homepage</a></li>
				<li class="current"><a href="">Prodotti</a>
					<ul>

						<li><a href="">disabilitÃ  visiva</a>
							<ul>
								<li><a href="#">ingranditori</a></li>
								<li><a href="#">stampanti braile</a></li>
								<li><a href="#">lettori</a></li>
							</ul></li></li>
				<li><a href="left-sidebar.html">disabilitÃ  motoria</a></li>
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
						<h2>${facebookProfile.name}</h2>
						<p>${facebookProfile.id}</p>
					</header>
					<fieldset>
						<legend>Your Favorite Color</legend>
						<input type=”radio” name=”favoritecolor” value=”blue” id=”blue”>
						<label for=”blue”>Blue</label> <input type=”radio”
							name=”favoritecolor” value=”green” id=”green”> <label
							for=”green”>Green</label> <input type=”radio”
							name=”favoritecolor” value=”purple” id=”purple”> <label
							for=”purple”>Purple</label>
					</fieldset>
					<form action="somescript.php">
						<fieldset>
							<legend>Name</legend>
							<p>
								First name <input name="firstName">
							</p>
							<p>
								Last name <input name="lastName">
							</p>
						</fieldset>
						<fieldset>
							<legend>Address</legend>
							<p>
								Address
								<textarea name="address"></textarea>
							</p>
							<p>
								Postal code <input name="postcode">
							</p>
						</fieldset>
						</form>
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