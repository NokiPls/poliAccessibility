<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US">
<head>
<title>Homepage</title>
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
		<div class="hidden">
			<a href="#content">Skip to main content</a>
		</div>

		<!-- Nav -->
		<nav id="nav" role="navigation">
			<ul>
				<li class="current"><a
					href="${pageContext.request.contextPath}/">Homepage</a></li>
				<li><a href="${pageContext.request.contextPath}/allProducts">Products</a>
				<li><a href="${pageContext.request.contextPath}/contactUs">Contact
						Us</a></li>
				<li><a
					href="${pageContext.request.contextPath}/userRegistration">Registration</a></li>
				<li><a
					href="${pageContext.request.contextPath}/switchFont?font=${font}&page=home">Switch
						to ${font} font</a></li>
				<li><a
					href="${pageContext.request.contextPath}/switchContrast?contrast=${contrast}&page=home">Switch
						to ${contrast} contrast</a></li>
			</ul>
		</nav>
	</div>

	<!-- Main -->
	<section class="wrapper style1">
		<div class="container">
			<div class="row double">
				<div class="4u">
					<div id="sidebar" role="complementary">

						<!-- Sidebar -->
						<section>
							<h3>
								<a
									href="${pageContext.request.contextPath}/products?type=Vision%20Impaired">Vision
									Impaired</a>
							</h3>
						</section>
						<section>
							<h3>
								<a
									href="${pageContext.request.contextPath}/products?type=Hearing%20and%20Speech">Hearing
									and Speech</a>
							</h3>

						</section>
					</div>
				</div>

				<div class="8u skel-cell-important">
					<section id="content" role="main">
						<!-- Content -->
						<article role=article>
							<header>
								<h2>Accessible E-commerce</h2>
								<h3>Accessibility Project</h3>
							</header>

							<span class="image featured"><img
								src="<c:url value="/img/accessibility.jpg" />"
								alt="Logo of the company." /></span>

							<h3>The Store</h3>
							<p>The Store features a wide range of medical, health and
								disability products for children and adults with hearing and
								sight impairments. We source a wide range of medical and
								disability products for sale at reasonable prices from reputable
								suppliers specializing in the sale of health, medical, caregiver
								and disability products online. These aids and other useful
								assistive devices for around the home are designed to enhance
								the lives of the disabled and those with hearing or sight
								challenges. Assistive devices and daily living aids assist in
								supporting independent living for persons with disabilities,
								seniors, special needs and children with a medical condition or
								injuries.</p>
						</article>
					</section>
				</div>
			</div>
		</div>

	</section>


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