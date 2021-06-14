
var mongoose=require('mongoose');
const { Schema } = mongoose;

var BatchReport2 = new mongoose.Schema({
    Batchid:String,
    DownloadFailed:Number,
    Downloads:Number,
    ExtractionFailed:Number,
    Extracted:Number,
    TotalCounts:Number
   
});

module.exports = mongoose.model(
	'sraddha', BatchReport2, 'BatchReports');