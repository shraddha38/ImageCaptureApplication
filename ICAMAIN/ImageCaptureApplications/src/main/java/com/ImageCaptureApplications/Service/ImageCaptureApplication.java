package com.ImageCaptureApplications.Service;

import java.text.SimpleDateFormat;
import java.util.*;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.ImageCaptureApplications.Service.*;
import ch.qos.logback.classic.Logger;

@SpringBootApplication

@EnableScheduling
public class ImageCaptureApplication{

	public static void main(String[] args) {
	
		SpringApplication.run(ImageCaptureApplication.class, args);
		//ApplicationContext context = SpringApplication.run(ImageCaptureApplication.class, args);
		//ProcessFilesUtil processFilesUtil = (ProcessFilesUtil) context.getBean("processFilesUtil");
		//processFilesUtil.processFile();
		//SpringApplication.run(app.class, args);
		
		//SpringApplication.run(SpringBootSessionApplication.class, args);
	}	
}