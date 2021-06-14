var mongoose=require('mongoose');

var StudentSchema = new mongoose.Schema({
	name:String,
    fatherName:String,
    dob:String,
    pancard:String
});

module.exports = mongoose.model(
	'student', StudentSchema, 'icatest');
