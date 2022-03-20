
# myseckill
[toc]

## 基本功能
### 用户
1. - [x] 用户登录保存信息到cooke, redis并设置失效时长2h
2. - [x] 访问请求验证登录优先从redis获取
### 订单
1. - [ ] 消费redis生成订单数据
### 商品
## 特性
1. - [ ] redis实现热点数据读写
2. - [ ] rabbitmq实现流量削峰
3. - [ ] 页面缓存, 对象缓存
4. - [ ] 解决高并发下的超卖问题
## 其它
1. - [ ] rabbitmq的exchage, queue, routeKey等测试
2. - [ ] 测试高并发
