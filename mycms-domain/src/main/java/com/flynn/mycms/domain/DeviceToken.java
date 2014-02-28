package com.flynn.mycms.domain;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.google.code.morphia.utils.IndexDirection;
import java.util.Date;

@Entity(value="devicetoken", noClassnameStored=true)
public class DeviceToken {
    @Id
    String id;
    private String platform;//平台号，apple,wp,
    private String appname;//应用名称

    
    @Indexed(value = IndexDirection.ASC,unique = true,dropDups=true,name="device_token")
    private String devicetoken;//设备token,发送消息的标识
    private String pin;//登录pin
    private String uuid;//设备编号
    private String flag="1";//有效状态
    private String nodeId;
    private Date  created = new Date(); //创建时间
    private Date  modified = new Date();// 修改时间

    private String clientVersion;//客户端版本

    
    
    public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getDevicetoken() {
        return devicetoken;
    }

    public void setDevicetoken(String devicetoken) {
        this.devicetoken = devicetoken;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
    public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}

