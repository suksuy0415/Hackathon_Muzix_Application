FROM openjdk:11-jre-slim
WORKDIR usr/src
#ENV MONGO_URI=mongodb://localhost:27017/movie_db
ADD ./target/UserTrackService-0.0.1-SNAPSHOT.jar /usr/src/UserTrackService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserTrackService-0.0.1-SNAPSHOT.jar"]
