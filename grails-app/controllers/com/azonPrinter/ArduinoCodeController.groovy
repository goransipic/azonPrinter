package com.azonPrinter

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.springframework.security.access.annotation.Secured

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.IOUtils

@Secured(['ROLE_ADMIN', 'ROLE_PARTNER'])
class ArduinoCodeController {

    //static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]
	
	def newFeature(){
		
		if(params.modelOfPrinter.id){
			
		}
	}
	
	def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ArduinoCode.list(params), model:[arduinoCodeInstanceCount: ArduinoCode.count()]
	}

    def show(ArduinoCode arduinoCodeInstance) {
        respond arduinoCodeInstance
    }

    def create() {
		//println(params.modelOfPrinter.id)
		def orderIndex = []
		
		def versionOfShieldList = []
		
		versionOfShieldList << "Default"
		
		def selectedModelOfPrinter = ModelOfPrinter.get(params.modelOfPrinter.id)
		
		def arduinoCodeInstanceList = ArduinoCode.where{
			modelOfPrinter == selectedModelOfPrinter
		}
		
		for (arduinoCodeInstance in arduinoCodeInstanceList){
			
			orderIndex << arduinoCodeInstance.orderIndex
			
			versionOfShieldList << arduinoCodeInstance.versionOfShield
			
			orderIndex.asList().sort{
				a,b -> b <=> a
			}
		}
		
		def arduinoCodeInstance = new ArduinoCode(params)
		
		arduinoCodeInstance.versionOfCode = "Demo"
		
		/*for (arduinoCodeInstanceTemp in arduinoCodeInstanceList){
			
			if (arduinoCodeInstanceTemp.orderIndex == orderIndex[0]){
				
				arduinoCodeInstance.comments = arduinoCodeInstanceTemp.comments
			}
		}*/
		
		def maxOrderIndex = ArduinoCode.executeQuery('select max(orderIndex) from ArduinoCode')[0]
		 
		maxOrderIndex = maxOrderIndex ? (int)maxOrderIndex + 1 : 1
		 
		arduinoCodeInstance.orderIndex = maxOrderIndex;
		
		[arduinoCodeInstance: arduinoCodeInstance, versionOfShieldList: versionOfShieldList]
		//respond new ArduinoCode(params), model:[arduinoCodeInstance:arduinoCodeInstance]
    }

    @Transactional
    def save(ArduinoCode arduinoCodeInstance) {
		
		//println(params)
        if (arduinoCodeInstance == null) {
            notFound()
            return
        }

        if (arduinoCodeInstance.hasErrors()) {
            respond arduinoCodeInstance.errors, view:'create'
            return
        }
		
		/*def maxOrderIndex = ArduinoCode.executeQuery('select max(orderIndex) from ArduinoCode')[0]
		
		maxOrderIndex = maxOrderIndex ? (int)maxOrderIndex + 1 : 1
		
		arduinoCodeInstance.orderIndex = maxOrderIndex + 1 */
		
		def arduinoCodeFile = request.getFile('arduinoCode')
		
		if(arduinoCodeFile && !arduinoCodeFile.empty){
			
			if(arduinoCodeFile.contentType != 'application/octet-stream'){
				flash.message = "Only ino files is accepted for files."
				redirect(action: "edit", id: arduinoCodeInstance.id)
				return
			}
			//new File("/var/lib/tomcat7/arduinoKodBackup"+arduinoCodeFile.originalFilename)
			
			arduinoCodeInstance.nameOfFile = arduinoCodeFile.originalFilename
			
			//arduinoCodeFile.transferTo(new File("/var/lib/tomcat7/webapps/arduinoKodBackup/"+arduinoCodeFile.originalFilename))
			String temp = arduinoCodeFile.originalFilename;
			
			File arduinoCode = new File("/var/lib/tomcat7/webapps/arduinoKodBackup/" + temp)
			if (arduinoCode.exists()){
				respond arduinoCodeInstance.errors, view:'create'
				return
				//arduinoCodeFile.transferTo(new File("/var/lib/tomcat7/webapps/arduinoKodBackup/"+splitString[0]))
			}
			//arduinoCodeFile.transferTo(new File("c:/" + temp))
			//arduinoCodeFile.transferTo(new File("/var/lib/tomcat7/webapps/arduinoKodBackup/"+splitString[0]))
			else{
				arduinoCodeFile.transferTo(arduinoCode) 
			}
			String[] splitString = temp.split("\\.")
			
			temp = splitString[0].replace("_", ".");
			
			splitString = null
			
			splitString = temp.split("\\.")
			
			println(splitString)
			
			temp = splitString[1] + "." + splitString[2] + "." + splitString[3]
			
			arduinoCodeInstance.versionOfCode = temp;
			
			arduinoCodeInstance.hasCode = true
		}
		
		arduinoCodeInstance.versionOfShield = params.versionOfShield;
		
		arduinoCodeInstance.save flush:true
		
		def selectedModelOfPrinter = ModelOfPrinter.get(params.modelOfPrinter.id)
		
		def featuresInstanceList = Features.where{
			modelOfPrinter == selectedModelOfPrinter
		}
		
		def  featuresInstanceCount = featuresInstanceList.count();
	
		if (featuresInstanceCount >= 1){
			
				arduinoCodeInstance.feature1 = featuresInstanceList[0].title
				arduinoCodeInstance.hasfeature1 = true
				arduinoCodeInstance.save flush:true
			
		}
		if (featuresInstanceCount >= 2){
			
				arduinoCodeInstance.feature2 = featuresInstanceList[1].title
				arduinoCodeInstance.hasfeature2 = true
				arduinoCodeInstance.save flush:true
		}
		if (featuresInstanceCount >= 3){
				
				arduinoCodeInstance.feature3 = featuresInstanceList[2].title
				arduinoCodeInstance.hasfeature3 = true
				arduinoCodeInstance.save flush:true
			
		}
		if (featuresInstanceCount >= 4){
				
				arduinoCodeInstance.feature4 = featuresInstanceList[3].title
				arduinoCodeInstance.hasfeature4 = true
				arduinoCodeInstance.save flush:true
		}
		if (featuresInstanceCount >= 5){
		
		}
		if (featuresInstanceCount >= 6){
		
		}
		if (featuresInstanceCount >= 7){
		
		}
		if (featuresInstanceCount >= 8){
		
		}
		
		redirect(controller: "modelOfPrinter", action: "edit" , params: [id:  arduinoCodeInstance.modelOfPrinter.id] )
    }

    def edit(ArduinoCode arduinoCodeInstance) {
		
		[arduinoCodeInstance: arduinoCodeInstance, versionOfShieldList: arduinoCodeInstance.versionOfShield]
        //respond arduinoCodeInstance
    }

   
    def update(ArduinoCode arduinoCodeInstance) {
		
		//def arduinoCodeInstance = ArduinoCode.get(params.id)
		
        if (arduinoCodeInstance == null) {
            notFound()
            return
        }

        if (arduinoCodeInstance.hasErrors()) {
            respond arduinoCodeInstance.errors, view:'edit'
            return
        }
		
		def arduinoCodeFile = request.getFile('arduinoCode')
		
		if(arduinoCodeFile && !arduinoCodeFile.empty){
			
			if(arduinoCodeFile.contentType != 'application/octet-stream'){
				flash.message = "Only ino files is accepted for files."
				redirect(action: "edit", id: arduinoCodeInstance.id)
				return
			}
			//new File("/var/lib/tomcat7/arduinoKodBackup"+arduinoCodeFile.originalFilename)
			
			arduinoCodeInstance.nameOfFile = arduinoCodeFile.originalFilename
			
			//arduinoCodeFile.transferTo(new File("/var/lib/tomcat7/webapps/arduinoKodBackup/"+arduinoCodeFile.originalFilename))
			String temp = arduinoCodeFile.originalFilename;
			
			File arduinoCode = new File("/var/lib/tomcat7/webapps/arduinoKodBackup/" + temp)
			if (arduinoCode.exists()){
				respond arduinoCodeInstance.errors, view:'create'
				return
				//arduinoCodeFile.transferTo(new File("/var/lib/tomcat7/webapps/arduinoKodBackup/"+splitString[0]))
			}
			//arduinoCodeFile.transferTo(new File("c:/" + temp))
			//arduinoCodeFile.transferTo(new File("/var/lib/tomcat7/webapps/arduinoKodBackup/"+splitString[0]))
			else{
				arduinoCodeFile.transferTo(arduinoCode) 
			}
			  
			 
			//arduinoCodeFile.transferTo(new File("c:/" + temp))
			//arduinoCodeFile.transferTo(new File("/var/lib/tomcat7/webapps/arduinoKodBackup/"+splitString[0]))
			
			String[] splitString = temp.split("\\.")
			
			temp = splitString[0].replace("_", ".");
			
			splitString = null
			
			splitString = temp.split("\\.")
			
			println(splitString)
			
			temp = splitString[1] + "." + splitString[2] + "." + splitString[3]
			
			arduinoCodeInstance.versionOfCode = temp;
			
			arduinoCodeInstance.hasCode = true
		}
		
		
		arduinoCodeInstance.versionOfShield = params.versionOfShield;
		
		arduinoCodeInstance.save flush:true
		
		/* request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ArduinoCode.label', default: 'ArduinoCode'), arduinoCodeInstance.id])
                redirect arduinoCodeInstance
            }
            '*'{ respond arduinoCodeInstance, [status: OK] }
        }*/
		
		redirect(controller: "modelOfPrinter", action: "edit" , params: [id:  arduinoCodeInstance.modelOfPrinter.id] )
    }

    @Transactional
    def delete(ArduinoCode arduinoCodeInstance) {

        if (arduinoCodeInstance == null) {
            notFound()
            return
        }

        arduinoCodeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ArduinoCode.label', default: 'ArduinoCode'), arduinoCodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'arduinoCode.label', default: 'ArduinoCode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
