package com.abhi.pojo;

import java.util.Arrays;

public class DelListUser {
	private int clientId;
	private int[] userId;
	private long ts;
	private int [] list;
	private String type;
	private String sendToEaf;
	
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
	public int[] getList() {
		return list;
	}
	public void setList(int[] list) {
		this.list = list;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSendToEaf() {
		return sendToEaf;
	}
	public void setSendToEaf(String sendToEaf) {
		this.sendToEaf = sendToEaf;
	}
	
	@Override
	public String toString() {
		return "DelListUser [clientId=" + clientId + ", userId=" + Arrays.toString(userId) + ", ts=" + ts + ", list="
				+ Arrays.toString(list) + ", type=" + type + ", sendToEaf=" + sendToEaf + "]";
	}
	
}