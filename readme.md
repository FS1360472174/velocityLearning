velocity learning

一.velocity 简介

基于java 的模板引擎，apache 旗下的开源软件项目。
目的在于隔离 表示层和业务逻辑层，当然现在做的不仅仅是这些。

二.应用场景

- web 应用程序：创建html页面，页面的动态信息有velocity框架来处理
意味着可以不使用JSP等动态语言
- 源代码生成：基于模板生成java,sql源代码
- email 生成：将邮件模板存储在文本文件
- xml转换:velocity 提供一个Ant 任务-Anakia,Anakia 读取xml文件，利用velocity 模板转换为所需的文档格式


三.具体project

1.场景1（web应用程序）具体说明参考 introduction of velocity.md

2.场景2（源代码生成） 具体说明参考 autoGenerateCode.md