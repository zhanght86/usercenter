package cn.com.sinosoft.usercenter.util.messages;

/**
 * 消息枚举基础接口
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月29日
 */
public interface BaseMessageEnum {
  
  /**
   * 消息代码
   * @return
   */
  public String getMessageCode();
  
  /**
   * 详细日志信息
   * @return
   */
  public String getLogInfo();
  
  /**
   * 展示给客户的话术
   * @return
   */
  public String getMessage();

}
