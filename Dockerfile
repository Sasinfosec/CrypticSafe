FROM amazoncorretto:17.0.7-alpine

RUN apt-get install maven -y
RUN mvn clean install -x

COPY ./target/kode-0.0.1-SNAPSHOT.jar kode-0.0.1-SNAPSHOT.jar

ENTRYPOINT["java", "-jar", "/kode-0.0.1-SNAPSHOT.jar"]


