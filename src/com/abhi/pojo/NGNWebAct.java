package com.abhi.pojo;

import java.util.Date;
import java.util.Map;

public class NGNWebAct {
	
	//fixed
	private String eventName;
	private String userKey;
	private String customerKey;
	private String uuid;
	private String siteId;
	private String browser;
	private long sid;
	private String visit;
	private int pts;
	private int sts;
	private long tx;
	private long ptx;
	private String url;
	private String purl;
	private int npv;
	private String title;
	private boolean automation;
	private int automationId;
	private String dpName;
	private String dpId;
	private String cg;
	private String mid;
	private long sessionId;
	private int sourceId; //mysql id for siteid
	private Map<String, Object> payload;
	private String stmSource;
	private Integer cpci;
	private Integer campaignId;
	private String cpcm;
	private String cpcs;
	private int msgId;
	private int notificationId;
	private String trId;
	private boolean conversion;
	private String revenuekey;
	private long userTimings;
	private String utmSource;
	private String utmMedium;
	private String utmCampaign;
	private String utmContent;
	private String utmTerm;
	private int isAmplified;
	private String lat;
	private String lng;
	//derived
	private int clientId;
	private int userId;
	private int eventId;
	private String userAgent;
	private int bod;
	private long ts;
	private Date tsDate;
	private String ip;
	private Integer browserId;
	private boolean identified;
	private int channelId;
	private String eventType = "w";

	public long getSessionId() {
		return sessionId;
	}
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getCustomerKey() {
		return customerKey;
	}
	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getVisit() {
		return visit;
	}
	public void setVisit(String visit) {
		this.visit = visit;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}
	public int getSts() {
		return sts;
	}
	public void setSts(int sts) {
		this.sts = sts;
	}
	public long getTx() {
		return tx;
	}
	public void setTx(long tx) {
		this.tx = tx;
	}
	public long getPtx() {
		return ptx;
	}
	public void setPtx(long ptx) {
		this.ptx = ptx;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public int getNpv() {
		return npv;
	}
	public void setNpv(int npv) {
		this.npv = npv;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isAutomation() {
		return automation;
	}
	public void setAutomation(boolean automation) {
		this.automation = automation;
	}
	public int getAutomationId() {
		return automationId;
	}
	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}
	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}
	public String getDpId() {
		return dpId;
	}
	public void setDpId(String dpId) {
		this.dpId = dpId;
	}
	public String getCg() {
		return cg;
	}
	public void setCg(String cg) {
		this.cg = cg;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public Map<String, Object> getPayload() {
		return payload;
	}
	public void setPayload(Map<String, Object> payload) {
		this.payload = payload;
	}
	public String getStmSource() {
		return stmSource;
	}
	public void setStmSource(String stmSource) {
		this.stmSource = stmSource;
	}
	public Integer getCpci() {
		return cpci;
	}
	public void setCpci(Integer cpci) {
		this.cpci = cpci;
	}
	public Integer getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
	public String getCpcm() {
		return cpcm;
	}
	public void setCpcm(String cpcm) {
		this.cpcm = cpcm;
	}
	public String getCpcs() {
		return cpcs;
	}
	public void setCpcs(String cpcs) {
		this.cpcs = cpcs;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public boolean isConversion() {
		return conversion;
	}
	public void setConversion(boolean conversion) {
		this.conversion = conversion;
	}
	public String getRevenuekey() {
		return revenuekey;
	}
	public void setRevenuekey(String revenuekey) {
		this.revenuekey = revenuekey;
	}
	public long getUserTimings() {
		return userTimings;
	}
	public void setUserTimings(long userTimings) {
		this.userTimings = userTimings;
	}
	public String getUtmSource() {
		return utmSource;
	}
	public void setUtmSource(String utmSource) {
		this.utmSource = utmSource;
	}
	public String getUtmMedium() {
		return utmMedium;
	}
	public void setUtmMedium(String utmMedium) {
		this.utmMedium = utmMedium;
	}
	public String getUtmCampaign() {
		return utmCampaign;
	}
	public void setUtmCampaign(String utmCampaign) {
		this.utmCampaign = utmCampaign;
	}
	public String getUtmContent() {
		return utmContent;
	}
	public void setUtmContent(String utmContent) {
		this.utmContent = utmContent;
	}
	public String getUtmTerm() {
		return utmTerm;
	}
	public void setUtmTerm(String utmTerm) {
		this.utmTerm = utmTerm;
	}
	public int getIsAmplified() {
		return isAmplified;
	}
	public void setIsAmplified(int isAmplified) {
		this.isAmplified = isAmplified;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public int getBod() {
		return bod;
	}
	public void setBod(int bod) {
		this.bod = bod;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public Date getTsDate() {
		return tsDate;
	}
	public void setTsDate(Date tsDate) {
		this.tsDate = tsDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getBrowserId() {
		return browserId;
	}
	public void setBrowserId(Integer browserId) {
		this.browserId = browserId;
	}
	public boolean isIdentified() {
		return identified;
	}
	public void setIdentified(boolean identified) {
		this.identified = identified;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	@Override
	public String toString() {
		return "NGNWebAct [eventName=" + eventName + ", userKey=" + userKey + ", customerKey=" + customerKey + ", uuid="
				+ uuid + ", siteId=" + siteId + ", browser=" + browser + ", sid=" + sid + ", visit=" + visit + ", pts="
				+ pts + ", sts=" + sts + ", tx=" + tx + ", ptx=" + ptx + ", url=" + url + ", purl=" + purl + ", npv="
				+ npv + ", title=" + title + ", automation=" + automation + ", automationId=" + automationId
				+ ", dpName=" + dpName + ", dpId=" + dpId + ", cg=" + cg + ", mid=" + mid + ", sourceId=" + sourceId
				+ ", payload=" + payload + ", stmSource=" + stmSource + ", cpci=" + cpci + ", campaignId=" + campaignId
				+ ", cpcm=" + cpcm + ", cpcs=" + cpcs + ", msgId=" + msgId + ", notificationId=" + notificationId
				+ ", trId=" + trId + ", conversion=" + conversion + ", revenuekey=" + revenuekey + ", userTimings="
				+ userTimings + ", utmSource=" + utmSource + ", utmMedium=" + utmMedium + ", utmCampaign=" + utmCampaign
				+ ", utmContent=" + utmContent + ", utmTerm=" + utmTerm + ", isAmplified=" + isAmplified + ", lat="
				+ lat + ", lng=" + lng + ", clientId=" + clientId + ", userId=" + userId + ", eventId=" + eventId
				+ ", userAgent=" + userAgent + ", bod=" + bod + ", ts=" + ts + ", tsDate=" + tsDate + ", ip=" + ip
				+ ", browserId=" + browserId + ", identified=" + identified + ", channelId=" + channelId
				+ ", eventType=" + eventType + "]";
	}
	
}
