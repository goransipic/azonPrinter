package com.azonPrinter

class ArduinoCode {
	
	
	String versionOfShield 
	String comments
	String nameOfFile
	String versionOfCode = null
	Date dateCreated
	Date lastUpdated
	Float orderIndex 
	ItemType type
	
	enum ItemType {
		Admin, Production
	}
	
	Boolean hasCode = false
	
	Boolean hasfeature1 = false
	Boolean hasfeature2 = false
	Boolean hasfeature3 = false
	Boolean hasfeature4 = false
	Boolean hasfeature5 = false
	Boolean hasfeature6 = false
	Boolean hasfeature7 = false
	Boolean hasfeature8 = false
	Boolean hasfeature9 = false
	Boolean hasfeature10 = false
	Boolean hasfeature11 = false
	Boolean hasfeature12 = false
	Boolean hasfeature13 = false
	Boolean hasfeature14 = false
	
	String feature1;
	String feature2;
	String feature3;
	String feature4;
	String feature5;
	String feature6;
	String feature7;
	String feature8;
	String feature9;
	String feature10;
	String feature11;
	String feature12;
	String feature13;
	String feature14;
	
	static belongsTo = [modelOfPrinter:ModelOfPrinter]
	
	def beforeInsert() {
		dateCreated = new Date()
	}
	
	def beforeUpdate() {
		lastUpdated = new Date()
	}
	
	def mapping = {
		
		version false
		type enumType:'ordinal', sqlType:'TINYINT'
	}
	
	String toString(){
		"${versionOfShield}"
	}
	
	static constraints = {
		
		versionOfCode blank:false 
		nameOfFile nullable: true
		comments blank:false
		comments(size:0..2147483646)
		feature1 nullable: true
		feature2 nullable: true
		feature3 nullable: true
		feature4 nullable: true
		feature5 nullable: true
		feature6 nullable: true
		feature7 nullable: true
		feature8 nullable: true
		feature9 nullable: true
		feature10 nullable: true
		feature11 nullable: true
		feature12 nullable: true
		feature13 nullable: true
		feature14 nullable: true
	}
}
