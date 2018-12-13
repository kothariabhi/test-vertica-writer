package com.abhi.pojo;

import java.util.List;

public class SmsDlrMap {
	
	private int clientId;
	private String status;
	private List<SmsDlr> dlrList;
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<SmsDlr> getDlrList() {
		return dlrList;
	}
	public void setDlrList(List<SmsDlr> dlrList) {
		this.dlrList = dlrList;
	}
	@Override
	public String toString() {
		return "SmsDlrMap [clientId=" + clientId + ", status=" + status + ", dlrList=" + dlrList + "]";
	}
	
}
