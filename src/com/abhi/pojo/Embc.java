package com.abhi.pojo;

import java.util.Arrays;

public class Embc {
	private int clientId;
	private int msgId;
	private long ts;
	private int[] userId;
	private String status;
	private boolean skip;
	private String tableName;

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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "Embc [clientId=" + clientId + ", msgId=" + msgId + ", ts=" + ts + ", userId=" + Arrays.toString(userId)
				+ ", status=" + status + ", skip=" + skip + ", tableName=" + tableName + "]";
	}
}