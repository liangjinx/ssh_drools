# ssh_drools
----------------  志蓝做的ssh+drools框架
##项目分三层
* entity
* serves
* web

###  entitys层
    使用hibernate的jpa做数据处理，在这层使用spring框架管理对象，引入配置文件，使用日志d等，第一次提交没有做drools和jpa结合使用。
### servers层
    使用entitys层的数据源，把数据查询出来，放入drools中做规则判断。然后通过drools的查询返回给web层。
### web层
    是spring的mvc，使用struts做业务请求分发，返回数据到前端，目前有个问题是action和前端交互的时候，需要写的代码太多。
    
#### entity
> zhinan.liang
>> daos
* [publicDao](http://blog.csdn.net/guodongxiaren "do的公共方法")

>>> impl
* [publicDaoImpl](http://blog.csdn.net/guodongxiaren "dao的公共方法的实现")
* [MyHibernateDaoSupport](http://blog.csdn.net/guodongxiaren "dao公共方法实现所需要的，为了实现注解")

>> entitys

> resources
* [application-context.xml](http://blog.csdn.net/guodongxiaren "spring的主要配置文件，导入其他配置文件")
* [applicationContext-druid-db.xml](http://blog.csdn.net/guodongxiaren "数据库，事务处理的配置文件")
* [cp30.properties](http://blog.csdn.net/guodongxiaren "数据库配置信息")
* [log4j.properties](http://blog.csdn.net/guodongxiaren "日志配置文件，")
* [log4j2.xml](http://blog.csdn.net/guodongxiaren "日志配置文件，暂时不可以使用")
* [oracle.sql](http://blog.csdn.net/guodongxiaren "数据库插入语句，添加数据")

#### server
> zhinan.liang
>> interceptorS
* [Myinterceptor](http://blog.csdn.net/guodongxiaren "实现自定义执行方法的拦截器,记录方法执行的时间")

>> model
* [ MyKnowledgeBase](http://blog.csdn.net/guodongxiaren "drools实现注解需要的")

>> utils
* [DateUtil](http://blog.csdn.net/guodongxiaren "日期操作的实现类 ")

>> servers
* [publicService](http://blog.csdn.net/guodongxiaren "service 层的公共方法集 ")
    
>>> impl
* [PublicServiceImpl](http://blog.csdn.net/guodongxiaren "drools 操作后的出口点数据")
  
> resources
* [application-context.xml](http://blog.csdn.net/guodongxiaren "spring的主要配置文件,这里主要是导入drools的spring配置文件")
* [drools_spring.xml](http://blog.csdn.net/guodongxiaren "drools 的spring配置文件，目前没有使用")
* [kie_spring.xml](http://blog.csdn.net/guodongxiaren "kie方式配置drools 的spring配置文件")

>> [META-INFsss](http://blog.csdn.net/guodongxiaren "drools不和spring组合使用的时候测试使用")

>> rules,test,tt  都是规则文件的测试使用


#### web
> zhinan.liang
>> action
* [FlowAction](http://blog.csdn.net/guodongxiaren "主要做测试的，与前端界面交互")
* [PublicAction](http://blog.csdn.net/guodongxiaren "用于struts的传参，接收参数，")

>>  model
* [GuizeModel](http://blog.csdn.net/guodongxiaren "测试的时候使用的，用于传递对象")

> resources
* [struts.xml](http://blog.csdn.net/guodongxiaren "struts的主要配置文件，返回值，请求格式")

> webapp
>> [extendcss](http://blog.csdn.net/guodongxiaren "前端框架使用的cdd")
>> [extendjs](http://blog.csdn.net/guodongxiaren "前端框架使用的js")
>> [html](http://blog.csdn.net/guodongxiaren "测试使用，d原本打算使用html做前端")
>> [jsp](http://blog.csdn.net/guodongxiaren "所有的业务jsp界面，")
>> [web-inf](http://blog.csdn.net/guodongxiaren "web.xml")

