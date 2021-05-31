# Base Project 
build of dubbo

- base

    基础模块：包括常量（字典键等）和接口统一返回对象及响应编码

- service-interface

    规范dubbo rpc service接口及入出参等dto

    配置valid包对DO进行分组校验
  
- dic_service

    字典服务（RPC）及字典领域下数据库模型
  
- api_center

    接口中心，以RestFul接口形式对外暴露
    
    集成Swagger接口文档

    统一异常处理

    规范返回对象