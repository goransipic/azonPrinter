
<%@ page import="com.azonPrinter.ModelOfPrinter" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'modelOfPrinter.label', default: 'ModelOfPrinter')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-modelOfPrinter" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><a class="logout" href="${createLink(uri: '/logout')}"><g:message code="default.logout.label" default="Logout"/></a></li>
			</ul>
		</div>
		<div id="list-modelOfPrinter" class="content scaffold-list" role="main">
			<div>
			<div class="container">
				<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			</div>
		<%--		<div class="createcode" >
				<g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
				</div>  --%>
			</div>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'modelOfPrinter.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'modelOfPrinter.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'modelOfPrinter.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${modelOfPrinterInstanceList}" status="i" var="modelOfPrinterInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<%-- <td><g:link action="show" id="${modelOfPrinterInstance.id}">${fieldValue(bean: modelOfPrinterInstance, field: "title")}</g:link></td> --%>
						
						<td><g:link action="edit" id="${modelOfPrinterInstance.id}">${fieldValue(bean: modelOfPrinterInstance, field: "title")}</g:link></td>
						
						<td><g:formatDate format="yyyy-MM-dd" date="${modelOfPrinterInstance.dateCreated}" /></td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${modelOfPrinterInstance.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${modelOfPrinterInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
