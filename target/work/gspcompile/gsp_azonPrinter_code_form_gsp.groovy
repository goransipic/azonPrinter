import com.azonPrinter.Code
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_azonPrinter_code_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/code/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: codeInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("code.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'maxlength':("30"),'required':(""),'value':(codeInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: codeInstance, field: 'shortDescription', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("code.shortDescription.label"),'default':("Short Description")],-1)
printHtmlPart(2)
invokeTag('textArea','g',19,['name':("shortDescription"),'cols':("40"),'rows':("5"),'required':(""),'value':(codeInstance?.shortDescription)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: codeInstance, field: 'longDescription', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("code.longDescription.label"),'default':("Long Description")],-1)
printHtmlPart(2)
invokeTag('textArea','g',28,['name':("longDescription"),'cols':("40"),'rows':("5"),'required':(""),'value':(codeInstance?.longDescription)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: codeInstance, field: 'date', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("code.date.label"),'default':("Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',37,['name':("date"),'precision':("day"),'value':(codeInstance?.date)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403813154000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
