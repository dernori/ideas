<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

	<h2>edit idea</h2>
	<form:form method="post" modelAttribute="idea" action="/edit">
	    <form:hidden path="id"/> 
	    
	    <div class="colors">
		<c:forEach items="${types}" var="color" varStatus = "status">
		    <form:radiobutton  path="type" value="${color.name}" id="c${color.value}"/>
		    <label class="radio" for="c${color.value}" style="background-color: ${color.color}"></label>
    	</c:forEach>	
		</div>

		name: <br>
		<form:input path="name" /><br>
	    short description:<br>
	    <form:textarea path="shortDescription" id="shortDesc"/><br>
	    description:<br>
	    <form:textarea path="description" id="longDesc"/><br>
	
	    <input type="submit" value="save"/>
	</form:form>
    
</body>
</html>