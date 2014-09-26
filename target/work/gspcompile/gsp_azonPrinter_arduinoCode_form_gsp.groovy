import com.azonPrinter.ArduinoCode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_azonPrinter_arduinoCode_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/arduinoCode/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',5,['name':("modelOfPrinter.id"),'value':(arduinoCodeInstance?.modelOfPrinter?.id)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: arduinoCodeInstance, field: 'modelOfPrinter', 'error'))
printHtmlPart(2)
invokeTag('message','g',10,['code':("arduinoCode.modelOfPrinter.label"),'default':("Version Of Shield")],-1)
printHtmlPart(3)
invokeTag('select','g',19,['noSelection':(['null':'Select a Resource']),'optionKey':("versionOfShield"),'optionValue':(versionOfShield),'name':("versionOfShield"),'from':(com.azonPrinter.VersionOfShield.list()),'value':(arduinoCodeInstance?.versionOfShield),'class':("many-to-one")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: arduinoCodeInstance, field: 'type', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("item.type.label"),'default':("Type")],-1)
printHtmlPart(6)
invokeTag('select','g',28,['name':("type"),'from':(ArduinoCode.ItemType),'value':(arduinoCodeInstance?.type)],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: arduinoCodeInstance, field: 'Comments', 'error'))
printHtmlPart(8)
invokeTag('message','g',33,['code':("modelOfPrinter.descriptionOfSet.label"),'default':("Comments:")],-1)
printHtmlPart(9)
invokeTag('textArea','g',33,['name':("comments"),'value':(arduinoCodeInstance?.comments),'rows':("5"),'cols':("100")],-1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: arduinoCodeInstance, field: 'Comments', 'error'))
printHtmlPart(8)
invokeTag('message','g',37,['code':("arduinoCode.modelOfPrinter.label"),'default':("Upload Code:")],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1408953784630L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
