package com.szgmwill.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {
	
	private String testJsonString = "";
	
	private String inputFileName = "C://Users//willzhang//Desktop//json1.txt";
	
	private long startTime = System.currentTimeMillis();
	
	@Before
	public void before() {
		//初始化测试串
		testJsonString = readFileByLines(inputFileName);
		startTime = System.currentTimeMillis();
	}
	
	@After
	public void after() {
		System.out.println("=================costTime:["+(System.currentTimeMillis() - startTime)+"]");
	}
	
//	@Test
	public void testJackson() {
		// write your code here
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        try
        {
            // 尝试从JSON中读取对象
            @SuppressWarnings("unchecked")
			Map<String, String> mapObj = mapper.readValue(new File(inputFileName), HashMap.class);
            System.out.println("json to Map:" + mapObj);
    		System.out.println("Map to Json:" + mapper.writeValueAsString(mapObj));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	
	@Test
	public void testFastjson() {
		Map<String, String> mapObj = FastJsonUtil.json2Bean(testJsonString, HashMap.class);
		System.out.println("json to Map:" + mapObj);
		System.out.println("Map to Json:" + FastJsonUtil.bean2Json(mapObj));
	}
	
	
//	@Test
	public void testGson() {
		Map<String, String> mapObj = GsonUtil.json2Bean(testJsonString, HashMap.class);
		System.out.println("json to Map:" + mapObj);
		System.out.println("Map to Json:" + GsonUtil.bean2Json(mapObj));
	}
	
	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer retString = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            
            int line = 1;
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                line++;
                
                retString.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
        return retString.toString();
    }
}
