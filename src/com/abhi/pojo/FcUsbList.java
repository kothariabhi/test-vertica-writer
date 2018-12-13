package com.abhi.pojo;


public class FcUsbList {
	
	private String trId;
	private String type;
	private String bounceType;
	private String reason;
	private int automationId;

	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBounceType() {
		return bounceType;
	}
	public void setBounceType(String bounceType) {
		this.bounceType = bounceType;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getAutomationId() {
		return automationId;
	}
	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}
	@Override
	public String toString() {
		return "FcUsbList [trId=" + trId + ", type=" + type + ", bounceType=" + bounceType + ", reason=" + reason
				+ ", automationId=" + automationId + "]";
	}
	
}