package com.abhi.pojo;

import java.util.Arrays;

public class SmsBc {
	
	private int clientId;
	private int msgId;
	private long ts;
	private int[] userId;
	private String trId;
	private String status;
	private boolean skip;
	private int freqCapFlag;
	
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
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public int[] getUserId() {
		return userId;
	}
	public void setUserId(int[] userId) {
		this.userId = userId;
	}
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSkip() {
		return skip;
	}
	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	public int getFreqCapFlag() {
		return freqCapFlag;
	}
	public void setFreqCapFlag(int freqCapFlag) {
		this.freqCapFlag = freqCapFlag;
	}
	
	@Override
	public String toString() {
		return "SmsBc [clientId=" + clientId + ", msgId=" + msgId + ", ts=" + ts + ", userId=" + Arrays.toString(userId)
				+ ", trId=" + trId + ", status=" + status + ", skip=" + skip + ", freqCapFlag=" + freqCapFlag + "]";
	}
	
}
