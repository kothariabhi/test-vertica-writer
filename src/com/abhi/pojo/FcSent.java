package com.abhi.pojo;

public class FcSent {
	
	private int clientId;
	private int msgId;
	private long ts;
	private int userId;
	private String trId;
	private int size;
	private int automationId;
	private String status;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getAutomationId() {
		return automationId;
	}
	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFreqCapFlag() {
		return freqCapFlag;
	}
	public void setFreqCapFlag(int freqCapFlag) {
		this.freqCapFlag = freqCapFlag;
	}
	@Override
	public String toString() {
		return "FcSent [clientId=" + clientId + ", msgId=" + msgId + ", ts=" + ts + ", userId=" + userId + ", trId="
				+ trId + ", size=" + size + ", automationId=" + automationId + ", status=" + status + ", freqCapFlag="
				+ freqCapFlag + "]";
	}
	
}