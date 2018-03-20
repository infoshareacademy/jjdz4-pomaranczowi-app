FROM jboss/wildfly:latest

ADD config /opt/jboss/wildfly/config/

COPY webapp/target/webapp.war /opt/jboss/wildfly/config/

COPY dump.sql /opt/jboss/wildfly/config/

COPY dump.sql fin-analyser-db:/docker-entrypoint-initdb.d

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp

