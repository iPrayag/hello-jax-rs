resolvers += "Web plugin repo" at "http://siasia.github.com/maven2"    

resolvers += Classpaths.typesafeResolver

//Following means libraryDependencies += "com.github.siasia" %% "xsbt-web-plugin" % "0.1.1-<sbt version>""
libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-0.2.9"))

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse" % "1.5.0")
