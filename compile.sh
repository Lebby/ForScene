#!/bin/sh
mvn clean
rm -r /home/blackdevil/.m2/repository/com/github/Lebby/
mvn package
mvn install
