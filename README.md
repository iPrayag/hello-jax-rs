# JAX-RS Demo

A simple server for rapid prototyping RESTful web services.

## Features

* Eclipse integration
* Embedded jetty server
* Serves static contents from `src/main/webapp`
* Serves web services from `src/main/java/jcheng/jersey`

In short, you can run a RESTful webservice in Java with just a few lines of code.

## Run The Demo

``` 
$ ./sbt
[info] Loading global plugins from /Users/jcheng/.sbt/plugins
[info] Loading project definition from /Users/jcheng/work/demo/scala-web/project
[info] Set current project to scala-web (in build file:/Users/jcheng/work/demo/scala-web/)
> eclipse with-sources
> container:start
[info] jetty-8.0.1.v20110908
[info] NO JSP Support for /, did not find org.apache.jasper.servlet.JspServlet
[info] started o.e.j.w.WebAppContext{/,[file:/Users/jcheng/work/demo/scala-web/src/main/webapp/]}
[info] started o.e.j.w.WebAppContext{/,[file:/Users/jcheng/work/demo/scala-web/src/main/webapp/]}
[info] Started SelectChannelConnector@0.0.0.0:8080 STARTING
[success] Total time: 0 s, completed Dec 21, 2011 10:58:42 AM
> container:stop 
[info] stopped o.e.j.w.WebAppContext{/,[file:/Users/jcheng/work/demo/scala-web/src/main/webapp/]}
[success] Total time: 0 s, completed Dec 21, 2011 10:58:53 AM
```

Then check out the sample web service:

* <http://localhost:8080/rest/helloFromJava>
* <http://localhost:8080/rest/helloFromJava/json>
* <http://localhost:8080/rest/helloFromJava/xml>

You can also specify that you want JSON output by specifying the 'Accept: **mimetype**' header, e.g.,

```
$ curl -H 'Accept: application/json' http://localhost:8080/rest/helloFromJava
{"alias":"Java","messages":["hello","world","from","Java"],"email":"java@example.com"}l
```


## Tested Configuration (aka Requirements)

* SBT (version 0.11.1 is included and tested)
* Eclipse 
    - If you are using Eclipse with Scala, you should have Eclipse 3.6 and Scala IDE 2.0 for Scala 2.9.1


