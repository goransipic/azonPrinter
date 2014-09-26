package com.azonPrinter

class ModelOfPrinter {
	
	
	String title
	Date dateCreated
	Date lastUpdated
	
	static hasMany = [arduinoCode:ArduinoCode,featurs:Features]
	
	def beforeInsert(){
		dateCreated = new Date()
	}
	
	def beforeUpdate(){
		lastUpdated = new Date()
	}
	
	String toString(){
		"${title}"
	}
	
	def mapping = {
		version false
	}
	
	static constraints = {
		title blank: false
		
		
    }
}
