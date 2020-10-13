FROM openjdk:11
ARG TOKEN_ID
ENV tokenId=${TOKEN_ID}
COPY build/libs/CINotification-1.0.jar CINotification.jar
#RUN javac Main.java
ENTRYPOINT ["java", "-jar", "CINotification.jar"]
CMD ls -la