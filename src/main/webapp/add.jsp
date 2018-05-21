<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>

	<h2>add idea</h2>
	<form method="POST" action="" id="addIdea">
	
		<div class="colors">
		<c:forEach items="${types}" var="color" varStatus = "status">
		    <input type="radio" name="type" value="${color.name}" id="c${color.value}" ${status.first ? 'checked="checked"' : ''} />
		    <label class="radio" for="c${color.value}" style="background-color: ${color.color}"></label>
    	</c:forEach>	
		</div>	
		
		idea:<br>
		<input type="text" name="name"> <br/>
		short description: <br>
		<textarea name="shortDescription" id="shortDesc"> </textarea> <br /> 
		description: <br>
		<textarea name="description" id="longDesc"> </textarea> <br /> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="button" id="" name="button" onclick="formSubmit(); return false;">add</button>
	</form>

	<script type="text/javascript">
		var contextPath = '${pageContext.request.contextPath}';
		function formSubmit() {
			$('#addIdea').attr('action', contextPath + '/add').submit();
		}
	</script>
</body>
</html>