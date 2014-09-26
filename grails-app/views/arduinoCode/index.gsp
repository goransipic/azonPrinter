
<%@ page import="com.azonPrinter.ArduinoCode" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'arduinoCode.label', default: 'ArduinoCode')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-arduinoCode" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-arduinoCode" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="versionOfCode" title="${message(code: 'arduinoCode.versionOfCode.label', default: 'Version Of Code')}" />
					
						<g:sortableColumn property="comments" title="${message(code: 'arduinoCode.comments.label', default: 'Comments')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'arduinoCode.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'arduinoCode.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="arduinoCode.modelOfPrinter.label" default="Model Of Printer" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${arduinoCodeInstanceList}" status="i" var="arduinoCodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${arduinoCodeInstance.id}">${fieldValue(bean: arduinoCodeInstance, field: "versionOfCode")}</g:link></td>
					
						<td>${fieldValue(bean: arduinoCodeInstance, field: "comments")}</td>
					
						<td><g:formatDate date="${arduinoCodeInstance.dateCreated}" /></td>
					
						<td><g:formatDate date="${arduinoCodeInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: arduinoCodeInstance, field: "modelOfPrinter")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${arduinoCodeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
