package com.devfun.settingweb_boot.test;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.service.StatisticService;
import com.fasterxml.jackson.databind.ObjectMapper;
 
 
 
@Controller
public class settingTest {
    
 
    @Autowired
    private StatisticService service;
    
    @ResponseBody 
    @RequestMapping("/sqlyearStatistic")
    public Map<String, Object> sqltest(String year) throws Exception{ 
        return service.yearloginNum(year);
    }
    @ResponseBody 
    @RequestMapping("/sqlmonthStatistic")
    public Map<String, Object> sqlmonthtest(String month) throws Exception{
    	return service.monthloginNum(month);
    }
    @ResponseBody 
    @RequestMapping("/sqldayStatistic")
    public Map<String, Object> sqldaytest(String day) throws Exception{
    	return service.dayloginNum(day);
    }
    @ResponseBody 
    @RequestMapping("/sqlavgStatistic")
    public Map<String, Object> sqlavgtest(String year, String month, String day) throws Exception{
    	return service.avgloginNum(year, month, day);
    }
    @ResponseBody 
    @RequestMapping("/sqlorganmonthStatistic")
    public Map<String, Object> sqlorganmonthtest(String organ, String month) throws Exception{
    	return service.organmonthloginNum(organ, month);
    }
    
    @ResponseBody 
    @RequestMapping("/sqlunholidayStatistic")
    public Map<String, Object> sqlunholidaytest(String year, String month) throws Exception{
    	return service.unholidayloginNum(year,month);
    }
    
    
    
    @ResponseBody
    @RequestMapping("/api")
    public Map<String, Object> callApi() throws Exception{
    	StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=%2F0SnlHeNzahA4qk3TvRa2ghBhFuIJ8SoPRQnqaWNdxVBkRmtEzUS5hZnY8W9EInCL9Q9LTXOmOHf7zrno%2FeVjA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode("2022", "UTF-8")); /*연*/
        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode("01", "UTF-8")); /*월*/
        urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json","UTF-8"));
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return string2Map(sb.toString());
       
    }
    
    public static Map<String, Object> string2Map(String json) {
    	ObjectMapper mapper = new ObjectMapper();
    	Map<String, Object> map = null;
    	try {
    		map = mapper.readValue(json, Map.class);
    		System.out.println(map);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
		return map;
	}
	@RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}