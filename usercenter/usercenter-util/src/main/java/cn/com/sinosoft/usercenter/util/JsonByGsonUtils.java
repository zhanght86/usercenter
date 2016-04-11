/**
 * File Name:usercenter-util/cn.com.sinosoft.usercenter.util.JsonByGsonUtils.java<br>
 * @Description: <br>
 * @Author:renlc<br>
 * @e-mail:rlc0204@163.com
 * @version:v1.0<br>
 * @CreateDate:2016年3月29日<br>
 */
package cn.com.sinosoft.usercenter.util;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * 使用Google-Gson实现的Json转换工具类
 * 
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月29日
 */
public final class JsonByGsonUtils {

  private JsonByGsonUtils() {
    throw new AssertionError();
  }

  /**
   * 将形如{{Obj,Obj},{Obj,Obj},{Obj,Obj}}二维数组转换为json，第一列为key，第二列为value <br>
   * key不能为null，或者空串，value可以为任意值，也可以为空
   * 
   * @param arr
   * @return
   */
  public static String arrToJson(Object[][] arr) {
    Gson gson = new GsonBuilder().create();
    JsonObject jo = new JsonObject();
    for (Object[] objects : arr) {
      if (objects.length < 1) {
        // 空行，不转换
        continue;
      }
      Object key = objects[0];
      if (key == null || "".equals(String.valueOf(key))) {
        // 第一列为null或者空串，不转换
        continue;
      }
      Object value = null;
      if (objects.length > 1) {
        // 取第二列的值为value，否则为null
        value = objects[1];
      }
      jo.addProperty(String.valueOf(key), String.valueOf(value));
    }
    return gson.toJson(jo);
  }

  /**
   * 将map转换为json串
   * 
   * @param map
   *          Map<String,String>
   * @return
   */
  public static String mapToJson(Map<String, String> map) {
    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    return gson.toJson(map);
  }

  /**
   * 将map转换为json串
   * 
   * @param map
   *          Map<String,Object>
   * @return
   */
  public static String mapToJsonObject(Map<String, Object> map) {
    Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    return gson.toJson(map);
  }
}
