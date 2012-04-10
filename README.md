# JAX-RS Demo

A simple server for rapid prototyping RESTful web services. This proof-of-concept shows that you can deploy RESTful web services in Java with just a few lines of code.

## Run The Demo

Clone the project from Github.

``` 
$ ant clean-resolve webapp-all
Buildfile: /Users/jcheng/work/github/tmp/hello-jax-rs/build.xml

ivy-check-download:

ivy-download:
    [mkdir] Created dir: /Users/jcheng/work/github/tmp/hello-jax-rs/ivy
     [echo] installing ivy...
      [get] Getting: http://repo1.maven.org/maven2/org/apache/ivy/ivy/2.2.0/ivy-2.2.0.jar
      [get] To: /Users/jcheng/work/github/tmp/hello-jax-rs/ivy/ivy.jar

ivy-init:

clean-resolve:

ivy-check-download:

ivy-download:

ivy-init:

resolve:
...
[ivy:resolve] 	asm#asm;3.1 by [asm#asm;3.3.1] in [default]
	---------------------------------------------------------------------
	|                  |            modules            ||   artifacts   |
	|       conf       | number| search|dwnlded|evicted|| number|dwnlded|
	---------------------------------------------------------------------
	|      default     |   47  |   0   |   0   |   1   ||   42  |   0   |
	---------------------------------------------------------------------
[ivy:retrieve] :: retrieving :: org.jcheng.demo#jersey
[ivy:retrieve] 	confs: [default]
[ivy:retrieve] 	42 artifacts copied, 0 already retrieved (9749kB/129ms)

webapp-compile:
    [mkdir] Created dir: /Users/jcheng/work/github/hello-jax-rs/target/webapp/WEB-INF/classes
    [javac] Compiling 5 source files to /Users/jcheng/work/github/hello-jax-rs/target/webapp/WEB-INF/classes

webapp-jsps:
     [copy] Copying 2 files to /Users/jcheng/work/github/hello-jax-rs/target/webapp

webapp-restart:
     [copy] Copying 1 file to /Users/jcheng/work/github/hello-jax-rs/target/webapp
     [copy] Copying 27 files to /Users/jcheng/work/github/hello-jax-rs/target/webapp/WEB-INF/lib

webapp-run:
    [mkdir] Created dir: /Users/jcheng/work/github/hello-jax-rs/target/src/generated/java/gen
    [mkdir] Created dir: /Users/jcheng/work/github/hello-jax-rs/target/classes/embeddedJetty
    [javac] Compiling 1 source file to /Users/jcheng/work/github/hello-jax-rs/target/classes/embeddedJetty
     [java] 2012-03-22 16:32:07.575:INFO:oejs.Server:jetty-8.1.0.RC4
     [java] 2012-03-22 16:32:08.128:INFO:oejw.StandardDescriptorProcessor:NO JSP Support for /, did not find org.apache.jasper.servlet.JspServlet
     [java] 2012-03-22 16:32:08.303:INFO:oejsh.ContextHandler:started o.e.j.w.WebAppContext{/,file:/Users/jcheng/work/github/hello-jax-rs/target/webapp/},target/webapp
     [java] 2012-03-22 16:32:08.303:INFO:oejsh.ContextHandler:started o.e.j.w.WebAppContext{/,file:/Users/jcheng/work/github/hello-jax-rs/target/webapp/},target/webapp
     [java] 2012-03-22 16:32:08.328:INFO:/:Initializing Spring root WebApplicationContext
     [java] Mar 22, 2012 4:32:08 PM org.springframework.web.context.ContextLoader initWebApplicationContext
     [java] INFO: Root WebApplicationContext: initialization started
     [java] Mar 22, 2012 4:32:08 PM org.springframework.context.support.AbstractApplicationContext prepareRefresh
     [java] INFO: Refreshing Root WebApplicationContext: startup date [Thu Mar 22 16:32:08 PDT 2012]; root of context hierarchy
     [java] Mar 22, 2012 4:32:08 PM org.springframework.web.context.support.AnnotationConfigWebApplicationContext loadBeanDefinitions
     [java] INFO: Successfully resolved class for [org.jcheng.demo.jersey.spring.AppConfig]
     [java] Mar 22, 2012 4:32:08 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
     [java] INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@67ce85c4: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,appConfig,org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor#0,helloJavaResource]; root of factory hierarchy
     [java] Mar 22, 2012 4:32:08 PM org.springframework.web.context.ContextLoader initWebApplicationContext
     [java] INFO: Root WebApplicationContext: initialization completed in 378 ms
     [java] 2012-03-22 16:32:08.711:INFO:oejsh.ContextHandler:started o.e.j.w.WebAppContext{/,file:/Users/jcheng/work/github/hello-jax-rs/target/webapp/},target/webapp
     [java] Mar 22, 2012 4:32:08 PM com.sun.jersey.spi.spring.container.servlet.SpringServlet getContext
     [java] INFO: Using default applicationContext
     [java] Mar 22, 2012 4:32:08 PM com.sun.jersey.spi.spring.container.SpringComponentProviderFactory registerSpringBeans
     [java] INFO: Registering Spring bean, helloJavaResource, of type org.jcheng.demo.jersey.HelloJavaResource as a root resource class
     [java] Mar 22, 2012 4:32:08 PM com.sun.jersey.server.impl.application.WebApplicationImpl _initiate
     [java] INFO: Initiating Jersey application, version 'Jersey: 1.11 12/09/2011 10:27 AM'
     [java] 2012-03-22 16:32:09.532:INFO:oejs.AbstractConnector:Started SelectChannelConnector@0.0.0.0:8080 STARTING
```

Then check out the sample web service:

* <http://localhost:8080/rest/helloFromJava>
* <http://localhost:8080/rest/helloFromJava/json>
* <http://localhost:8080/rest/helloFromJava/xml>

You can also specify that you want XML output by specifying the 'Accept: **mimetype**' header, e.g.,

```
$ curl -H 'Accept: application/xml' http://localhost:8080/rest/helloFromJava
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><user><alias>Java</alias><email>java@example.com</email><messages>hello</messages><messages>world</messages><messages>from</messages><messages>Java</messages></user>
```


## Tested Configuration (aka Requirements)

* Ant 1.8
* Eclipse 

## Why Ivy instead of Maven?

Maven is the standard when it comes to dependency management. However, Ivy is useful when the library you need is not hosted on a public Maven repository or when you have complicated dependencies (LWJGL. for example). Ivy allows a build process where you do check in your dependencies (for better or worse). For this proof-of-concept, I need the option to override dependencies with jar files on the local environment, which Maven does not support easily.

I have included some useful ant tasks to help with managing Ivy dependencies. The `clean-resolve` task will generate ivy dependency reports in the `lib/reports` directory.






