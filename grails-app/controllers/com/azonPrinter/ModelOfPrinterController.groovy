package com.azonPrinter
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.springframework.security.access.annotation.Secured

@Transactional(readOnly = false)
@Secured(['ROLE_ADMIN', 'ROLE_PARTNER'])
class ModelOfPrinterController {

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def toggleCompleted () {
		//println(params)
		
		def arduinoCodeInstance = ArduinoCode.get(params.id)
		
		if (arduinoCodeInstance.feature1 == params.featureName){
			
			arduinoCodeInstance.hasfeature1 = params.completed == 'true'
			arduinoCodeInstance.save flush:true
		}
		if (arduinoCodeInstance.feature2 == params.featureName){
			
			arduinoCodeInstance.hasfeature2 = params.completed == 'true'
			arduinoCodeInstance.save flush:true
		}
		if (arduinoCodeInstance.feature3 == params.featureName){
			
			arduinoCodeInstance.hasfeature3 = params.completed == 'true'
			arduinoCodeInstance.save flush:true
		}
		if (arduinoCodeInstance.feature4 == params.featureName){
			
			arduinoCodeInstance.hasfeature4 = params.completed == 'true'
			arduinoCodeInstance.save flush:true
		}
		render params.id
	}
	
    def index(Integer max) {
		
		params.max = Math.min(max ?: 10, 100)
        respond ModelOfPrinter.list(params), model:[modelOfPrinterInstanceCount: ModelOfPrinter.count()]
    }

    def show(ModelOfPrinter modelOfPrinterInstance) {
        respond modelOfPrinterInstance
    }

    def create() {
		
		String commentsDefaultValue = "Please write comments ...."
		
        respond new ModelOfPrinter(params), model:[commentsDefaultValue: commentsDefaultValue]
    }

    @Transactional
    def save(ModelOfPrinter modelOfPrinterInstance) {
        if (modelOfPrinterInstance == null) {
            notFound()
            return
        }

        if (modelOfPrinterInstance.hasErrors()) {
            respond modelOfPrinterInstance.errors, view:'create'
            return
        }

        modelOfPrinterInstance.save flush:true

      
		redirect(action: "index", id: modelOfPrinterInstance.id)
    }
	
def listArduinoCode (Long id){
	println(params)
	def modelOfPrinterInstance = ModelOfPrinter.get(id)
	
	def featuresName = []
	def featuresValue = []
	def versionOfCodeList = []
	def versionOfShieldList = []
	def listOfComments = []
	def specificversionOfCode
	def  specificversionOfShield
	
	if(params.specificversionOfShield){
		
		specificversionOfShield = params.specificversionOfShield
	}
	
	if(params.specificversionOfCode){
		
		specificversionOfCode = params.specificversionOfCode
	}
	
	def query = ArduinoCode.where{
		
		if(params.specificversionOfShield)
		versionOfShield == params?.specificversionOfShield
		if(params.specificversionOfCode)
		versionOfCode == params?.specificversionOfCode
		modelOfPrinter == modelOfPrinterInstance
	}
	
	def query1 = ArduinoCode.where{
		
		modelOfPrinter == modelOfPrinterInstance
	}
	
	def getInformationForFiltar = query1.list(sort: "versionOfCode", order: "desc")
	def arduinoCodeInstanceList = query.list(sort: "versionOfCode", order: "desc")
	
	for (arduinoCodeInstance in getInformationForFiltar){
		
		versionOfShieldList << arduinoCodeInstance.versionOfShield
		versionOfCodeList << arduinoCodeInstance.versionOfCode
		listOfComments << arduinoCodeInstance.comments
	}
	
	def featuresInstanceList = Features.where{
		
		modelOfPrinter == modelOfPrinterInstance
	}
	
	versionOfShieldList = versionOfShieldList.unique()
	
	for (featuresInstance in featuresInstanceList){
		
		featuresName << featuresInstance.title
	}
	//println(featuresName)
	
	[modelOfPrinterInstance: modelOfPrinterInstance, specificversionOfCode:specificversionOfCode, specificversionOfShield:specificversionOfShield, listOfComments:listOfComments, arduinoCodeInstanceList: arduinoCodeInstanceList, versionOfCodeList:versionOfCodeList, versionOfShieldList:versionOfShieldList, itemsTotal:modelOfPrinterInstance?.arduinoCode?.size(), featuresName:featuresName]
	
}
	
def edit(Long id) {
		println(params)
		def modelOfPrinterInstance = ModelOfPrinter.get(id)
		
		def featuresName = []
		def featuresValue = []
		def versionOfCodeList = []
		def versionOfShieldList = []
		def listOfComments = []
		def specificversionOfCode
		def  specificversionOfShield
		
		if( params.specificversionOfShield != null ){
			
			specificversionOfShield = params.specificversionOfShield
		}
		
		if( params.specificversionOfCode != null ){
			
			specificversionOfCode = params.specificversionOfCode
		}
		
		def query = ArduinoCode.where{
			
			if(params.specificversionOfShield != null)
			versionOfShield == params?.specificversionOfShield
			if(params.specificversionOfCode != null)
			versionOfCode == params?.specificversionOfCode
			modelOfPrinter == modelOfPrinterInstance
		}
		
		def query1 = ArduinoCode.where{
			
			modelOfPrinter == modelOfPrinterInstance
		}
		
		def getInformationForFiltar = query1.list(sort: "versionOfCode", order: "desc")
		def arduinoCodeInstanceList = query.list(sort: "versionOfCode", order: "desc")
		
		for (arduinoCodeInstance in getInformationForFiltar){
			
			versionOfShieldList << arduinoCodeInstance.versionOfShield
			versionOfCodeList << arduinoCodeInstance.versionOfCode
			listOfComments << arduinoCodeInstance.comments
		}
		
		def featuresInstanceList = Features.where{
			
			modelOfPrinter == modelOfPrinterInstance
		}
		
		versionOfShieldList = versionOfShieldList.unique()
		
		for (featuresInstance in featuresInstanceList){
			
			featuresName << featuresInstance.title
		}
		println(featuresName)
		
		[modelOfPrinterInstance: modelOfPrinterInstance, specificversionOfCode:specificversionOfCode, specificversionOfShield:specificversionOfShield, listOfComments:listOfComments, arduinoCodeInstanceList: arduinoCodeInstanceList, versionOfCodeList:versionOfCodeList, versionOfShieldList:versionOfShieldList, itemsTotal:modelOfPrinterInstance?.arduinoCode?.size(), featuresName:featuresName]
    }

    @Transactional
    def update(ModelOfPrinter modelOfPrinterInstance) {
        if (modelOfPrinterInstance == null) {
            notFound()
            return
        }

        if (modelOfPrinterInstance.hasErrors()) {
            respond modelOfPrinterInstance.errors, view:'edit'
            return
        }

        modelOfPrinterInstance.save flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ModelOfPrinter.label', default: 'ModelOfPrinter'), modelOfPrinterInstance.id])
                redirect modelOfPrinterInstance
            }
            '*'{ respond modelOfPrinterInstance, [status: OK] }
        }*/
		redirect(action: "edit", id: modelOfPrinterInstance.id)
    }

    @Transactional
    def delete(ModelOfPrinter modelOfPrinterInstance) {

        if (modelOfPrinterInstance == null) {
            notFound()
            return
        }

        modelOfPrinterInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ModelOfPrinter.label', default: 'ModelOfPrinter'), modelOfPrinterInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'modelOfPrinter.label', default: 'ModelOfPrinter'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
