FROM openjdk:8u171-jdk-alpine3.7
LABEL maintainer="cs.cadavez@gmail.com"

ENV LANG C.UTF-8

RUN apk add --update bash

COPY docker-entrypoint.sh /usr/local/bin/
ENTRYPOINT ["docker-entrypoint.sh"]

ADD build/libs/*.jar /app/app.jar

EXPOSE 8080

CMD [ "/app/app.jar" ]