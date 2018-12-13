package com.abhi.pojo;

import java.util.Arrays;

public class UsbList {
	
	private int clientId;
	private int msgId;
	private int[] userId;
	private long ts;
	private String type;
	private String typeMobile;
	private String reason;
	private String bounceType;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeMobile() {
		return typeMobile;
	}
	public void setTypeMobile(String typeMobile) {
		this.typeMobile = typeMobile;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getBounceType() {
		return bounceType;
	}
	public void setBounceType(String bounceType) {
		this.bounceType = bounceType;
	}
	@Override
	public String toString() {
		return "UsbList [clientId=" + clientId + ", msgId=" + msgId + ", userId=" + Arrays.toString(userId) + ", ts="
				+ ts + ", type=" + type + ", typeMobile=" + typeMobile + ", reason=" + reason + ", bounceType="
				+ bounceType + "]";
	}

}