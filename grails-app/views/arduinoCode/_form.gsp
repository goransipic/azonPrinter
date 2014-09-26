<%@ page import="com.azonPrinter.ArduinoCode" %>


<%-- 
<div class="fieldcontain ${hasErrors(bean: arduinoCodeInstance, field: 'versionOfCode', 'error')} required">
	<label for="versionOfCode">
		<g:message code="arduinoCode.versionOfCode.label" default="Version Of Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="versionOfCode" required="" value="${arduinoCodeInstance?.versionOfCode}"/>
</div>
--%>

<%-- 
<div class="fieldcontain ${hasErrors(bean: arduinoCodeInstance, field: 'comments', 'error')} required">
	<label for="comments">
		<g:message code="arduinoCode.comments.label" default="Comments" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="comments" required="" value="${arduinoCodeInstance?.comments}"/>

</div>
--%>

<g:hiddenField name="modelOfPrinter.id" value="${arduinoCodeInstance?.modelOfPrinter?.id}" />


<div class="fieldcontain ${hasErrors(bean: arduinoCodeInstance, field: 'modelOfPrinter', 'error')} required">
	<label for="modelOfPrinter">
		<g:message code="arduinoCode.modelOfPrinter.label" default="Version Of Shield" />
		<span class="required-indicator">*</span>
	</label>
	<g:select  noSelection="['null':'Select a Resource']" optionKey="versionOfShield" optionValue="${versionOfShield}" name="versionOfShield" from="${com.azonPrinter.VersionOfShield.list()}"  value="${arduinoCodeInstance?.versionOfShield}"  class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: arduinoCodeInstance, field: 'type', 'error')} ">
<label for="type">
	<g:message code="item.type.label" default="Type" />		
</label>	
<g:select  name="type" from="${ArduinoCode.ItemType}" value="${arduinoCodeInstance?.type}" />
</div>

<div class="fieldcontain ${hasErrors(bean: arduinoCodeInstance, field: 'Comments', 'error')} ">
	<label for="modelOfPrinter">
		<g:message code="modelOfPrinter.descriptionOfSet.label" default="Comments:" />
			
	</label>
	<g:textArea name="comments"  value="${arduinoCodeInstance?.comments}" rows="5" cols="100"/>
</div>

<div class="fieldcontain ${hasErrors(bean: arduinoCodeInstance, field: 'Comments', 'error')} ">
	<label for="modelOfPrinter">
		<g:message code="arduinoCode.modelOfPrinter.label" default="Upload Code:" />
		<%-- <span class="required-indicator">*</span> --%>
	</label>
	<input type='file' name='arduinoCode'/>
</div>
