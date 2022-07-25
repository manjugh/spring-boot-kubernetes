Different ways to build spring boot application docker image

1. Using docker command and Dockerfile to build docker image
   https://docs.docker.com/engine/reference/commandline/build/
   docker build -t mgh/bookmark-api:1.0

2. Using spring-boot-maven-plugin with buildpacks
   https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/#?
  It does not require DockerFile 

mvn spring-boot:build-image -Dspring-boot.build-image.imageName=mgh/sb-bookmark-api:1.0

3. maven jib plugin
   mvn jib:dockerBuild -- without pushing to registry
   mvn jib:build

https://github.com/GoogleContainerTools/jib/tree/master/examples/spring-boot


Command to run the container:

docker container run -p 8080:8080 mgh/bookmark-api:1.0