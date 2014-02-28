package com.flynn.mycms.common.velocity;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.JSONUtil;


import com.flynn.mycms.common.base.Result;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.util.ValueStack;


public class MVelocityLayoutResult extends VelocityLayoutResult{
	private static final long serialVersionUID = -1205411301627706254L;

	@Override
	public void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//如果请求参数包含_format_=json参数，则表示是ajax调用，将result以json的方式返回
		if("json".equalsIgnoreCase(request.getParameter("_format_"))){
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			//从valuestack中获取result值
			ValueStack stack = ActionContext.getContext().getValueStack();
			Result result = (Result)stack.findValue("result");
			String resultJson = "{}";
			//如果result不为空，则转化为json，负责返回空json串
			if(result!=null) {
				resultJson = JSONUtil.serialize(result.getMap());
			}
			writer.write(resultJson);
			writer.flush();
			return;
		}
		
		super.doExecute(finalLocation, invocation);
	}
}
