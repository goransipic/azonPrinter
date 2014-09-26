<%@ page import="com.azonPrinter.ModelOfPrinter" %>
<%@ page import="com.azonPrinter.ArduinoCode" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'modelOfPrinter.label', default: 'ModelOfPrinter')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-modelOfPrinter" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<%--<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>  --%>
				<%-- <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li> --%>
				<li><g:link class="create" controller="features" action="create" params="['modelOfPrinter.id': modelOfPrinterInstance?.id ]"><g:message code="Add Feature" args="[entityName]" /></g:link></li> 
				<li><a href="#" class="list"  title="${listOfComments}" ><g:message code="Logs of Comments" args="[entityName]" /></a></li>
				<li><a class="logout" href="${createLink(uri: '/logout')}"><g:message code="default.logout.label" default="Logout"/></a></li>
			</ul>
		</div>
		<div id="edit-modelOfPrinter" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${modelOfPrinterInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${modelOfPrinterInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
		<%-- 	<div class="createcode" >
				<g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
			</div> --%>
			<g:form url="[resource:modelOfPrinterInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${modelOfPrinterInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				
					<div class="container_button">
						<div class="buttons">
						<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
						</div>
					</div>
			</g:form>
			
			<form action="list" id="logItemForm">
				<span id= "versionOfCodeList">																																														   
				<%-- Version Of Code: <g:select value="${specificversionOfCode}" name="specificversionOfCode" from="${versionOfCodeList}" noSelection="['':'--']" onchange="${remoteFunction(action: 'listArduinoCode', id:modelOfPrinterInstance?.id, params: '\'specificversionOfShield='+specificversionOfShield?.value+'&specificversionOfCode=\'+ this.value' , update: 'list-arduinoCode')}"/> --%>
				Version Of Code: <g:select value="${specificversionOfCode}" name="specificversionOfCode" from="${versionOfCodeList}" noSelection="['':'--']" onchange="${remoteFunction(action: 'edit', id:modelOfPrinterInstance?.id, params: '\'specificversionOfCode=\'+ this.value' , update: 'update-div')}"/>
				</span>
				<span id= "versionOfShieldList">
				<%-- Version Of Shield: <g:select   value="${specificversionOfShield}" name="specificversionOfShield" from="${versionOfShieldList}"  noSelection="['':'--']" onchange="${remoteFunction(action: 'listArduinoCode', id:modelOfPrinterInstance?.id, params: '\'specificversionOfCode='+specificversionOfCode?.value+'&specificversionOfShield=\'+ this.value',  update: 'list-arduinoCode')}"/> --%>
				Version Of Shield: <g:select   value="${specificversionOfShield}" name="specificversionOfShield" from="${versionOfShieldList}"  noSelection="['':'--']" onchange="${remoteFunction(action: 'edit', id:modelOfPrinterInstance?.id, params: '\'specificversionOfShield=\'+ this.value',  update: 'update-div')}"/>
				</span>
				<g:each in="${featuresName}" status="i" var="featuresName1">
						<span>${featuresName[i]} <g:select   value="${specificversionOfShield}" name="specificversionOfShield" from="${['TRUE', 'FALSE']}"  noSelection="['':'--']" onchange="${remoteFunction(action: 'listArduinoCode', id:modelOfPrinterInstance?.id, params: '\'specificversionOfCode='+specificversionOfCode?.value+'&specificversionOfShield=\'+ this.value',  update: 'list-arduinoCode')}"/></span>
	            </g:each>
	            <%-- <input name="submit" type="submit" value="Filter"> --%>
			</form>
			
		</div>
			<div id="list-arduinoCode" class="content scaffold-list" role="main">
			<%-- <h1><g:message code="default.list.label" args="[entityName]" /></h1> --%>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="versionOfCode" title="${message(code: 'arduinoCode.versionOfCode.label', default: 'Version Of Code')}" />
					
						<g:sortableColumn property="comments" title="${message(code: 'arduinoCode.comments.label', default: 'Comments')}" />
					
						<th><g:message code="arduinoCode.modelOfPrinter.label" default="Version Of Shield" /></th>
						
						<%-- <g:sortableColumn property="dateCreated" title="${message(code: 'arduinoCode.dateCreated.label', default: 'Date Created')}" /> --%>
					
						<%-- <g:sortableColumn property="lastUpdated" title="${message(code: 'arduinoCode.lastUpdated.label', default: 'Last Updated')}" /> --%>
						
						<g:each in="${featuresName}" status="i" var="featuresName1">
						<th>${featuresName[i]}</th>
	                	</g:each>
						
						<th><g:message code="arduinoCode.modelOfPrinter.label" default="Download Code" /></th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${arduinoCodeInstanceList}" status="i" var="arduinoCodeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link controller="arduinoCode" action="edit" id="${arduinoCodeInstance.id}">${fieldValue(bean: arduinoCodeInstance, field: "versionOfCode")}</g:link></td>
					
						<%-- <td>${fieldValue(bean: arduinoCodeInstance, field: "comments")}</td> --%>
						<td><g:img dir="images" file="information_sign.jpg" width="15" height="15" class="masterTooltip" title="${arduinoCodeInstance.comments}" /></td>
						<td>${fieldValue(bean: arduinoCodeInstance, field: "versionOfShield")}</td>
						
						<%-- <td><g:formatDate format="yyyy-MM-dd" date="${arduinoCodeInstance.dateCreated}" /></td> --%>
					
						<%-- <td><g:formatDate format="yyyy-MM-dd" date="${arduinoCodeInstance.lastUpdated}" /></td> --%>
					
						<%-- <td>${fieldValue(bean: arduinoCodeInstance, field: "modelOfPrinter")}</td>  --%>
						
						<g:if test="${arduinoCodeInstance?.feature1 != null }">
							<td><g:checkBox name="${'items.'+ arduinoCodeInstance?.id}" value="${arduinoCodeInstance?.hasfeature1}" onclick="${remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature1+'&completed=\'+ this.checked')}" /></td>
						</g:if>
	                	<g:if test="${arduinoCodeInstance?.feature2 != null}">
							<td><g:checkBox name="${'items.'+ arduinoCodeInstance?.id}" value="${arduinoCodeInstance?.hasfeature2}" onclick="${remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature2+'&completed=\'+ this.checked')}" /></td>
	                	</g:if>
	                	<g:if test="${arduinoCodeInstance?.feature3 != null }">
							<td><g:checkBox name="${'items.'+ arduinoCodeInstance?.id}" value="${arduinoCodeInstance?.hasfeature3}" onclick="${remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature3+'&completed=\'+ this.checked')}" /></td> 
						</g:if>
	                	<g:if test="${arduinoCodeInstance?.feature4 != null}">
							<td><g:checkBox name="${'items.'+ arduinoCodeInstance?.id}" value="${arduinoCodeInstance?.hasfeature4}" onclick="${remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature4+'&completed=\'+ this.checked')}" /></td> 
	                	</g:if>
						<g:if test="${arduinoCodeInstance?.hasCode}">
						<%-- <td> <a  id="pdf-link" class="cupid-blue" href="http://10.0.0.253:8000/arduinoKodBackup/${arduinoCodeInstance?.nameOfFile}" download="${arduinoCodeInstance?.nameOfFile}">Download Arduino Code </a>  </td> --%>
						<td> <a  href="http://10.0.0.253:8000/arduinoKodBackup/${arduinoCodeInstance?.nameOfFile}" download="${arduinoCodeInstance?.nameOfFile}"><g:img dir="images" file="downloadIcon.png" width="20" height="20"/> </a>  </td>
						
	                	</g:if>
	                </tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${arduinoCodeInstanceCount ?: 0}" />
			</div>
		</div>
		<div class="addArduinoCode">
			<g:link controller="arduinoCode" action="create" params="['modelOfPrinter.id': modelOfPrinterInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'arduinoCode.label', default: 'ArduinoCode')])}</g:link>
		</div>
	</body>
</html>
