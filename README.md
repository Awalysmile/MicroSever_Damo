# SpringCloud_Damo
- 数据库mysql,redis,springboot springCloud(G版)
- 集群搞起来，五大神兽搞起电脑竟然跑不动。8G内存不够用。
- 关掉虚拟机，关掉mysql 
## Eureka
- 集群3个eureka
- 自我保护机制
-  server.enable-self-preservation= false
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
## Gateway
- 配置路由路径要主意：`- Path=/xx/**`时，Path第一个字母要大写
- 过滤规则是从第1个开始，不是从0开始。`stripPrefix=1`
