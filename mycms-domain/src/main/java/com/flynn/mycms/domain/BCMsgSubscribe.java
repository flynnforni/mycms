package com.flynn.mycms.domain;

import java.io.Serializable;
import java.util.Date;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="bcMsgSubscribe", noClassnameStored=true)
public class BCMsgSubscribe implements Serializable {
	private static final long serialVersionUID = 4577783519134634636L;
	@Id
	private String id;//id
	private String type;//��Ϣ����
	private String devicetoken;//�豸���
	private String uuid;
	private String flag;//�Ƿ��� 1���� 0 δ����
	private String startTime="8";//��ʼʱ��  ����޸� ��Ҫ�޸� ClientConstance.START_TIME;
	private String endTime="24";//����ʱ��   ����޸� ��Ҫ�޸�ClientConstance.END_TIME;
	private Date created=new Date();
	private Date modified=new Date();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDevicetoken() {
		return devicetoken;
	}
	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}

