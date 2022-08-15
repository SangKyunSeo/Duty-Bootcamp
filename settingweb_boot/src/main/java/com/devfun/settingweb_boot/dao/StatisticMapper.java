package com.devfun.settingweb_boot.dao;
import java.util.HashMap;
 
import com.devfun.settingweb_boot.dto.StatisticDto;
 
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
    public HashMap<String, Object> selectMonthLogin(String month);
    public HashMap<String, Object> selectDayLogin(String day);
    public HashMap<String, Object> selectAvgLogin(String year, String month, String day);
    public HashMap<String, Object> selectOrganMonthLogin(String organ, String month);
    public HashMap<String, Object> selectUnHolidayLogin(String year,String month);

}