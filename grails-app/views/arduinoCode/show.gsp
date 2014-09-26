
<%@ page import="com.azonPrinter.ArduinoCode" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'arduinoCode.label', default: 'ArduinoCode')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-arduinoCode" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-arduinoCode" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list arduinoCode">
			
				<g:if test="${arduinoCodeInstance?.versionOfCode}">
				<li class="fieldcontain">
					<span id="versionOfCode-label" class="property-label"><g:message code="arduinoCode.versionOfCode.label" default="Version Of Code" /></span>
					
						<span class="property-value" aria-labelledby="versionOfCode-label"><g:fieldValue bean="${arduinoCodeInstance}" field="versionOfCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${arduinoCodeInstance?.comments}">
				<li class="fieldcontain">
					<span id="comments-label" class="property-label"><g:message code="arduinoCode.comments.label" default="Comments" /></span>
					
						<span class="property-value" aria-labelledby="comments-label"><g:fieldValue bean="${arduinoCodeInstance}" field="comments"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${arduinoCodeInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="arduinoCode.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${arduinoCodeInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${arduinoCodeInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="arduinoCode.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${arduinoCodeInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${arduinoCodeInstance?.modelOfPrinter}">
				<li class="fieldcontain">
					<span id="modelOfPrinter-label" class="property-label"><g:message code="arduinoCode.modelOfPrinter.label" default="Model Of Printer" /></span>
					
						<span class="property-value" aria-labelledby="modelOfPrinter-label"><g:link controller="modelOfPrinter" action="show" id="${arduinoCodeInstance?.modelOfPrinter?.id}">${arduinoCodeInstance?.modelOfPrinter?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:arduinoCodeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${arduinoCodeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
