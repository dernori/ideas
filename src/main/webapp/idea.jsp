<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

	<div id="options">
		<span><a href="/add">add new</a></span>
		<span><a href="/list">view all</a></span>
		<span><a href="/edit/<c:out value="${idea.id}" />">edit</a></span>
		<span><a href="/delete/<c:out value="${idea.id}" />">delete</a></span>
	</div>

	<div id="idea">
		<h2><c:out value="${idea.name}" /></h2>
		<p><c:out value="${idea.shortDescription}"/></p>
		<hr> 
		<p><c:out value="${idea.description}" escapeXml="false" /></p> 
		<p class="timestamp"><fmt:formatDate value="${idea.lastUpdated}" pattern="yyyy-MM-dd HH:mm"/></p>
	</div>

</body>
</html>