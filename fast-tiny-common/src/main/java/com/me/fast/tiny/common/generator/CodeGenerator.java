package com.me.fast.tiny.common.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
    public static void main(String[] args) {
        // 使用 FastAutoGenerator 快速配置代码生成器
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/fast_tiny_db?useUnicode=true&characterEncoding=utf-8", "root", "123456789")
                .globalConfig(builder -> {
                    builder.author("system_generator") // 设置作者
                            .enableSpringdoc()// 开启 Swagger 模式
                            .outputDir("generatorFile/"); // 输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.me.fast.tiny.admin") // 设置父包名
                            .controller("controller") // 设置 Controller 包名
                            .entity("model") // 设置实体类包名
                            .mapper("mapper") // 设置 Mapper 接口包名
                            .service("service") // 设置 Service 接口包名
                            .serviceImpl("service.impl") // 设置 Service 实现类包名
                            .xml("xml"); // 设置 Mapper XML 文件包名
                })
                .strategyConfig((scanner, builder) -> {
                    builder.addInclude(scanner.apply("请输入表名，多个英文逗号分隔？")) // 设置需要生成的表名

                            .controllerBuilder()
                            .template("/templates/controller.java") // 设置 Controller 模板
                            .enableFileOverride()

                            .entityBuilder()
                            .enableLombok() // 启用 Lombok
                            .fieldUseJavaDoc(false) // 启用字段文档注释
                            .enableFileOverride()

                            .serviceBuilder()
                            .serviceTemplate("/templates/service.java") // 设置 Service 模板
                            .serviceImplTemplate("/templates/serviceImpl.java") // 设置 ServiceImpl 模板
                            .enableFileOverride()

                            .mapperBuilder()
                            .enableFileOverride()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
                .execute(); // 执行生成
    }
}
