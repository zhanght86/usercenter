package cn.com.sinosoft.usercenter.util;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MyLogTest {
  
  Logger log = Logger.getLogger(MyLogTest.class);
  
  @Test
  public void test1(){
    log.debug("调试");
    log.info("信息");
  }

}
