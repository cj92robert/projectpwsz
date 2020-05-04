FROM openjdk:11-jdk
ADD target/projectpwsz-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar projectpwsz-0.0.1-SNAPSHOT.jar
