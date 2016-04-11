package cn.com.sinosoft.usercenter.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

public class JsonTest {
  
  Logger log = Logger.getLogger(this.getClass());
  
  @Test
  public void testArr(){
    String[][] arr = {
        {"key", "value"},//正常情况 = "key":"value"
        {"key1", "null"},//value为null字符串  =   "key1":"null"
        {"key2", null},//value为null = "key2":"null"
        {"key3"},//只有一列 = "key3" : "null"
        {"key4","4","5"},//有三列 = "key4" : "4"
        {"key4","6"},//重复的key值会被替换 = "key4" : "6"
        {"null", "1"},//key为null 字符串 = "null" : "1"
        {null, "2"},//key为null  不转换
        {"","3"},//key为空串  不转换
        {},//数组为空  不转换
    };
    String json = JsonByGsonUtils.arrToJson(arr);
    log.info(json);
    assertTrue("{\"key\":\"value\",\"key1\":\"null\",\"key2\":\"null\",\"key3\":\"null\",\"key4\":\"6\",\"null\":\"1\"}".equals(json));
  }
  
  @Test
  public void testMao(){
    Map<String, String> map = new HashMap<String, String>();
    map.put("key", "value");
    map.put("key1", "null");
    map.put("key2", null);//值为null则不会被转为json
    map.put("null", "1");
    map.put(null, "2");//同字符串"null"，不推荐
    String json = JsonByGsonUtils.mapToJson(map);
    log.info(json);
    //assertTrue("{\"key1\":\"null\",\"null\":\"2\",\"null\":\"1\",\"key\":\"value\"}".equals(json));
  }
}
