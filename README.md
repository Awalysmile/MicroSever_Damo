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
- 配置了route fallback 则调用服务的降级就不会触发
    - 业务需求需要提供一个默认即降级提供。

## 吃饱没事做加了个dubbo
- 如何调用dubbo服务？
    - 方案一 ribbon 通过restTemplatey请求 dubbo 消费者api而该api去消费提供者，得到数据返回
        - 优点： 只需要把消费者注册到eureka上,方便简单
        - 缺点：
            1. 非springboot项目不好整改。
            2. 通过消费者间接调用结果，性能损耗，操作链条过长，高可用降低。
        - 注意事项
            1. ribbon调用时要在ribbon的服务名去映射调用。
            2. dubbo消费者的虽然注册到eureka上，但其映射不可用。
    - 方案二：（待 todo）spring-cloud-zookeeper 即去zookeeper上发现服务。
        - 
        