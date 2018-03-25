FROM jboss/wildfly:latest

ADD config /opt/jboss/wildfly/config/

COPY webapp/target/webapp.war /opt/jboss/wildfly/config/

COPY report/target/report.war /opt/jboss/wildfly/config/

COPY dump.sql /opt/jboss/wildfly/config/

COPY dump.sql fin-analyser-db:/docker-entrypoint-initdb.d

CMD ["/opt/jboss/wildfly/config/executeWebapp.sh"]
CMD ["/opt/jboss/wildfly/config/executeReport.sh"]

RUN mkdir ~/tmp

