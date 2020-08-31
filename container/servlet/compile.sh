#!/bin/sh
javapath="/usr/local/tomcat/webapps/app/WEB-INF/classes/com/tyamap/simple_servlet/"
apipath="/usr/local/tomcat/lib/"

# JDBCドライバの取得
wget -q https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-8.0.21.zip
unzip -q mysql-connector-java-8.0.21.zip
mv mysql-connector-java-8.0.21/mysql-connector-java-8.0.21.jar /usr/local/tomcat/webapps/app/WEB-INF/lib
rm -rf mysql-connector-java-8.0.21 mysql-connector-java-8.0.21.zip

# コンパイル
javac -classpath ${apipath}servlet-api.jar ${javapath}Hello.java
javac -classpath ${apipath}servlet-api.jar ${javapath}Test.java

catalina.sh run 
