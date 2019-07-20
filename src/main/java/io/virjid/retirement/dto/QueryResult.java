package io.virjid.retirement.dto;

import java.util.List;


public class QueryResult {
	private int totalRows;
	private int totalPages=-1;
	private int pageSize;
	private int pageNo;
	private List<?> rows;

	public int getTotalPages() {
		if(this.totalPages==-1) {
			this.totalPages=this.totalRows/this.pageSize;
			if(this.totalRows%this.pageSize!=0) {
				this.totalPages++;
			}
		}
		return this.totalPages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
}