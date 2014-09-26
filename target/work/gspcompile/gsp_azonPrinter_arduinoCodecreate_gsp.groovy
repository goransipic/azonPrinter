import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_azonPrinter_arduinoCodecreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/arduinoCode/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'arduinoCode.label', default: 'ArduinoCode'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.create.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',9,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(4)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(5)
invokeTag('message','g',12,['code':("default.home.label")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/logout'))
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.logout.label"),'default':("Logout")],-1)
printHtmlPart(7)
invokeTag('message','g',17,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(14)
expressionOut.print(error.field)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('message','g',25,['error':(error)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',25,['bean':(arduinoCodeInstance),'var':("error")],3)
printHtmlPart(18)
})
invokeTag('hasErrors','g',25,['bean':(arduinoCodeInstance)],2)
printHtmlPart(19)
createTagBody(2, {->
printHtmlPart(19)
invokeTag('hiddenField','g',30,['name':("orderIndex"),'value':(arduinoCodeInstance?.orderIndex)],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',31,['name':("nameOfFile"),'value':(arduinoCodeInstance?.nameOfFile)],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',32,['name':("versionOfCode"),'required':(""),'value':(arduinoCodeInstance?.versionOfCode)],-1)
printHtmlPart(20)
invokeTag('render','g',33,['template':("form")],-1)
printHtmlPart(21)
invokeTag('submitButton','g',36,['name':("create"),'class':("save"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(22)
})
invokeTag('form','g',37,['action':("save"),'enctype':("multipart/form-data")],2)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',38,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1408953836768L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
