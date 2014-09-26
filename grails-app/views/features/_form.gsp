<%@ page import="com.azonPrinter.Features" %>

<g:hiddenField name="modelOfPrinter.id" value="${featuresInstance?.modelOfPrinter?.id}" />

<div class="fieldcontain ${hasErrors(bean: featuresInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="features.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${featuresInstance?.title}"/>

</div>

