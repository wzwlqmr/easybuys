package com.mr.easybuy.wares.util;

import java.util.List;

public class DataGrid {
	private Integer total;
	private List rows;

	
	@Override
	public String toString() {
		return "DataGrid [total=" + total + ", rows=" + rows + "]";
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}

}
