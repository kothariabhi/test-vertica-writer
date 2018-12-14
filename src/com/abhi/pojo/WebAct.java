package com.abhi.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class WebAct {
	private int clientId;
	private int userId;
    private int activityId;
    private String userAgent;
    private int bod;
    private String ip;
    private Map<String,Object> typeAwarePayload ;
    private long ts;
    private Long tx;
    private Long ptx;
    private Long sessionId;
	private String webGuid;
	private String token;
	private String oldToken;
	private String siteId;
	private Integer browserId;
    private String trId;
	private Integer campaignId;
    private Integer channelId;
    private Date tsDate;
    private Integer pts;
    private Integer sts;
    private String url;
    private boolean identified;
    private String purl; //prev url
    private String eventType ; //w or a
    private String action ;
    private String notificationType;
    private int notificationId;
    private String title;
    private int sourceId;
    private int msgId;
    private int automationId;
    private String clickLink;
    private Integer clickLinkId;
    private String visit;
    private String type;
    private String dpName;
	private String dpId;
	private String clientKey;
	private String identity;
	private String uuid;
	private String cg;
	private List<Double> coordinates;
	
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
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Map<String, Object> getTypeAwarePayload() {
		return typeAwarePayload;
	}
	public void setTypeAwarePayload(Map<String, Object> typeAwarePayload) {
		this.typeAwarePayload = typeAwarePayload;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public Long getTx() {
		return tx;
	}
	public void setTx(Long tx) {
		this.tx = tx;
	}
	public Long getPtx() {
		return ptx;
	}
	public void setPtx(Long ptx) {
		this.ptx = ptx;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public String getWebGuid() {
		return webGuid;
	}
	public void setWebGuid(String webGuid) {
		this.webGuid = webGuid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOldToken() {
		return oldToken;
	}
	public void setOldToken(String oldToken) {
		this.oldToken = oldToken;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public Integer getBrowserId() {
		return browserId;
	}
	public void setBrowserId(Integer browserId) {
		this.browserId = browserId;
	}
	public String getTrId() {
		return trId;
	}
	public void setTrId(String trId) {
		this.trId = trId;
	}
	public Integer getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Date getTsDate() {
		return tsDate;
	}
	public void setTsDate(Date tsDate) {
		this.tsDate = tsDate;
	}
	public Integer getPts() {
		return pts;
	}
	public void setPts(Integer pts) {
		this.pts = pts;
	}
	public Integer getSts() {
		return sts;
	}
	public void setSts(Integer sts) {
		this.sts = sts;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isIdentified() {
		return identified;
	}
	public void setIdentified(boolean identified) {
		this.identified = identified;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getAutomationId() {
		return automationId;
	}
	public void setAutomationId(int automationId) {
		this.automationId = automationId;
	}
	public String getClickLink() {
		return clickLink;
	}
	public void setClickLink(String clickLink) {
		this.clickLink = clickLink;
	}
	public Integer getClickLinkId() {
		return clickLinkId;
	}
	public void setClickLinkId(Integer clickLinkId) {
		this.clickLinkId = clickLinkId;
	}
	public String getVisit() {
		return visit;
	}
	public void setVisit(String visit) {
		this.visit = visit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCg() {
		return cg;
	}
	public void setCg(String cg) {
		this.cg = cg;
	}
	public List<Double> getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public String toString() {
		return "WebAct [clientId=" + clientId + ", userId=" + userId + ", activityId=" + activityId + ", userAgent="
				+ userAgent + ", bod=" + bod + ", ip=" + ip + ", typeAwarePayload=" + typeAwarePayload + ", ts=" + ts
				+ ", tx=" + tx + ", ptx=" + ptx + ", sessionId=" + sessionId + ", webGuid=" + webGuid + ", token="
				+ token + ", oldToken=" + oldToken + ", siteId=" + siteId + ", browserId=" + browserId + ", trId="
				+ trId + ", campaignId=" + campaignId + ", channelId=" + channelId + ", tsDate=" + tsDate + ", pts="
				+ pts + ", sts=" + sts + ", url=" + url + ", identified=" + identified + ", purl=" + purl
				+ ", eventType=" + eventType + ", action=" + action + ", notificationType=" + notificationType
				+ ", notificationId=" + notificationId + ", title=" + title + ", sourceId=" + sourceId + ", msgId="
				+ msgId + ", automationId=" + automationId + ", clickLink=" + clickLink + ", clickLinkId=" + clickLinkId
				+ ", visit=" + visit + ", type=" + type + ", dpName=" + dpName + ", dpId=" + dpId + ", clientKey="
				+ clientKey + ", identity=" + identity + ", uuid=" + uuid + ", cg=" + cg + ", coordinates="
				+ coordinates + "]";
	}
	
	
}
