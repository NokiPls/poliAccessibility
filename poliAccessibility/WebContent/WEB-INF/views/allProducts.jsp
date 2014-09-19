<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US">
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
				<a href="${pageContext.request.contextPath}/" id="logo">E-commerce
					<em>accessibility</em>
				</a>
			</h1>
		</header>
		<a class="hidden" href="#content">Skip to main content</a>
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
			<div class="row double">
				<div class="4u">
					<div id="sidebar">
						<c:forEach var="i" items="${types}" varStatus="status">
							<section>
								<h3>
									<a href="${pageContext.request.contextPath}/products?type=${i}">${i}</a>
								</h3>
							</section>
						</c:forEach>
					</div>
				</div>
				<div class="8u skel-cell-important">
					<section id="content" role="main">

						<!-- Content -->

						<article role=article>
							<header> </header>
							<section id="content">
								<c:forEach var="i" items="${product}" varStatus="status">
									<article role=article>
										<section class="6u">
											<div class="box post">
												<a class="image left"
													href="${pageContext.request.contextPath}/product?i=${status.index}"><img
													src="<c:url value="/img/${i.imageURL}"/>" alt="" /></a>
												<div class="inner">
													<h3>
														<c:out value="${i.prodName}"></c:out>
													</h3>
													<br>
													<p>
														<c:out value="${i.briefDescription}"></c:out>
													</p>
													<a
														href="${pageContext.request.contextPath}/product?i=${status.index}">See
														more details</a>
												</div>

											</div>
										</section>
									</article>
								</c:forEach>
							</section>
						</article>
					</section>
				</div>
			</div>
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