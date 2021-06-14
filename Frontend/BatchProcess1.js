var mongoose=require('mongoose');

var Batch = new mongoose.Schema({
    FileName:String,
    CreatedDate: String,
    BatchId:String,
    Status :String,
    Comment:String
    
});

module.exports = mongoose.model(
	'rahul', Batch, 'BatchProcess');