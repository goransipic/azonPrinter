

<div id="list-arduinoCode" class="content scaffold-list" role="main">
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
					<th><g:message code="arduinoCode.modelOfPrinter.label" default="Arduino Code" /></th>
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
						<td> <a  id="pdf-link" class="cupid-blue" href="http://10.0.0.253:8000/arduinoKodBackup/${arduinoCodeInstance?.nameOfFile}" download="${arduinoCodeInstance?.nameOfFile}">Download Arduino Code </a>  </td>
	                	</g:if>
	                </tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${arduinoCodeInstanceCount ?: 0}" />
			</div>
		</div>
		
	
