const express=require('express');
const bodyParser=require('body-parser');
const api = require('./api');

const port=3000;
const app=express();

app.listen(port, function() {
	console.log("Server is listening at port:" + port);
});

// Parses the text as url encoded data
app.use(bodyParser.urlencoded({extended: true}));

// Parses the text as json
app.use(bodyParser.json());

app.use('/api', api);





var env = require('dotenv').config()
var ejs = require('ejs');
var path = require('path');8
var mongoose = require('mongoose');
var session = require('express-session');
var MongoStore = require('connect-mongo')(session);


mongoose.connect('mongodb://sraddha_1:sraddha@cluster0-shard-00-00.bv1x1.mongodb.net:27017,cluster0-shard-00-01.bv1x1.mongodb.net:27017,cluster0-shard-00-02.bv1x1.mongodb.net:27017/icaextract?ssl=true&replicaSet=atlas-10gdcd-shard-0&authSource=admin&retryWrites=true&w=majority', {
  useNewUrlParser: true,
  useUnifiedTopology: true
}, (err) => {
  if (!err) {
    console.log('MongoDB Connection Succeeded.');
  } else {
    console.log('Error in DB connection : ' + err);
  }
});

var db = mongoose.connection;
db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function () {
});

app.use(session({
  secret: 'work hard',
  resave: true,
  saveUninitialized: false,
  store: new MongoStore({
    mongooseConnection: db
  })
}));

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');	

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use(express.static(__dirname + '/views'));

var index = require('./routes/index');
app.use('/', index);

// catch 404 and forward to error handler
app.use(function (req, res, next) {
  var err = new Error('File Not Found');
  err.status = 404;
  next(err);
});

// error handler
// define as the last app.use callback
app.use(function (err, req, res, next) {
  res.status(err.status || 500);
  res.send(err.message);
});


const PORT = process.env.PORT || 3500;
app.listen(PORT, function () {
  console.log('Server is started on http://127.0.0.1:'+PORT);
});

app.get('/Service', (req, res) => {
  res.render('login');
 });