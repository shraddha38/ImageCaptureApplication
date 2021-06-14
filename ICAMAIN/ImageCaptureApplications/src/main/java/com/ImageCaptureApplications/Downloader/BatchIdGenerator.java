package com.ImageCaptureApplications.Downloader;

import java.util.UUID;  

public class  BatchIdGenerator 
{  
	public static String hello;
public static String BatchIDGenerator()   
{
 UUID uuid=UUID.randomUUID(); //Generates random UUID  
 hello = uuid.toString();
 return hello;
}  
}  