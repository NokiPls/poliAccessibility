<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="js/init.js"></script>
</head>
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/css/skel.css" />" rel="stylesheet">
<link href="<c:url value="/css/style-wide.css" />" rel="stylesheet">
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
				<li class="current"><a
					href="${pageContext.request.contextPath}/">Homepage</a></li>
				<li><a href="${pageContext.request.contextPath}/allProducts">Products</a>
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
					</header>
					<span class="image featured"><img
						src="<c:url value="/img/download.jpg" />"
						alt="Always provide alt text for accessibility ;-)" /></span>

					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Maecenas ac quam risus, at tempus justo. Sed dictum rutrum massa
						eu volutpat. Quisque vitae hendrerit sem. Pellentesque lorem
						felis, ultricies a bibendum id, bibendum sit amet nisl. Mauris et
						lorem quam. Maecenas rutrum imperdiet vulputate. Nulla quis nibh
						ipsum, sed egestas justo. Morbi ut ante mattis orci convallis
						tempor. Etiam a lacus a lacus pharetra porttitor quis accumsan
						odio. Sed vel euismod nisi. Etiam convallis rhoncus dui quis
						euismod. Maecenas lorem tellus, congue et condimentum ac,
						ullamcorper non sapien. Donec sagittis massa et leo semper a
						scelerisque metus faucibus. Morbi congue mattis mi. Phasellus sed
						nisl vitae risus tristique volutpat. Cras rutrum commodo luctus.</p>
					<p>Phasellus odio risus, faucibus et viverra vitae, eleifend ac
						purus. Praesent mattis, enim quis hendrerit porttitor, sapien
						tortor viverra magna, sit amet rhoncus nisl lacus nec arcu.
						Suspendisse laoreet metus ut metus imperdiet interdum aliquam
						justo tincidunt. Mauris dolor urna, fringilla vel malesuada ac,
						dignissim eu mi. Praesent mollis massa ac nulla pretium pretium.
						Maecenas tortor mauris, consectetur pellentesque dapibus eget,
						tincidunt vitae arcu. Vestibulum purus augue, tincidunt sit amet
						iaculis id, porta eu purus.</p>


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