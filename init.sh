# !/usr/bin/bash

mvn clean package
cp target/webapp.war container/servlet/app.war
docker-compose up --build