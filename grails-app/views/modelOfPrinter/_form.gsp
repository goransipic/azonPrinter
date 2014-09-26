<%@ page import="com.azonPrinter.ModelOfPrinter" %>



<div class="fieldcontain ${hasErrors(bean: modelOfPrinterInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="modelOfPrinter.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${modelOfPrinterInstance?.title}"/>

</div>



<%-- <div class="fieldcontain ${hasErrors(bean: modelOfPrinterInstance, field: 'Description', 'error')} ">
	<label for="descriptionOfSet">
		<g:message code="modelOfPrinter.descriptionOfSet.label" default="Comments:" />
			
	</label>
	<g:textArea name="descriptionOfSet"  value="${modelOfPrinterInstance?.descriptionOfSet}"/>
</div>
--%>
<%-- <div class="fieldcontain ${hasErrors(bean: modelOfPrinterInstance, field: 'arduinoCode', 'error')} ">
	<label for="arduinoCode">
		<g:message code="modelOfPrinter.arduinoCode.label" default="Arduino Code" />
	</label>
	
<ul class="one-to-many">
<g:each in="${modelOfPrinterInstance?.arduinoCode?}" var="a">
    <li><g:link controller="arduinoCode" action="edit" id="${a.id}">${a?.versionOfCode}</g:link></li>
</g:each>
<li class="add">
<g:link controller="arduinoCode" action="create" params="['modelOfPrinter.id': modelOfPrinterInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'arduinoCode.label', default: 'ArduinoCode')])}</g:link>

</li>
</ul>

</div>
--%>


