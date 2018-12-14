package com.abhi.pojo;

import java.util.Arrays;

public class DelList {
	
	private int clientId;
	private int[] list;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int[] getList() {
		return list;
	}
	public void setList(int[] list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "DelList [clientId=" + clientId + ", listId=" + Arrays.toString(list) + "]";
	}
	
}
