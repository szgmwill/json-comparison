package com.szgmwill.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJson2Bean {
	private String jsonStr;
	
	private long startTime = 0;
	
	@Before
	public void init() {
		jsonStr = "{\"name\":\"邵同学\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":[{\"name\":\"小明\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"Tony\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null},{\"name\":\"陈小二\",\"fullName\":{\"firstName\":\"xxx_first\",\"middleName\":\"xxx_middle\",\"lastName\":\"xxx_last\"},\"age\":24,\"birthday\":null,\"hobbies\":[\"篮球\",\"游泳\",\"coding\"],\"clothes\":{\"shoes\":\"安踏\",\"trousers\":\"adidas\",\"coat\":\"Nike\"},\"friends\":null}]}";
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void printTime() {
		System.out.println("================costTime["+(System.currentTimeMillis() - startTime)+"]");
	}
	
	// @Test
	public void testGsonjson2Bean() throws Exception {
		Person pp = GsonUtil.json2Bean(jsonStr, Person.class);
		System.out.println(pp);

		for (int i = 0; i < 1000000; i++) {
			GsonUtil.json2Bean(jsonStr, Person.class);
		}
	}

	// @Test
	public void testJacksonJson2Bean() throws Exception {
		Person pp = JacksonUtil.json2Bean(jsonStr, Person.class);
		System.out.println(pp);

		for (int i = 0; i < 1000000; i++) {
			JacksonUtil.json2Bean(jsonStr, Person.class);
		}
	}

	@Test
	public void testFastJsonJson2Bean() throws Exception {
		Person pp = FastJsonUtil.json2Bean(jsonStr, Person.class);
		System.out.println(pp);

		for (int i = 0; i < 1000000; i++) {
			FastJsonUtil.json2Bean(jsonStr, Person.class);
		}
	}
}
