package com.ImageCaptureApplications.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.txw2.annotation.XmlElement;
@XmlElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class ApiSet {
	private ApiExtractData ApiExtractData;

    private String fileName;

    public void setApiExtractData(ApiExtractData ApiExtractData){
        this.ApiExtractData = ApiExtractData;
    }
    public ApiExtractData getApiExtractData(){
        return this.ApiExtractData;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getFileName(){
        return this.fileName;
    }
}