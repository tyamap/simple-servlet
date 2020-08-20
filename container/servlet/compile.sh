#!/bin/sh
javapath="/usr/local/tomcat/webapps/app/WEB-INF/classes/mypackage/"
apipath="/usr/local/tomcat/lib/"

javac -classpath ${apipath}servlet-api.jar ${javapath}Hello.java

catalina.sh run 
