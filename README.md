# ssh_drools
##志蓝做的ssh+drools框架

-----项目分三层，
  .serves，
  .entitys，
  .web。
 ### entitys层使用hibernate的jpa做数据处理，在这层使用spring框架管理对象，引入配置文件，使用日志d等，第一次提交没有做drools和jpa结合使用。
 ### servers层 使用entitys层的数据源，把数据查询出来，放入drools中做规则判断。然后通过drools的查询返回给web层。
 ### web层是spring的mvc，使用struts做业务请求分发，返回数据到前端，，目前有个问题是action和前端交互的时候，需要写的代码太多。
