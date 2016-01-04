说明：场景2- 源代码生成：基于模板生成java,sql源代码

个人理解这边不仅仅可以生成java、sql源代码，同样可以生成jsp源码。以及其他重复的代码

在实际编程过程中，有许多重复性的代码。比如MVC 架构过程，会创建model层，dao 层，action层。

这些文件的创建过程中就有很多的重复过程。这些重复的code就可以利用velocity技术来完成，避免重复code编写。

java 编辑器如eclipse 也会为我们做一些源代码生成的工作，比如创建一个servlet文件，比如为属性生成get/set 方法。

但是在具体的项目，我们需要基于业务，code规范制定自己的模板。

一.以创建servlet 文件为例

1.创建一个servlet模板文件 servletTemplate.vm

[http://www.dexcoder.com/selfly/article/3958](http://www.dexcoder.com/selfly/article/3958)