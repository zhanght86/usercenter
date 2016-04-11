package cn.com.sinosoft.usercenter.util.messages;

/**
 * 用户信息枚举类
 * 
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月29日
 */
public enum UserMessage implements BaseMessageEnum {
  /** 用户未登录 */
  ERROR_NOT_LOGIN("U0000", "用户未登录"),
  /** 错误的用户名 */
  ERROR_NAME("U0001", "错误的用户名"),
  /** 错误的密码 */
  ERROR_PASSWORD("U0002", "错误的密码"),
  /** 认证过期 */
  ERROR_TOKEN_OUTDATE("U1001", "认证过期"),
  // AJAX
  /** ajax请求 用户未登录 */
  ERROR_AJAX_NOT_LOGIN("U0000", "用户未登录"),
  /** ajax请求 错误的用户名 */
  ERROR_AJAX_NAME("U0001", "错误的用户名"),
  /** ajax请求 错误的密码 */
  ERROR_AJAX_PASSWORD("U0002", "错误的密码"),
  /** ajax请求 认证过期 */
  ERROR_AJAX_TOKEN_OUTDATE("U1001", "认证过期"), ;

  /**
   * 消息代码
   */
  private String messageCode;
  /*
   * ps:（暂时未定，可以用来与其他系统进行消息交互式传递简单错误信息用，或者用于快速定位信息）
   * 代码规则一般固定位数的数字，比如100001,1开头代表用户相关，后面表示具体的错误代码。 或者是U0001，U代表user，用户类信息
   */

  /**
   * 消息日志信息，用于输出到日志，用户排除错误或定位信息
   */
  private String logInfo;
  /**
   * 用户话术，展示给用户的信息
   */
  private String message;

  private UserMessage(String messageCode, String logInfo) {
    this.messageCode = messageCode;
    this.logInfo = logInfo;
    this.message = logInfo;
  }

  private UserMessage(String messageCode, String logInfo, String message) {
    this.messageCode = messageCode;
    this.logInfo = logInfo;
    this.message = message;
  }

  @Override
  public String getMessageCode() {
    return this.messageCode;
  }

  @Override
  public String getLogInfo() {
    return this.logInfo;
  }

  @Override
  public String getMessage() {
    return this.message;
  }

}
