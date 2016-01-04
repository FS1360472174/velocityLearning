说明：场景2- 源代码生成：基于模板生成java,sql源代码

个人理解这边不仅仅可以生成java、sql源代码，同样可以生成jsp源码。以及其他重复的代码

在实际编程过程中，有许多重复性的代码。比如MVC 架构过程，会创建model层，dao 层，action层。

这些文件的创建过程中就有很多的重复过程。这些重复的code就可以利用velocity技术来完成，避免重复code编写。

java 编辑器如eclipse 也会为我们做一些源代码生成的工作，比如创建一个servlet文件，比如为属性生成get/set 方法。

但是在具体的项目，我们需要基于业务，code规范制定自己的模板。

一.以创建servlet 文件为例

1.创建一个servlet模板文件 servletTemplate.vm
将servlet 共通的部分放在模板文件中

	package ${package};
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	@WebServlet("${className}Servlet")
	public class ${className}Servlet extends HttpServlet{
		public ${className}Servlet(){
		
		}
		
		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	}

2.创建一个生成文件方法
		
		Velocity ve =new Velocity();
		ve.setProperty(Velocity.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
		
		Template template= ve.getTemplate("velocity/servletTemplate.vm");
		
		VelocityContext context=new VelocityContext();
		context.put("className", "Second");
		context.put("package", "com.fs.velocity.servlet");
		String path=System.getProperty("user.dir")+"/src/com/fs/velocity/servlet/SecondServlet.java";
		PrintWriter pw=null;
		try {
			 pw =new PrintWriter(path);
			template.merge(context, pw);
			pw.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
		}

具体参考GenerateTemplateCode.java 与servletTemplate.vm
SecondServlet.java 就是生成的servlet文件

refer:
[http://www.dexcoder.com/selfly/article/3958](http://www.dexcoder.com/selfly/article/3958)