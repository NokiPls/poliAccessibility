<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en-US">
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
<noscript>
	<link href="<c:url value="/css/${css}.css" />" rel="stylesheet">
	<link href="<c:url value="/css/skel.css" />" rel="stylesheet">
	<link href="<c:url value="/css/style-wide.css" />" rel="stylesheet">
</noscript>
<script type='text/javascript'>
	function checkPassw() {
		if (document.getElementById('confirmPassword').value != document
				.getElementById('password').value) {
			document.getElementById("passw").innerHTML = 'Password Must be Matching.';
			document.getElementById("formSubmit").disabled = true;
		} else {
			document.getElementById("passw").innerHTML = '';
			document.getElementById("formSubmit").disabled = false;
		}
	}

	function checkUserName() {
		var userN = document.getElementById("userName");
		$.ajax({
			url : 'checkUserName?userName=' + userN.value,
			success : function(data) {
				$('#username').html(data);

			}
		})
	}
</script>
</head>
<body>

	<!-- Header  ho modificato div in header e aggiunto il ruolo-->
	<div id="header">
		<h2>
			<button class="btn">text size</button>
			<button class="btn">High Contrast</button>
		</h2>
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
				<li><a href="${pageContext.request.contextPath}/allProducts">Products</a>
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
						<h3>Accessibility Project</h3>
					</header>
					<c:url var="url" value="/person" />
					<form:form action="userRegistration" method="post"
						modelAttribute="personForm">
						<div id="nameError" class="error">${nameError}</div>
						<label for="FirstName">First Name:</label>
						<form:input path="name" id="FirstName" placeholder="First Name"
							required="true" value="${person.name}" autofocus="true" />

						<div id="surnameError" class="error">${surnameError}</div>
						<label for="Surname">Surname:</label>
						<form:input path="surname" placeholder="Surname" required="true"
							value="${person.surname}" id="Surname" />

						<div id="addressError" class="error">${addressError}</div>
						<label for="address">Address:</label>
						<form:input path="address" placeholder="Address" required="true"
							value="${person.address}" id="address" />

						<div id="ccnError" class="error">${ccnError}</div>
						<label for="Ccn">Ccn:</label>
						<form:input path="ccn" placeholder="Ccn" required="true"
							value="${person.ccn}" id="Ccn" />

						<div id="ccexpError" class="error">${ccexpError}</div>
						<label for="exp">Cc expiration date:</label>
						<form:input path="ccexp" placeholder="DD/MM Cc expiration date"
							pattern="(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])"
							title="The date should be in the format DD/MM with leading zeros where necessary"
							required="true" value="${person.ccexp}" id="exp" />

						<div id="usernameError" aria-live="polite" class="error">${userNameError}</div>
						<label for="Username">User Name:</label>
						<form:input id="UserName" path="userName" placeholder="User Name"
							onblur="checkUserName()" required="true"
							value="${person.userName}" />

						<div id="passwordError" class="error">${passwordError}</div>
						<label for="password">Password:</label>
						<form:input id="password" type="password" path="passw"
							placeholder="Password" required="true" />

						<div id="passw" aria-live="polite" class="error"></div>
						<label for="confirmPassword">Confirm Password:</label>
						<input id="confirmPassword" type="password"
							placeholder="Confirm Password" required onblur="checkPassw()" />

						<input id="formSubmit" type="submit" />
					</form:form>
				</article>
			</section>
		</div>
	</div>


	<!-- Footer -->

	<div id="footer">
		<footer class="copyright" role="contentinfo">

			<h3>Accessibility Project 2013/14</h3>

		</footer>
	</div>

</body>
</html>