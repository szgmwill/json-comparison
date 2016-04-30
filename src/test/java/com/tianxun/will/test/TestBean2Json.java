package com.tianxun.will.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBean2Json {
	private Person p;
	
	private long startTime = 0;
	
	private Person createAPerson(String name, List<Person> friends) {
		Person newPerson = new Person();
		newPerson.setName(name);
		newPerson.setFullName(new FullName("xxx_first", "xxx_middle",
				"xxx_last"));
		newPerson.setAge(24);
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("篮球");
		hobbies.add("游泳");
		hobbies.add("coding");
		newPerson.setHobbies(hobbies);
		Map<String, String> clothes = new HashMap<String, String>();
		clothes.put("coat", "Nike");
		clothes.put("trousers", "adidas");
		clothes.put("shoes", "安踏");
		newPerson.setClothes(clothes);
		newPerson.setFriends(friends);
		return newPerson;
	}

	@Before
	public void init() {
		List<Person> friends = new ArrayList<Person>();
		friends.add(createAPerson("小明", null));
		friends.add(createAPerson("Tony", null));
		friends.add(createAPerson("陈小二", null));
		p = createAPerson("邵同学", friends);
		
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void printTime() {
		System.out.println("================costTime["+(System.currentTimeMillis() - startTime)+"]");
	}
	
	// @Test
	public void testGsonBean2Json() {
		System.out.println(GsonUtil.bean2Json(p));

		for (int i = 0; i < 1000000; i++) {
			GsonUtil.bean2Json(p);
		}
	}

	@Test
	public void testJacksonBean2Json() throws Exception {
		System.out.println(JacksonUtil.bean2Json(p));

		for (int i = 0; i < 1000000; i++) {
			JacksonUtil.bean2Json(p);
		}
	}

//	@Test
	public void testFastJsonBean2Json() throws Exception {
		System.out.println(FastJsonUtil.bean2Json(p));

		for (int i = 0; i < 1000000; i++) {
			FastJsonUtil.bean2Json(p);
		}
	}
}
