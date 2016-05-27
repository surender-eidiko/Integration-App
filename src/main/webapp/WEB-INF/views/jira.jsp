<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JIRA Project Details</title>
</head>
<body>

	<form:form method="POST" commandName="jiraAppBean" action="saveconfig">
		<h2>JIRA Configuration</h2>
		Repository :
		<form:select path="projectId">
			<form:option value="NONE" label="--- Select ---" />
			<form:options items="${projectsList}" />
		</form:select>
		<h4>Notifications:</h4>
		<div style="width: 410px;">
			<div style="float: right;width=200px;">
				From:
				<form:input path="notificationFrom[]" value="Val1" />
				<form:input path="notificationFrom[]" value="Val2" />
				<form:input path="notificationFrom[]" value="Val3" />
				<form:input path="notificationFrom[]" value="Val4" />
			</div>
			<div style="float: right;width=200px;">
				To:
				<form:input path="notificationTo[]" value="Val5" />
				<form:input path="notificationFrom[]" value="Val6" />
				<form:input path="notificationFrom[]" value="Val7" />
				<form:input path="notificationFrom[]" value="Val8" />
			</div>
		</div>
		<h2>Spark Configuration</h2>
		Room : 
		<form:select path="roomId">
			<form:option value="NONE" label="--- Select ---" />
			<form:options items="${roomsList}" />
		</form:select>
		<br />
		<br />
		Display Name:
		<form:input path="displayName" />
		<br />
		<br />
		<input type="submit" value="Integrate" />
	</form:form>

	<div id='TextBoxesGroup'>
		<div id="TextBoxDiv1">
			<label>Textbox #1 : </label><input type='textbox' id='textbox1'>
		</div>
	</div>

	<div id="p_scents">
		<p>
			<label for="p_scnts"><input type="text" id="p_scnt" size="20"
				name="p_scnt" value="" placeholder="Input Value" /></label> <label
				for="pscnts"><input type="text" id="pscnt" size="20"
				name="pscnt" value="" placeholder="Input Value" /></label>
		</p>
	</div>
	<h2>
		<a href="#" id="addScnt">Add Another Input Box</a>
	</h2>


	<script type="text/javascript">
		$(function() {
			var scntDiv = $('#p_scents');
			var i = $('#p_scents p').size() + 1;

			$('#addScnt')
					.on(
							'click',
							function() {
								$(
										'<p><label for="p_scnts"><input type="text" id="p_scnt" size="20" name="p_scnt_' + i +'" value="" placeholder="Input Value" /></label> -&gt; <label for="pscnts"><input type="text" id="pscnts" size="20" name="pscnt_' + i +'" value="" placeholder="Input Value" /></label> <a href="#" id="remScnt'
												+ i
												+ '" onclick=javascript:removeField();>Remove</a></p>')
										.appendTo(scntDiv);
								i++;
								console.log(i);
								return false;
							});

			$('#remScnt' + i).on('click', function() {
				if (i > 2) {
					console.log("removing this..");
					$(this).parents('p').remove();
					i--;
				}
				return false;
			});
			$.fn.removeField = function() {
				console.log("before: " + i);
				$(this).parents('p').remove();
				i--;
				console.log("after: " + i);
			};
		})

		/* (function( $ ) {
			$.fn.removeField = function() {
				console.log("removeField called");
			};
		}( jQuery )) */
	</script>
</body>
</html>