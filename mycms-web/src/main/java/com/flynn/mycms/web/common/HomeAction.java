package com.flynn.mycms.web.common;

import com.flynn.mycms.web.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class HomeAction extends BaseAction{
	
	public String execute() {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		return SUCCESS;
	}
	
    public String frame() throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        ActionContext context = ActionContext.getContext();
        ValueStack stack = context.getValueStack();
//        PcpLoginContext loginContext = (PcpLoginContext) context.get(LoginContext.HTTP_LOGIN_CONTEXT);
//        if(loginContext!=null && loginContext.isLogin()){
//            stack.set("loginContext", loginContext);
//        }
        return SUCCESS;
    }
    
    public String welcome() {
    	return SUCCESS;
    }
}
