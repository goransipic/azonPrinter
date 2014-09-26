import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_azonPrinter_modelOfPrinterlistArduinoCode_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/modelOfPrinter/listArduinoCode.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('sortableColumn','g',7,['property':("versionOfCode"),'title':(message(code: 'arduinoCode.versionOfCode.label', default: 'Version Of Code'))],-1)
printHtmlPart(1)
invokeTag('sortableColumn','g',8,['property':("comments"),'title':(message(code: 'arduinoCode.comments.label', default: 'Comments'))],-1)
printHtmlPart(2)
invokeTag('message','g',9,['code':("arduinoCode.modelOfPrinter.label"),'default':("Version Of Shield")],-1)
printHtmlPart(3)
loop:{
int i = 0
for( featuresName1 in (featuresName) ) {
printHtmlPart(4)
expressionOut.print(featuresName[i])
printHtmlPart(5)
i++
}
}
printHtmlPart(2)
invokeTag('message','g',11,['code':("arduinoCode.modelOfPrinter.label"),'default':("Arduino Code")],-1)
printHtmlPart(6)
loop:{
int i = 0
for( arduinoCodeInstance in (arduinoCodeInstanceList) ) {
printHtmlPart(7)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(fieldValue(bean: arduinoCodeInstance, field: "versionOfCode"))
})
invokeTag('link','g',19,['controller':("arduinoCode"),'action':("edit"),'id':(arduinoCodeInstance.id)],2)
printHtmlPart(9)
invokeTag('img','g',22,['dir':("images"),'file':("information_sign.jpg"),'width':("15"),'height':("15"),'class':("masterTooltip"),'title':(arduinoCodeInstance.comments)],-1)
printHtmlPart(10)
expressionOut.print(fieldValue(bean: arduinoCodeInstance, field: "versionOfShield"))
printHtmlPart(11)
if(true && (arduinoCodeInstance?.feature1 != null)) {
printHtmlPart(12)
invokeTag('checkBox','g',28,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature1),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature1+'&completed=\'+ this.checked'))],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (arduinoCodeInstance?.feature2 != null)) {
printHtmlPart(12)
invokeTag('checkBox','g',35,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature2),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature2+'&completed=\'+ this.checked'))],-1)
printHtmlPart(15)
}
printHtmlPart(14)
if(true && (arduinoCodeInstance?.feature3 != null)) {
printHtmlPart(12)
invokeTag('checkBox','g',38,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature3),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature3+'&completed=\'+ this.checked'))],-1)
printHtmlPart(16)
}
printHtmlPart(14)
if(true && (arduinoCodeInstance?.feature4 != null)) {
printHtmlPart(12)
invokeTag('checkBox','g',41,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature4),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature4+'&completed=\'+ this.checked'))],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (arduinoCodeInstance?.hasCode)) {
printHtmlPart(19)
expressionOut.print(arduinoCodeInstance?.nameOfFile)
printHtmlPart(20)
expressionOut.print(arduinoCodeInstance?.nameOfFile)
printHtmlPart(21)
}
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',44,['total':(arduinoCodeInstanceCount ?: 0)],-1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1409122597000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
