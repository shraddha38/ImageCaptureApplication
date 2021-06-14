package com.ImageCaptureApplications.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"documentType",
	"fileName",
	"fileURL"
})
public class FileTypes implements Serializable
{

	@JsonProperty("documentType")
	private String documentType;
	@JsonProperty("fileName")
	private String fileName;
	@JsonProperty("fileURL")
	private String fileURL;
	private final static long serialVersionUID = 3894257090437558388L;

	public FileTypes() {
	}

	public FileTypes(String documentType, String fileName, String fileURL) {
		super();
		this.documentType = documentType;
		this.fileName = fileName;
		this.fileURL = fileURL;
	}

	@JsonProperty("documentType")
	public String getDocumentType() {
		return documentType;
	}

	@JsonProperty("documentType")
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public FileTypes withDocumentType(String documentType) {
		this.documentType = documentType;
		return this;
	}

	@JsonProperty("fileName")
	public String getFileName() {
		return fileName;
	}

	@JsonProperty("fileName")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileTypes withFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	@JsonProperty("fileURL")
	public String getFileURL() {
		return fileURL;
	}

	@JsonProperty("fileURL")
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public FileTypes withFileURL(String fileURL) {
		this.fileURL = fileURL;
		return this;
	}

	@Override
	public String toString() {
		return "[documentType=" +documentType + ", fileUrl=" + fileURL + ", fileName=" + fileName
				+ "]";
	}

}