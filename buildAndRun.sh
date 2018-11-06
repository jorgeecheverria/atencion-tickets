#!/bin/sh
mvn clean package && docker build -t gt.com.kinal/Atencion-Tickets .
docker rm -f Atencion-Tickets || true && docker run -d -p 8080:8080 -p 4848:4848 --name Atencion-Tickets gt.com.kinal/Atencion-Tickets 
