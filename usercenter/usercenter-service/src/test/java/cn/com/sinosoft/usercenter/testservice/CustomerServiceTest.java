package cn.com.sinosoft.usercenter.testservice;

import static org.junit.Assert.*;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sinosoft.usercenter.model.GeCustomer;
import cn.com.sinosoft.usercenter.service.CustomerService;

public class CustomerServiceTest {
  
  CustomerService cs = null;
  Logger log = Logger.getLogger(this.getClass());
  
  @Before
  public void before(){
    try {
      @SuppressWarnings("resource")
      ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-service.xml"});
      cs = (CustomerService)context.getBean("customerServiceImpl");
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

  @Test
  public void testGetByName() {
    try {
      GeCustomer customer = cs.getOneCustomersByName("uuuutttt").get(0);
      log.info(customer.getCustomerno());
      assertTrue(customer.getCustomerno() != null);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
  
  @Test
  public void testAdd() {
    try {
      GeCustomer customer = new GeCustomer();
      String uuid = UUID.randomUUID().toString();
      log.info("主键:"+uuid);
      customer.setCustomerno(uuid);
      customer.setCustomername("uuuutttt");
      customer.setEmail("11");
      int i = cs.addOneCustomer(customer);
      log.info(i);
      assertTrue(1 == i);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
  
  @Test
  public void testUpdate() {
//    try {
      GeCustomer customer = cs.getOneCustomersByName("uuuutttt").get(0);
      customer.setCustomeraccount("8888");
      int i = cs.updateCustomer(customer);
      log.info(i);
      assertTrue(1 == i);
//    } catch (Exception e) {
//      log.error(e.getMessage(), e);
//    }
  }
  
  @Test
  public void testDelete() {
    try {
      GeCustomer customer = cs.getOneCustomersByName("uuuutttt").get(0);
      int i = cs.deleteOne(customer);
      log.info(i);
      assertTrue(1 == i);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

}
