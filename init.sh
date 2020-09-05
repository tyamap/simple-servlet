# !/usr/bin/bash

cd backend
mvn clean package
cd ../frontend
npm run build
cd ..
docker-compose up --build