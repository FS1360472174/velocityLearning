package com.fs.client;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class GenerateTemplateCode {

	public static void main(String[] args) {
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
		

	}

}
