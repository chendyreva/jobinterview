FROM tomcat:9

ARG TOMCAT_USERS_FILE
ARG WAR_FILE

COPY ./${TOMCAT_USERS_FILE} /usr/local/tomcat/conf
COPY ./target/${WAR_FILE} /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]


