package com.flynn.mycms.web.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private final static Log log = LogFactory.getLog(BaseAction.class);
	
    protected HttpServletResponse response;
    protected HttpServletRequest request;
	
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
    
    /*
     * 获取真实的IP地址
     *
     */

	public String getRemoteIP() {
		String ip = request.getRemoteAddr();
		if (request.getHeader("x-forwarded-for") != null
				&& !"unknown".equalsIgnoreCase(request
						.getHeader("x-forwarded-for"))) {
			ip = ip + "," + request.getHeader("x-forwarded-for");
		}
		return ip;
	}
    
	
    
}
