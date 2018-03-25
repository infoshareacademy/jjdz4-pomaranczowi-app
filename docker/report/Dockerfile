FROM jboss/wildfly:11.0.0.Final

ADD config /opt/jboss/wildfly/config/

COPY report.war /opt/jboss/wildfly/config/

CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp
