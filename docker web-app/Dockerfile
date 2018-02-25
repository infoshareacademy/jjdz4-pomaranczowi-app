FROM jboss/wildfly:latest

ADD config /opt/jboss/wildfly/config/

COPY web-app.war /opt/jboss/wildfly/config/

COPY dump.sql /tmp/

COPY dump.sql /docker-entrypoint-initdb.d/

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp