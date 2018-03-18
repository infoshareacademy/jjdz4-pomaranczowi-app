FROM jboss/wildfly:latest

ADD docker/webapp/config /opt/jboss/wildfly/config/

COPY webapp/target/webapp.war /opt/jboss/wildfly/config/

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp