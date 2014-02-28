package com.flynn.mycms.domain;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * �㲥��Ϣʵ����
 */
@Entity(value="bcmsg", noClassnameStored=true)
public class BCMsg implements Serializable {
	private static final long serialVersionUID = -5509357385789158749L;
	@Id 
	private String id;
	//private ObjectId bcmsg_id;//Ψһ��ʶ
	private String title;//��Ϣ����
	private String content;//��Ϣ����
	private String wareid;//��Ʒid
	private String activityId;//�id
	private String url;//�url
	private String flag;//�Ƿ���Ч 0��Ч 1��Ч
	private Date created = new Date();//����ʱ��
	private Date modified = new Date();//�޸�ʱ��

	
    
	/*public ObjectId getBcmsg_id() {
		return bcmsg_id;
	}

	public void setBcmsg_id(ObjectId bcmsg_id) {
		this.bcmsg_id = bcmsg_id;
	}*/

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWareid() {
		return wareid;
	}

	public void setWareid(String wareid) {
		this.wareid = wareid;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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
