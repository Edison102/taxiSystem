# 拼车系统(spring+springmvc+mybatis)

## 业务描述
  此项目分为前台和后台。前台的用户可以查看所有的发车信息，选择车辆上车。还可以查看订单，并在订单结束后进行付款，并给车主进行打分。用户还可以申请成为车主，成为车主后用户可以发车，待行程结束后车主可以结束行程，此时会根据人数来计算每个乘客应付金额。后台管理员可以审核前台用户提交的车主申请，还可以根据用户对车主的打分情况取消用户的车主资格。

## 所用技术
### 前端
  前端页面显示采用jsp+bootstrap来实现。
  
### ssm框架
  使用ssm框架搭建基本业务骨架。
  
### aop
  使用aspectJ切面技术设置性能监测，记录所有的查询所用时间，用日志输出到控制台。
  
### spring 事务
  使用spring事务注解来使数据保持一致性，同时使用写锁解决上车人数冲突问题。

### Redis 缓存
  使用Redis配合spring缓存机制来对项目添加缓存功能，使得对发车信息的查询速度加快。

### 拦截器
  使用拦截器类来进行用户权限判断，对于登录、注册等界面的请求放行，其他的请求会判断用户是否登录，若未登录则跳转回登录页面。
  
### ajax 
  在注册页面使用ajax来提示用户输入数据的正确性。

### 全局异常处理
  设置全局异常处理类，捕获系统所有的异常，用统一的错误页面展示。
  
### 分页
  构建分页工具类，方便页面数据进行分页展示。
