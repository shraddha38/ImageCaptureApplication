package com.ImageCaptureApplications.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data", "page", "pageSize", "totalCount" })
public class ResponseJson implements Serializable {

	@JsonProperty("data")
	private static List<FileTypes> data = null;
	@JsonProperty("page")
	private int page;
	@JsonProperty("pageSize")
	private int pageSize;
	@JsonProperty("totalCount")
	private int totalCount;
	private final static long serialVersionUID = -5473513150328070953L;

	public ResponseJson() {
	}

	/**
	 *
	 * @param data
	 * @param pageSize
	 * @param page
	 * @param totalCount
	 */
	public ResponseJson(List<FileTypes> data, int page, int pageSize, int totalCount) {
		super();
		this.data = data;
		this.page = page;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	@JsonProperty("data")
	public static List<FileTypes> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<FileTypes> data) {
		this.data = data;
	}

	public ResponseJson withData(List<FileTypes> data) {
		this.data = data;
		return this;
	}

	@JsonProperty("page")
	public int getPage() {
		return page;
	}

	@JsonProperty("page")
	public void setPage(int page) {
		this.page = page;
	}

	public ResponseJson withPage(int page) {
		this.page = page;
		return this;
	}

	@JsonProperty("pageSize")
	public int getPageSize() {
		return pageSize;
	}

	@JsonProperty("pageSize")
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public ResponseJson withPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	@JsonProperty("totalCount")
	public int getTotalCount() {
		return totalCount;
	}

	@JsonProperty("totalCount")
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public ResponseJson withTotalCount(int totalCount) {
		this.totalCount = totalCount;
		return this;
	}

	@Override
	public String toString() {
		return " [data=" + data + ", page=" + page + ", pageSize=" + pageSize + ", totalCount=" + totalCount + "]";

	}

}