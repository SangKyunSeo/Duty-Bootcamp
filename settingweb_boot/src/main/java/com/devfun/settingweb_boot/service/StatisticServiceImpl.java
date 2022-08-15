package com.devfun.settingweb_boot.service;
 
 
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.devfun.settingweb_boot.dao.StatisticMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> yearloginNum (String year) {
        // TODO Auto-generated method stub
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }

	@Override
	public HashMap<String, Object> monthloginNum(String month) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			retVal = uMapper.selectMonthLogin(month);
			retVal.put("month",month);
			retVal.put("is_success", true);
			
		}catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("month", month);
			retVal.put("is_success", false);
		}
		return retVal;
	}

	@Override
	public HashMap<String, Object> dayloginNum(String day) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = uMapper.selectDayLogin(day);
			retVal.put("day",day);
			retVal.put("is_success",true);
			
		}catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("day",day);
			retVal.put("is_success", false);
		}
		return retVal;
	}

	@Override
	public HashMap<String, Object> avgloginNum(String year, String month, String day) {
		
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = uMapper.selectAvgLogin(year, month, day);
			retVal.put("year",year);
			retVal.put("month",month);
			retVal.put("day",day);
			retVal.put("is_success",true);
			
		}catch(Exception e){
			retVal.put("totCnt", -999);
			retVal.put("year",year);
			retVal.put("month",month);
			retVal.put("day",day);
			retVal.put("is_success",false);
		}
		return retVal;
	}

	@Override
	public HashMap<String, Object> organmonthloginNum(String organ, String month) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = uMapper.selectOrganMonthLogin(organ, month);
			retVal.put("hr_organ",organ);
			retVal.put("month",month);
			retVal.put("is_success",true);
		}catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("hr_organ",organ);
			retVal.put("month",month);
			retVal.put("is_success",false);
		}
		return retVal;
	}

	@Override
	public HashMap<String, Object> unholidayloginNum(String year, String month) {
		
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = uMapper.selectUnHolidayLogin(year,month);
			retVal.put("year",year);
			retVal.put("month",month);
			retVal.put("is_success",true);
		}catch(Exception e) {
			retVal.put("totCnt",-999);
			retVal.put("year",year);
			retVal.put("month",month);
			retVal.put("is_success",false);
		}
		return retVal;
	}
 
	
}