package cn.com.sinosoft.usercenter.web.security.constants;

/**
 * 操作常量
 * 
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月31日
 */
public final class OperationType {

  private OperationType() {
    throw new AssertionError();
  }

  /**
   * 添加
   */
  public static final String CREATE = "create";
  /**
   * 更新
   */
  public static final String UPDATE = "update";
  /**
   * 读取
   */
  public static final String READ = "read";
  /**
   * 删除
   */
  public static final String DELETE = "delete";

  /**
   * 所有
   */
  public static final String ALL = "*";
}
