# SpringCloud_Damo
- 数据库mysql,redis,springboot springCloud(G版)
- 集群搞起来，五大神兽搞起电脑竟然跑不动。8G内存不够用。
- 关掉虚拟机，关掉mysql 
[toc]
## Eureka
- 高可用，分区容错
- 与zookeeper之间不同
    - zookeeper不是高可用(而是数据一至性+分区容错)
- 集群3个eureka
- 自我保护机制
-  server.enable-self-preservation= false
- 高可用其它配置 TODO
## 服务提供
- 集群两个，假装从外调用
## Ribbon
## Feign
- interface调用
    - feignClient("xxx",fallback=impl)
- 服务调用降级 
    - 开启 hystrix
    - impl 需要被管理 @component
## Hystrix
- hystrix.stream
    - ribbon监控只能监控一个接口？ TODO
    - feign 可以监控所有接口
- turbine TODO
## Zuul
- 不玩了
## Gateway
> gateway 和 web 冲突
- 配置路由路径要主意：`- Path=/xx/**`时，Path第一个字母要大写
- 过滤规则是从第1个开始，不是从0开始。`stripPrefix=1`
- 自定义过滤器或者从代码处实现灵活的过滤器（不是application.yml）
    - 默认会取到电脑名作为根route
    - 因此需要在main方法上注解扫包
    