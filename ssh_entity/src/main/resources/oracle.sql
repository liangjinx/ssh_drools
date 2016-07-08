insert INTO orders VALUES (1,0,0,0,0,0,0,
                             to_date('2015-01-05 22:12:12','yyyy-mm-dd hh24:mi:ss'),'0001',0,20,0,1,
                           to_date('2016-10-25 22:12:12','yyyy-mm-dd hh24:mi:ss'));
insert INTO orders VALUES (2,1,1,1,1,1,1,
                             to_date('2015-07-05 22:12:12','yyyy-mm-dd hh24:mi:ss'),'0002',1,20,1,2,
                           to_date('2015-10-25 22:12:12','yyyy-mm-dd hh24:mi:ss'));
insert INTO orders VALUES (3,2,2,2,2,2,2,
                             to_date('2013-07-05 22:12:12','yyyy-mm-dd hh24:mi:ss'),'0003',2,20,2,3,
                           to_date('2014-10-25 22:12:12','yyyy-mm-dd hh24:mi:ss'));


Insert into SCOTT.FLOW (ID,childFlow,flowName,flowType,parentFlow,STATUS) values (526,'拣货出库','发运处理',2,'订单处理',null);
Insert into SCOTT.FLOW (ID,childFlow,flowName,flowType,parentFlow,STATUS) values (527,'物流配送','拣货出库',2,'发运处理',null);
Insert into SCOTT.FLOW (ID,childFlow,flowName,flowType,parentFlow,STATUS) values (529,null,'签收入库',2,'物流配送',null);
Insert into SCOTT.FLOW (ID,childFlow,flowName,flowType,parentFlow,STATUS) values (1251,'签收入库','物流配送',2,'拣货出库',0);

