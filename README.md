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
4. ```