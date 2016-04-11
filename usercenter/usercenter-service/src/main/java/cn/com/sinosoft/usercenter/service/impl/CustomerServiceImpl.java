package cn.com.sinosoft.usercenter.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.sinosoft.usercenter.dao.GeCustomerMapper;
import cn.com.sinosoft.usercenter.model.GeCustomer;
import cn.com.sinosoft.usercenter.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Resource
  GeCustomerMapper gm;

  @Override
  public List<GeCustomer> getOneCustomersByName(String name) {
    GeCustomer record = new GeCustomer();
    record.setCustomername(name);
    return gm.selectBySelective(record);
  }

  // gm.updateByPrimaryKeySelective(record);

  @Override
  public int updateCustomer(GeCustomer record) throws RuntimeException {
    gm.updateByPrimaryKeySelective(record);
    throw new RuntimeException();
  }

  @Override
  public int addOneCustomer(GeCustomer record) {
    gm.insertSelective(record);
    System.out.println(record.getCustomerno());
    List<GeCustomer> tt = getOneCustomersByName(record.getCustomername());
    System.out.println(tt.size());
    System.out.println(tt.get(0).getCustomerno());
    return 1;
  }

  @Override
  public int deleteOne(GeCustomer record) {
    return gm.deleteByPrimaryKey(record.getCustomerno());
  }

  @Override
  public GeCustomer authentication(GeCustomer record) {
    List<GeCustomer> lists = gm.selectBySelective(record);
    if (lists.size() > 0) {
      return lists.get(0);
    }
    return null;
  }

}
