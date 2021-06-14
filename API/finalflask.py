

from flask import Flask, jsonify, request
from flask_restful import Resource, Api
import json
import os, sys
from os.path import splitext
import requests
from flask_pymongo import PyMongo
from pymongo import MongoClient
from flask_mongoengine import MongoEngine
from flask import Flask, jsonify, request
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)
client =MongoClient("mongodb://sraddha_1:sraddha@cluster0-shard-00-00.bv1x1.mongodb.net:27017,cluster0-shard-00-01.bv1x1.mongodb.net:27017,cluster0-shard-00-02.bv1x1.mongodb.net:27017/icaextract?ssl=true&replicaSet=atlas-10gdcd-shard-0&authSource=admin&retryWrites=true&w=majority")
db = client.get_database('icaextract')
records = db.icatest
app.config['MONGO_DBNAME'] = 'icaextract' # Name of database on mongo
app.config["MONGO_URI"] = "mongodb://sraddha_1:sraddha@cluster0-shard-00-00.bv1x1.mongodb.net:27017,cluster0-shard-00-01.bv1x1.mongodb.net:27017,cluster0-shard-00-02.bv1x1.mongodb.net:27017/icaextract?ssl=true&replicaSet=atlas-10gdcd-shard-0&authSource=admin&retryWrites=true&w=majority" #URI to Atlas cluster  + Auth Credentials
db = MongoEngine()

@app.route('/apigetfiles', methods=['POST'])
def serv():
    '''
    path = path of server
    dirs = dir of the folder
    data = list of files in the dir
    sample file = http://localhost:8080/server/tomcat.png
    '''
    payload = request.json
    pageSize = payload["pagesize"]
    pageNo = payload["pageno"]
    print(payload)
    endpoint =  pageSize*pageNo
    startpoint= endpoint-pageSize 
    documentType = []
    emptyData = []
    path = "C:\\xampp1\\tomcat\\webapps\\ROOT\\server"
    dirs = os.listdir( path )
    fileName = list(filter(os.path.isfile, os.listdir("C:\\xampp1\\tomcat\\webapps\\ROOT\\server")))
    for file in fileName:
        documentType.append(file.split('.')[-1])
                
    if(endpoint>len(fileName)):
        endpoint = len(fileName)
        
    hosturl = 'http://localhost:8080//server//'
    #fileurl = [x + hosturl for x in fileurl]
    fileurl = [hosturl + sub for sub in fileName] 
   
    finaldata = []
    temp=()
    for values in range(startpoint,endpoint):
        temp = {"documentType":documentType[values],"fileURL":fileurl[values],"fileName":fileName[values]}
        finaldata.append(temp)
    
    print(startpoint)
    print(endpoint)
    print(len(finaldata))
    print(fileurl)

    
    if(((startpoint>len(documentType)))):
        return({'data':emptyData,'page':pageNo,'pageSize':pageSize,'totalCount' : len(documentType)})
    elif(((startpoint==len(documentType))and(endpoint==(len(documentType)+1)))):
         return({'data':emptyData,'page':pageNo,'pageSize':pageSize,'totalCount' : len(documentType)})
    elif(len(finaldata)==0):
        return({'data':emptyData,'page':pageNo,'pageSize':pageSize,'totalCount' : len(documentType)})
    else:
        for i in range(((endpoint-startpoint))):
            return({'data':finaldata,'page':pageNo,'pageSize':pageSize,'totalCount' : len(documentType)})    
    
   
@app.route('/apiputfiles',methods=['POST'])
def setvalues():
    payload = request.json
    extractedData = payload
    name = payload['name']
    fatherName = payload['fatherName']
    dob = payload['dob']
    pancard =payload['pancard']
    pancardValues= [{'name':name,'fatherName':fatherName,'dob':dob,'pancard':pancard}]
    records.insert_many(pancardValues)
    return({'name':name,'fatherName':fatherName,'dob':dob,'pancard':pancard})  

if __name__ == '__main__':
    app.run(host ='0.0.0.0',debug=True,port= 5000)

