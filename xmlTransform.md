一.简介
Anakia 使用JDOM 和Velocity将XML文档转换为特定格式的文档


二.解析xml文档方法

1.DOM

java jdk,xml-api.jar
需要加载整个xml文档来构建层次结构

2.SAX(Simple API for XML)

基于事件模型，不需要读取整个xml文档

3.JDOM(Java-based Document Object Model)

本身不包含解析器，通常使用SAX2解析器来解析和验证输入XML文档。


4.DOM4J
性能佳

[http://www.cnblogs.com/lanxuezaipiao/archive/2013/05/17/3082949.html](http://www.cnblogs.com/lanxuezaipiao/archive/2013/05/17/3082949.html)


三.构建velocity

准备：

1.download ant
[http://ant.apache.org/bindownload.cgi](http://ant.apache.org/bindownload.cgi)

配置ANT 环境变量

2.build 
一开始参考官网的这篇文档[https://velocity.apache.org/engine/devel/build.html](https://velocity.apache.org/engine/devel/build.html)
在velocity1.7 上面做的实验，出现了很多错误，错误记录在四。
- download velocity1.5

- 编辑 test.xml文件，放在examples\anakia\xdocs\about 目录下
可以添加 html tag。

		<document>
  			<properties>
			    <author email="st3690@163.com">FS</author>
			    <title>Welcome</title>
  			</properties>
		<body>
		  <section name="Section 1">
			<p>
				welcome to velocityLearning github
			</p>
			<img src="/images/velocity.gif" width="329" height="105"/>
			<p>you can add html tag</p>
		  </section>
		  <section name="Section 2">
		    <p> here is another section </p>
		  </section>
		  <section name="section 3">
		    <p><a href="https://github.com/FS1360472174/velocityLearning">
				you can access this repository for more learning in github</a>
			</p>
		  </section>
		</body>
		</document>

- cd examples/anakia/build 执行 ant 命令。

就会在examples\anakia\docs\about 目录生成test.html

这边官网的velocity1.5 目录有点问题。根据错误信息修改了build.xml.将classpath 修改成只从lib目录读取

		<path id="classpath">
	        <fileset dir="../../../lib">
	            <include name="**/*.jar"/>
	        </fileset>
	    </path>

具体查看github




四.velocity1.7的错误记录
- download maven
download:[http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi)
配置环境变量。
mvn -v 成功表示安装成功



- 在velocity/build 目录下执行

-> mvn install

报了这样的错误："The goal you specified requires a project to execute but there is no POM in this directory" while doing Maven install.
缺少pom.xml

解决：
http://svn.apache.org/repos/asf/velocity/engine/tags/1.7/pom.xml
再次执行仍然报错，download错误，怀疑是网络问题，加上 -X debug 信息。这次成功build success.
在build下面 创建一个target 文件夹

- 在example/anakia/build 目录下面执行

->ant

发现1.7版本下面根本就没有这个目录，最后在1.5目录下面找到了这个。

五.总结
其实利用Anakia将xml文件转换为特定的文档格式很简单，但是官网的文档貌似很久没有更新。velocity不同版本
的目录记录貌似也有些差异。所以给开发者使用，造成了一定的阻碍，耽误了学习的时间。

从三,四步骤看来，利用maven build整个velocity似乎也没有必要。我们只用利用ant工具，调用
anakia task即可。不知道为什么官网的说明文档强调必须要有这步骤。

所有源码可以在这里找到:
[https://github.com/FS1360472174/velocityLearning/anakia](https://github.com/FS1360472174/velocityLearning/anakia)