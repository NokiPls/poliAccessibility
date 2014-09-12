<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Registration</title>
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
							href="${pageContext.request.contextPath}/products?type=Vision%20Impaired">Vision
								Impaired</a></li>
						<li><a
							href="${pageContext.request.contextPath}/products?type=Hearing%20and%Speech">Hearing
								and Speech</a></li>
					</ul>
				<li><a href="${pageContext.request.contextPath}/contactUs">Contact
						Us</a></li>
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
						<p>Accessibility Project</p>
					</header>
					<c:url var="url" value="/person" />
					<form:form action="addPerson" method="post"
						modelAttribute="personForm">
						<label>First Name:</label>
						<form:input path="name" placeholder="First Name" required="true" />
						<label>Surname:</label>
						<form:input path="surname" placeholder="Surname" required="true" />
						<label>Address:</label>
						<form:input path="address" placeholder="Address" required="true" />
						<label>Ccn:</label>
						<form:input path="ccn" placeholder="Ccn" required="true" />
						<label>Cc expiration date:</label>
						<form:input path="ccexp" placeholder="DD/MM Cc expiration date"
							pattern="(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])"
							title="The date should be in the format DD/MM with leading zeros where necessary"
							required="true" />
						<label>User Name:</label>
						<form:input path="userName" placeholder="User Name"
							required="true" />
						<label>Password:</label>
						<form:input id="password" type="password" path="passw"
							placeholder="Password" required="true" />
						<label>Confirm Password:</label>
						<input id="confirmPassword" type="password"
							placeholder="Confirm Password" required oninput="check(this)" />
						<script type='text/javascript'>
							function check(input) {
								if (input.value != document
										.getElementById('password').value) {
									input
											.setCustomValidity('Password Must be Matching.');
								} else {
									// input is valid -- reset the error message
									input.setCustomValidity('');
								}
							}
						</script>
						<input type="submit" />
					</form:form>
				</article>
			</section>
		</div>
	</div>


	<!-- Footer -->

	<div id="footer">
		<footer class="copyright" role="contentinfo">

			<p>Accessibility Project 2013/14</p>

		</footer>
	</div>

</body>
</html>