import com.azonPrinter.ModelOfPrinter
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_azonPrinter_modelOfPrinterindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/modelOfPrinter/index.gsp" }
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
invokeTag('message','g',8,['code':("default.list.label"),'args':([entityName])],-1)
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
invokeTag('message','g',15,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("create"),'action':("create")],2)
printHtmlPart(8)
expressionOut.print(createLink(uri: '/logout'))
printHtmlPart(6)
invokeTag('message','g',16,['code':("default.logout.label"),'default':("Logout")],-1)
printHtmlPart(9)
invokeTag('message','g',22,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',30,['property':("title"),'title':(message(code: 'modelOfPrinter.title.label', default: 'Title'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',35,['property':("dateCreated"),'title':(message(code: 'modelOfPrinter.dateCreated.label', default: 'Date Created'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',37,['property':("lastUpdated"),'title':(message(code: 'modelOfPrinter.lastUpdated.label', default: 'Last Updated'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( modelOfPrinterInstance in (modelOfPrinterInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: modelOfPrinterInstance, field: "title"))
})
invokeTag('link','g',45,['action':("edit"),'id':(modelOfPrinterInstance.id)],3)
printHtmlPart(18)
invokeTag('formatDate','g',47,['format':("yyyy-MM-dd"),'date':(modelOfPrinterInstance.dateCreated)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',49,['format':("yyyy-MM-dd"),'date':(modelOfPrinterInstance.lastUpdated)],-1)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',51,['total':(modelOfPrinterInstanceCount ?: 0)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',51,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1408692999913L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
