package cn.com.sinosoft.usercenter.testdao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sinosoft.usercenter.dao.GeCustomerMapper;
import cn.com.sinosoft.usercenter.model.GeCustomer;

public class GeCustomerDaoTest {
  
  private SqlSession session = null;
  GeCustomerMapper gm = null;
  Logger log = Logger.getLogger(this.getClass());
  
  @Before
  public void before(){
    try {
      @SuppressWarnings("resource")
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
      SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)context.getBean("sqlSessionFactory");
      session = sqlSessionFactory.openSession();
      gm = session.getMapper(GeCustomerMapper.class);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
  
  @After
  public void after(){
    if(session != null){
      session.commit();
      session.close();
    }
  }

  /**
   * 添加数据
   */
  @Test
  public void testInsert() {
    GeCustomer customer = new GeCustomer();
    String uuid = UUID.randomUUID().toString();
    log.info("主键:" + uuid);
    customer.setCustomerno(uuid);
    customer.setCustomername("uuuutttt");
    try {
      int i = gm.insertSelective(customer);
      log.info(i);
      assertTrue(i == 1);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

  /**
   * 查询数据
   */
  @Test
  public void testSelectOne() {
    try {
      GeCustomer customer = gm.selectByPrimaryKey("8a80c3035114f57f0151152093230010");
      log.info(customer.getCustomeraccount());
      assertTrue("测三".equals(customer.getCustomername()));
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

  /**
   * 修改数据
   */
  @Test
  public void testUpdate() {
    try {
      List<GeCustomer> customers = gm.selectByCustomerName("uuuutttt");
      if(customers != null){
        GeCustomer customer = customers.get(0);
        customer.setEmail("11");
        int i = gm.updateByPrimaryKeySelective(customer);
        log.info(i);
        assertTrue(i == 1);
        GeCustomer customer2 = gm.selectBySelective(customer).get(0);
        log.info(customer2.getCustomerno());
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

  @Test
  public void deleteByID() {
    try {
      List<GeCustomer> customers = gm.selectByCustomerName("uuuutttt");
      if(customers != null){
        GeCustomer customer = customers.get(0);
        int i = gm.deleteByPrimaryKey(customer.getCustomerno());
        log.info(i);
        assertTrue(i == 1);
      }
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

}
