package com.abhi.pojo;

import java.util.Arrays;

public class DelFrmSys {
	private int clientId;
	private int[] userId;
	private long ts;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int[] getUserId() {
		return userId;
	}
	public void setUserId(int[] userId) {
		this.userId = userId;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	
	@Override
	public String toString() {
		return "DelFrmSys [clientId=" + clientId + ", userId=" + Arrays.toString(userId) + ", ts=" + ts + "]";
	}
	
}