FROM openjdk8
MAINTAINER wang
ENV LANG en_US.UTF-8
COPY target/user-service-0.0.2-SNAPSHOT.jar /root/user-service.jar
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone
CMD ["java","-jar","/root/user-service.jar"]
EXPOSE 8081