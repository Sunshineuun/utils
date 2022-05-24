> 一些工具类的实现

1. MapStruct的实现。
   > MapStruct是一款Java对象转换处理器。主要用于对象间属性的copy。它是基于编译期间，生成代码来调用源对象和目标对象的代码。
2. Selenium Chrome的实现
3. 日志输出到ES上，logback >> logstash >> es

```yml
elk:
  logstash:
    print:
      enable: 1
    host: localhost:8065
```

```
// 这里需要注意的是，需要在logstash-sample.conf中绑定template
// template => "" 本地配置，无法在ES创建模板，这个还要研究下的。
// template_name => "" 对应ES上以后的template，可通过【/_template/luyun-template】查看已有的模板
// ES 创建模板请查看【es-tempate-CRUD.http】 文件
output {
  elasticsearch {
    hosts => ["http://localhost:9200"]
    index => "luyun-%{+YYYY.MM.dd}"
    template => "/Users/qiushengming/Documents/tool/ELK/logstash-7.17.2/config/luyun-template.json"
    template_name => "luyun-template"
    manage_template => true
    template_overwrite => true
    #index => "%{[@metadata][beat]}-%{[@metadata][version]}-%{+YYYY.MM.dd}"
    #user => "elastic"
    #password => "changeme"
  }
}
```
   