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
    [publicDao](http://blog.csdn.net/guodongxiaren "do的公共方法")
>>> impl
* [publicDaoImpl](http://blog.csdn.net/guodongxiaren "dao的公共方法的实现")
* [MyHibernateDaoSupport](http://blog.csdn.net/guodongxiaren "dao公共方法实现所需要的，为了实现注解"

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
>>> [Myinterceptor](http://blog.csdn.net/guodongxiaren "实现自定义执行方法的拦截器")

>> [model](http://blog.csdn.net/guodongxiaren "自定义与drools规则文件交互的对象")
>>>   MyKnowledgeBase drools实现注解需要的

>>   utils
>>>    DateUtil   日期操作的实现类

>> servers
 publicService   service 层的公共方法集

