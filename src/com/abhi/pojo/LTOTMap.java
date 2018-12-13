package com.abhi.pojo;

import java.util.List;

public class LTOTMap {
	
	private int clientId;
	private List<LTOT> ltotList;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public List<LTOT> getLtotList() {
		return ltotList;
	}
	public void setLtotList(List<LTOT> ltotList) {
		this.ltotList = ltotList;
	}
	@Override
	public String toString() {
		return "LTOTMap [clientId=" + clientId + ", ltotList=" + ltotList + "]";
	}
	

}
