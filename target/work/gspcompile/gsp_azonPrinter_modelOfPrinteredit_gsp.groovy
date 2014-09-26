import com.azonPrinter.ModelOfPrinter
import com.azonPrinter.ArduinoCode
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_azonPrinter_modelOfPrinteredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/modelOfPrinter/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'modelOfPrinter.label', default: 'ModelOfPrinter'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',16,['code':("Add Feature"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'controller':("features"),'action':("create"),'params':(['modelOfPrinter.id': modelOfPrinterInstance?.id ])],2)
printHtmlPart(8)
expressionOut.print(listOfComments)
printHtmlPart(9)
invokeTag('message','g',17,['code':("Logs of Comments"),'args':([entityName])],-1)
printHtmlPart(10)
expressionOut.print(createLink(uri: '/logout'))
printHtmlPart(6)
invokeTag('message','g',17,['code':("default.logout.label"),'default':("Logout")],-1)
printHtmlPart(11)
invokeTag('message','g',19,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(18)
expressionOut.print(error.field)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('message','g',28,['error':(error)],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',29,['bean':(modelOfPrinterInstance),'var':("error")],3)
printHtmlPart(22)
})
invokeTag('hasErrors','g',29,['bean':(modelOfPrinterInstance)],2)
printHtmlPart(23)
createTagBody(2, {->
printHtmlPart(24)
invokeTag('hiddenField','g',31,['name':("version"),'value':(modelOfPrinterInstance?.version)],-1)
printHtmlPart(25)
invokeTag('render','g',33,['template':("form")],-1)
printHtmlPart(26)
invokeTag('actionSubmit','g',38,['class':("save"),'action':("update"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(27)
})
invokeTag('form','g',38,['url':([resource:modelOfPrinterInstance, action:'update']),'method':("PUT")],2)
printHtmlPart(28)
invokeTag('select','g',51,['value':(specificversionOfCode),'name':("specificversionOfCode"),'from':(versionOfCodeList),'noSelection':(['':'--']),'onchange':(remoteFunction(action: 'edit', id:modelOfPrinterInstance?.id, params: '\'specificversionOfCode=\'+ this.value' , update: 'update-div'))],-1)
printHtmlPart(29)
invokeTag('select','g',53,['value':(specificversionOfShield),'name':("specificversionOfShield"),'from':(versionOfShieldList),'noSelection':(['':'--']),'onchange':(remoteFunction(action: 'edit', id:modelOfPrinterInstance?.id, params: '\'specificversionOfShield=\'+ this.value',  update: 'update-div'))],-1)
printHtmlPart(30)
if(true && (flash.message)) {
printHtmlPart(31)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(32)
invokeTag('sortableColumn','g',56,['property':("versionOfCode"),'title':(message(code: 'arduinoCode.versionOfCode.label', default: 'Version Of Code'))],-1)
printHtmlPart(33)
invokeTag('sortableColumn','g',57,['property':("comments"),'title':(message(code: 'arduinoCode.comments.label', default: 'Comments'))],-1)
printHtmlPart(34)
invokeTag('message','g',57,['code':("arduinoCode.modelOfPrinter.label"),'default':("Version Of Shield")],-1)
printHtmlPart(35)
loop:{
int i = 0
for( featuresName1 in (featuresName) ) {
printHtmlPart(36)
expressionOut.print(featuresName[i])
printHtmlPart(37)
i++
}
}
printHtmlPart(38)
invokeTag('message','g',58,['code':("arduinoCode.modelOfPrinter.label"),'default':("Arduino Code")],-1)
printHtmlPart(39)
loop:{
int i = 0
for( arduinoCodeInstance in (arduinoCodeInstanceList) ) {
printHtmlPart(40)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(41)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: arduinoCodeInstance, field: "versionOfCode"))
})
invokeTag('link','g',61,['controller':("arduinoCode"),'action':("edit"),'id':(arduinoCodeInstance.id)],3)
printHtmlPart(42)
invokeTag('img','g',61,['dir':("images"),'file':("information_sign.jpg"),'width':("15"),'height':("15"),'class':("masterTooltip"),'title':(arduinoCodeInstance.comments)],-1)
printHtmlPart(43)
expressionOut.print(fieldValue(bean: arduinoCodeInstance, field: "versionOfShield"))
printHtmlPart(44)
if(true && (arduinoCodeInstance?.feature1 != null)) {
printHtmlPart(45)
invokeTag('checkBox','g',70,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature1),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature1+'&completed=\'+ this.checked'))],-1)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (arduinoCodeInstance?.feature2 != null)) {
printHtmlPart(45)
invokeTag('checkBox','g',79,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature2),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature2+'&completed=\'+ this.checked'))],-1)
printHtmlPart(48)
}
printHtmlPart(47)
if(true && (arduinoCodeInstance?.feature3 != null)) {
printHtmlPart(45)
invokeTag('checkBox','g',85,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature3),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature3+'&completed=\'+ this.checked'))],-1)
printHtmlPart(49)
}
printHtmlPart(47)
if(true && (arduinoCodeInstance?.feature4 != null)) {
printHtmlPart(45)
invokeTag('checkBox','g',95,['name':('items.'+ arduinoCodeInstance?.id),'value':(arduinoCodeInstance?.hasfeature4),'onclick':(remoteFunction(action:'toggleCompleted', id:arduinoCodeInstance.id, params: '\'featureName='+arduinoCodeInstance.feature4+'&completed=\'+ this.checked'))],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (arduinoCodeInstance?.hasCode)) {
printHtmlPart(52)
expressionOut.print(arduinoCodeInstance?.nameOfFile)
printHtmlPart(53)
expressionOut.print(arduinoCodeInstance?.nameOfFile)
printHtmlPart(54)
}
printHtmlPart(55)
i++
}
}
printHtmlPart(56)
invokeTag('paginate','g',101,['total':(arduinoCodeInstanceCount ?: 0)],-1)
printHtmlPart(57)
createTagBody(2, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'arduinoCode.label', default: 'ArduinoCode')]))
})
invokeTag('link','g',106,['controller':("arduinoCode"),'action':("create"),'params':(['modelOfPrinter.id': modelOfPrinterInstance?.id])],2)
printHtmlPart(58)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(59)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1410009772000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
