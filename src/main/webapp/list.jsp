<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

	<h1>ideas</h1>

	<div id="options">
		<span><a href="/add">add new</a></span>
		<!--a href="/deleteall">delete all</a -->
	</div>

	<c:url var="firstUrl" value="/list/1" />
	<c:url var="lastUrl" value="/list/${ideas.totalPages}" />
	<c:url var="prevUrl" value="/list/${currentIndex - 1}" />
	<c:url var="nextUrl" value="/list/${currentIndex + 1}" />

	<div id="pagination">
	<ul class="pagination">
		<c:choose>
			<c:when test="${currentIndex == 1}">
				<li class="disabled"><a href="#">&lt;&lt;</a></li>
				<li class="disabled"><a href="#">&lt;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${firstUrl}">&lt;&lt;</a></li>
				<li><a href="${prevUrl}">&lt;</a></li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
			<c:url var="pageUrl" value="/list/${i}" />
			<c:choose>
				<c:when test="${i == currentIndex}">
					<li class="active"><a href="${pageUrl}"><c:out
								value="${i}" /></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${currentIndex == ideas.totalPages}">
				<li class="disabled"><a href="#">&gt;</a></li>
				<li class="disabled"><a href="#">&gt;&gt;</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${nextUrl}">&gt;</a></li>
				<li><a href="${lastUrl}">&gt;&gt;</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
	</div>

	<div id="ideas">
		<c:forEach items="${ideas.content}" var="element">
			
				<div class="idea" style="background-color:<c:out value="${element.type.color}" />;">
					<div class="pin"></div>
					<p>#<c:out value="${element.id}" /></p>
					<h2><a href="/idea/<c:out value="${element.id}" />"><c:out value="${element.name}" /></a></h2>
					<p><c:out value="${element.shortDescription}" /></p>
					<p class="timestamp"><fmt:formatDate value="${element.lastUpdated}" pattern="yyyy-MM-dd HH:mm" /></p>
				</div>

		</c:forEach>
	</div>
</body>
</html>