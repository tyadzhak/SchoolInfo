<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">

		<div class="navbar-header">
			<a class="navbar-brand" href="#">School Management</a>
		</div>

		<ul class="nav navbar-nav">

			<li><a href="#">Home</a></li>

			<li><a href=<spring:url value="/school/list"/>>Schools</a></li>

		</ul>

	</div>
</nav>