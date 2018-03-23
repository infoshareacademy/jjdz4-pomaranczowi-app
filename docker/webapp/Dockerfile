FROM jboss/wildfly:latest

ADD config /opt/jboss/wildfly/config/

# TODO: WEBAPP FROM TARGET/
COPY webapp.war /opt/jboss/wildfly/config/

COPY dump.sql /opt/jboss/wildfly/config/

COPY dump.sql fin-analyser-db:/docker-entrypoint-initdb.d

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp

