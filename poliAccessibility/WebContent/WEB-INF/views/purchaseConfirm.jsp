<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US">
<head>
<title>Purchase Confirm</title>
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
					href="${pageContext.request.contextPath}/switchFont?font=${font}&page=purchaseConfirm"
					title="Switch
						to ${font} font">Switch to ${font} font</a></li>
				<li><a
					href="${pageContext.request.contextPath}/switchContrast?contrast=${contrast}&page=purchaseConfirm"
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
					<section class="6u">
						<div class="box post">
							<span class="image left"><img
								src="<c:url value="/img/${product.imageURL}"/>"
								alt="Image of the product." /></span>
							<div class="inner">
								<h2>${product.prodName}</h2>
								<p>${product.briefDescription}</p>
							</div>
							<h2>${product.price}</h2>
							<h3>Your currently set address:</h3>
							<p>
								<c:out value="${person.address}" />
							</p>
							<h3>Do you want the product delivered at a different
								address?</h3>
							<label for="newAddress">Different Address for delivery:</label> <input
								placeholder="New Address" size="60" id="newAddress" />
							<form action="${pageContext.request.contextPath}/orderSuccess">
								<input type="submit" value="Confirm and Buy">
							</form>
						</div>
					</section>
				</article>
			</section>
		</div>
	</div>

	<!-- Footer -->

	<div id="footer">
		<footer class="copyright" role="contentinfo">

			<h3>Accessibility project 2013/14</h3>

		</footer>
	</div>

</body>
</html>