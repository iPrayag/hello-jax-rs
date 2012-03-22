package org.jcheng.demo.jersey.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

	public MyWebAppInitializer() {
		System.out.println("myWebAppinit");
	}

    public void onStartup(ServletContext container) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
          new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
        
        ServletRegistration.Dynamic dispatcher =
          container.addServlet("dispatcher",  new SpringServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }

}
