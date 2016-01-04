introduction of velocity

一.velocity 简介

基于java 的模板引擎，apache 旗下的开源软件项目。
目的在于隔离 表示层和业务逻辑层，当然现在做的不仅仅是这些。

二.应用场景

- web 应用程序：创建html页面，页面的动态信息有velocity框架来处理
意味着可以不使用JSP等动态语言
- 源代码生成：基于模板生成java,sql源代码
- email 生成：将邮件模板存储在文本文件
- xml转换:velocity 提供一个Ant 任务-Anakia,Anakia 读取xml文件，利用velocity 模板转换为所需的文档格式

三.基本语法
1.关键字以#开头

2.变量以$开头，变量类型是弱类型

3.定义函数

#macro(macroname arg1 arg2)
#end

调用
#macroname(arg1 arge)

4.#parse,#include

两者都是引用外部文件，
#parse会将引用的内容作为源码文件执行，会对代码进行解析
#include拷贝替换所有的文本内容

更多[http://www.cnblogs.com/codingsilence/archive/2011/03/29/2146580.html](http://www.cnblogs.com/codingsilence/archive/2011/03/29/2146580.html)



四.第一个项目----场景1(web应用程序)
pre:
jar 包下载[http://velocity.apache.org/download.cgi?cm_mc_uid=56692902242514430865854&cm_mc_sid_50200000=1451871613](http://velocity.apache.org/download.cgi?cm_mc_uid=56692902242514430865854&cm_mc_sid_50200000=1451871613)

需要引入velocity-1.7.jar，以及lib包下面jar文件

VelocityTag

1.初始化VelocityEngine
	
		VelocityEngine ve = new VelocityEngine();
		// Velocity.java implements RuntimeConstants
		// so you can use RuntimeConstants.RESOURCE_LOADER="resource.loader"
		ve.setProperty(Velocity.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

2.关联模板文件
		
	Template template = ve.getTemplate("velocity/firstVelocity.vm");

3.写入动态内容

		VelocityContext context = new VelocityContext();
		context.put("first", "fristVelocityExample");

4.输入到浏览器
	
		PrintWriter pw = response.getWriter();
		template.merge(context, pw);
		
具体参考com.fs.velocity.servlet.FristVelocity.java 与velocity.firstVelocity.vm

