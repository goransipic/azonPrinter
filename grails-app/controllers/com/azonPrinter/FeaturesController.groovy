package com.azonPrinter
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FeaturesController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Features.list(params), model:[featuresInstanceCount: Features.count()]
    }

    def show(Features featuresInstance) {
        respond featuresInstance
    }

    def create() {
        respond new Features(params)
    }

    @Transactional
    def save(Features featuresInstance) {
        if (featuresInstance == null) {
            notFound()
            return
        }

        if (featuresInstance.hasErrors()) {
            respond featuresInstance.errors, view:'create'
            return
        }

        featuresInstance.save flush:true
		
		def selectedModelOfPrinter = ModelOfPrinter.get(params.modelOfPrinter.id)
		
		def arduinoCodeInstanceList = ArduinoCode.where{
			modelOfPrinter == selectedModelOfPrinter
		}
		
		def featuresInstanceList = Features.where{
			modelOfPrinter == selectedModelOfPrinter
		}
		def  featuresInstanceCount = featuresInstanceList.count();
		
		println(featuresInstanceCount)
		if (featuresInstanceCount == 1){
			
			for(arduinoCodeInstance in arduinoCodeInstanceList)
			{
				arduinoCodeInstance.feature1 = featuresInstance.title
				arduinoCodeInstance.hasfeature1 = true
				arduinoCodeInstance.save flush:true
			}
		}
		if (featuresInstanceCount == 2){
			
			for(arduinoCodeInstance in arduinoCodeInstanceList)
			{
				arduinoCodeInstance.feature2 = featuresInstance.title
				arduinoCodeInstance.hasfeature2 = true
				arduinoCodeInstance.save flush:true
			}
			
		
		}
		if (featuresInstanceCount == 3){
			
			for(arduinoCodeInstance in arduinoCodeInstanceList)
			{
				arduinoCodeInstance.feature3 = featuresInstance.title
				arduinoCodeInstance.hasfeature3 = true
				arduinoCodeInstance.save flush:true
			}
		}
		if (featuresInstanceCount == 4){
			
			for(arduinoCodeInstance in arduinoCodeInstanceList)
			{
				arduinoCodeInstance.feature4 = featuresInstance.title
				arduinoCodeInstance.hasfeature4 = true
				arduinoCodeInstance.save flush:true
			}
		
		}
		if (featuresInstanceCount == 5){
		
		}
		if (featuresInstanceCount == 6){
		
		}
		if (featuresInstanceCount == 7){
		
		}
		if (featuresInstanceCount == 8){
		
		}
		
       /* request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'features.label', default: 'Features'), featuresInstance.id])
                redirect featuresInstance
            }
            '*' { respond featuresInstance, [status: CREATED] }
        }*/
		redirect(controller: "modelOfPrinter", action: "edit" , params: [id:  featuresInstance.modelOfPrinter.id] )
    }

    def edit(Features featuresInstance) {
        respond featuresInstance
    }

    @Transactional
    def update(Features featuresInstance) {
        if (featuresInstance == null) {
            notFound()
            return
        }

        if (featuresInstance.hasErrors()) {
            respond featuresInstance.errors, view:'edit'
            return
        }

        featuresInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Features.label', default: 'Features'), featuresInstance.id])
                redirect featuresInstance
            }
            '*'{ respond featuresInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Features featuresInstance) {

        if (featuresInstance == null) {
            notFound()
            return
        }

        featuresInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Features.label', default: 'Features'), featuresInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'features.label', default: 'Features'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
