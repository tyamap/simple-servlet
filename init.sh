# !/usr/bin/bash

mvn clean
mvn package
cp target/webapp.war container/servlet/app.war
docker-compose up --build