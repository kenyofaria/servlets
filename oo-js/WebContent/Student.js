/**
 * 
 */

class Student{
	
	constructor(registerNumber, name){
		this._registerNumber = registerNumber;
		this._name = name;
	}
	
	get registerNumber(){
		return this._registerNumber;
	}
	
	get name(){
		return this._name;
	}
}