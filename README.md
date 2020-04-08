仿知乎问答项目


项目大致使用技术栈
```
前端实现
①前端直接复制知乎的前端源码,简单修改
②模板引擎采用freemarker

后端实现
①用户登录与注册
②用户的提问与回答
③评论和点赞
④站内私信流



```
##  用户注册登录功能  
```
大致思入:
①用户密码md5盐化存储,登录后生成session(设置30分钟有效期)
②用户的登录session统一存放到mysql,方便以后分布式session的扩展
③拦截器预先处理用户的cookie,识别后将用户实例放入ThreadLocal供后续函数使用
④凡是没有识别的请求,统一转到转跳到登录页面(拦截器)
```



## 问题的添加
```
①内容进行转义和敏感词过滤(字典树快速匹配)
```

## 评论
```
①问题,回答,评论的评论,统一放在一个表中,方便以后做成评论中心
②设置伪删除功能
```


## 点赞 
```
①在redis使用set,为每个问题的key设置为like_id号,value为点赞用户的集合
②js回调动态显示
```