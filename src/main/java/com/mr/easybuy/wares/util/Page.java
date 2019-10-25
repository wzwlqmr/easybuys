package com.mr.easybuy.wares.util;

public class Page {
	private Integer page=1;//当前页
	private Integer rows=3;//每页条数
	private Integer startPos;//开始条数
	
	public void calculate() {
		this.startPos=(page-1)*rows;
		
	}

	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", startPos=" + startPos + "]";
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStartPos() {
		return startPos;
	}

	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}
	
}
