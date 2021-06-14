var mongoose = require('mongoose');
const express = require('express');
var router = express.Router();
var StudentModel = require('./studentschema');
var BatchReport2 = require('./BatchReport1');
var Batch = require('./BatchProcess1');
const api=express();
const path=require("path");
const Static_path=path.join(__dirname,"../");

api.use(express.static(Static_path));
console.log(path.join(__dirname,"../ICAUSER"));

// Connecting to database
var query = 'mongodb://sraddha_1:sraddha@cluster0-shard-00-00.bv1x1.mongodb.net:27017,cluster0-shard-00-01.bv1x1.mongodb.net:27017,cluster0-shard-00-02.bv1x1.mongodb.net:27017/icaextract?ssl=true&replicaSet=atlas-10gdcd-shard-0&authSource=admin&retryWrites=true&w=majority'
const db = (query);
mongoose.Promise = global.Promise;

mongoose.connect(db, { useNewUrlParser : true,
useUnifiedTopology: true }, function(error) {
	if (error) {
		console.log("Error!" + error);
	}
});

module.exports = router;


// Details of pancards
router.get('/findall', function(req, res) {
    StudentModel.find(function(err, data) {
        if(err){
            console.log(err);
        }
        else{
            res.send(data);
        }
    });  
 });

 //BatchReport json
 router.get('/findalls', function(req, res) {
    BatchReport2.find(function(err, data) {
        if(err){
            console.log(err);
        }
        else{
            res.send(data);
        }
    });  
 });


 //Batch Process json
 router.get('/findallv', function(req, res) {
    Batch.find(function(err, data) {
        if(err){
            console.log(err);
        }
        else{
            res.send(data);
        }
    });  
 });

 api.get("/Service",(req,res)=>{
    res.send("ica")
});
 