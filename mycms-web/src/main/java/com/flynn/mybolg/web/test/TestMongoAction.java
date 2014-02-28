package com.flynn.mybolg.web.test;

import java.util.ArrayList;
import java.util.List;

import com.flynn.myblog.service.TestMongoService;
import com.flynn.mycms.common.base.Result;
import com.flynn.mycms.domain.TestMongo;
import com.opensymphony.xwork2.ActionSupport;

public class TestMongoAction extends ActionSupport{

	private TestMongoService testMongoService;
	private List<TestMongo> testMongoList = new ArrayList<TestMongo>();
	private TestMongo testMongo;
	private Result result = new Result();
	

	public String testSelect(){	
		testMongoList = testMongoService.getAllTestMongoByPage();
		result.setSuccess(true);
		result.addDefaultModel("testMongoList", testMongoList);
		return "testSelect";
	}
	
	public String testInsert(){
		
		testMongoService.insertTestMongo(testMongo);
		return "testInsert";
	}

	public String testDel(){
		testMongoService.deleteTestMongoByUuid();
		return "testDel";
	}
	
	
	
	public TestMongo getTestMongo() {
		return testMongo;
	}




	public Result getResult() {
		return result;
	}


	public List<TestMongo> getTestMongoList() {
		return testMongoList;
	}



	public TestMongoService getTestMongoService() {
		return testMongoService;
	}

	public void setTestMongoService(TestMongoService testMongoService) {
		this.testMongoService = testMongoService;
	}
	
}
