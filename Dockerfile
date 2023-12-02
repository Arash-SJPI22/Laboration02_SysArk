FROM quay.io/wildfly/wildfly:latest-jdk20
LABEL authors="ARASH-SJPI22"
COPY target/Laboration02_SysArk-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/