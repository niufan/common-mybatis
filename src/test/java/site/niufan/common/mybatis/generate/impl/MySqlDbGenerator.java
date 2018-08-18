package site.niufan.common.mybatis.generate.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import site.niufan.common.mybatis.generate.Generator;

/**
 * MySqlDbGenerator
 * @author Fan Niu
 * @since 2018-08-08
 */
public class MySqlDbGenerator extends Generator {

    public static void main(String[] args) {
        Generator.run(MySqlDbGenerator.class, args);
    }

    @Override
    protected void generate() {
        super.generate();
    }

    @Override
    protected boolean scanner() {
        return true;
    }

    @Override
    protected PackageConfig getPackageInfo() {
        return super.getPackageInfo();
    }

    protected GlobalConfig getGlobalConfig() {
        return super.getGlobalConfig();
    }

    protected DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                .setDbType(DbType.MYSQL)
                .setTypeConvert(new MySqlTypeConvert())
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&useUnicode=true&serverTimezone=UTC&useSSL=true")
                .setUsername("root")
                .setPassword("root")
                ;
    }

    protected StrategyConfig getStrategyConfig() {
        return super.getStrategyConfig();
    }

    protected TemplateConfig getTemplateConfig() {
        return super.getTemplateConfig();
    }
}
