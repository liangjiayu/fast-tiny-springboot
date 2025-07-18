# 基础镜像
FROM eclipse-temurin:21
# 设置工作目录
WORKDIR /app
# 复制构建的JAR文件到容器中
COPY ./fast-tiny-admin/target/*.jar app.jar
# 声明服务端口
EXPOSE 7100
# 启动应用
ENTRYPOINT ["java", "-jar","app.jar"]