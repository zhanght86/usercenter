package cn.com.sinosoft.usercenter.service;

import java.util.List;

import cn.com.sinosoft.usercenter.model.GeCustomer;

public interface CustomerService {

  /**
   * 通过名称获取用户
   * 
   * @param name
   * @return
   */
  public List<GeCustomer> getOneCustomersByName(String name);

  public int updateCustomer(GeCustomer record) throws RuntimeException;

  public int addOneCustomer(GeCustomer record);

  public int deleteOne(GeCustomer record);

  public GeCustomer authentication(GeCustomer record);

}
