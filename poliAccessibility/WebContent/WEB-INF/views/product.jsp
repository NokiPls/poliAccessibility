<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US">
<head>
<title>Product ${product.prodName}</title>
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
		<!-- Nav -->
		<nav id="nav" role="navigation">
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Homepage</a></li>
				<li class="current"><a
					href="${pageContext.request.contextPath}/allProducts">Products</a>
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
					<section class="6u">
						<div class="box post">
							<span class="image left"><img
								src="<c:url value="/img/${product.imageURL}"/>"
								alt="Image of the product ${product.prodName} " /></span>
							<div class="inner">
								<h1>${product.prodName}</h1>
								<p>${product.briefDescription}${product.longDescription}</p>
							</div>
							<h2>${product.price}</h2>
							<form action="login" method="get">
								<input type="submit" value="Login to buy." />
							</form>
						</div>
					</section>

					<embed width="420" height="315" src="${product.linkVideo}"
						alt="Video of the product">
					<table>
						<caption>Specs Table</caption>
						<tr>
							<th id="name" scope="row">NAME</th>
							<td headers="name">${product.prodName}</td>
						</tr>
						<tr>
							<th id="features" scope="row">FEATURES</th>
							<td headers="features">${product.features}</td>
						</tr>
						<tr>
							<th id="compatibility" scope="row">COMPATIBILITY</th>
							<td headers="compatibility">${product.compatibility}</td>
						</tr>
					</table>
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