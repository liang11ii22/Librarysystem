# Librarysystem

每次进入reservation 时 如果查询到用户存在 就直接调到reservaitoninfo.jsp显示出来
没有的话就跳到reservation jsp 通过时期时间查询 显示在table中 点击预订就更新数据库
后台的话就是addreservation 直接通过form 增删查改

创建数据库时加个version    

period 分成早中晚 time 就是日期 

reservation 数据库
id lid uid seat state period    time         version
1   1      1     0      m     20151017
2   1      1     1      a     20151017 

library 我加了 lat lng

librarydetails jsp 我把地址坐标都放在那了 图书馆坐标还是写死的
