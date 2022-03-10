package cn.hcq413.web.junit;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CreateJAVA {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://gz-cdb-975vpfib.sql.tencentcdb.com:57620/txyun?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "175176as")
                .globalConfig(builder -> {
                    builder.author("hcq413") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.hcq413.web.pojo") // 设置父包名
                            .moduleName("spring_boot") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapper, "D:\\Daima\\spring_boot\\springboot-jpa\\src\\main\\java\\cn\\hcq413\\web\\dao")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("filmtype") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
