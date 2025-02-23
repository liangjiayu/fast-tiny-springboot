# # 基础镜像
# FROM eclipse-temurin:17

# # 设置应用名称标签
# # LABEL maintainer="your-email@example.com"
# # LABEL application.name="fast-tiny-app"
# # 定义环境变量
# ENV spring.profiles.active=prod
# # 声明服务端口
# EXPOSE 7100
# # 添加 JAR 文件
# ADD ./target/fast-tiny-admin-0.0.1-SNAPSHOT-exec.jar /app.jar
# # 启动命令
# ENTRYPOINT ["java", "-jar","/app.jar"]

# 基础镜像
FROM eclipse-temurin:17
# 设置工作目录
WORKDIR /app
# 定义环境变量
ENV spring.profiles.active=prod
# 复制构建的JAR文件到容器中
COPY ./fast-tiny-admin/target/*.jar app.jar
# 声明服务端口
EXPOSE 7100
# 启动应用
ENTRYPOINT ["java", "-jar","app.jar"]