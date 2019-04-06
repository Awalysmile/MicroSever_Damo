# SpringCloud_Damo
## Eureka
- 自我保护机制
-  server.enable-self-preservation= false
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
