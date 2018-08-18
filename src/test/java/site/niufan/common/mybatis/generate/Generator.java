package site.niufan.common.mybatis.generate;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * AbstractGenerator
 * @author Fan Niu
 * @since 2018-08-08
 */
public abstract class Generator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Generator.class);

    public static void run(Class<? extends Generator> clazz, String[] args) {
        Generator generator;
        try {
            generator = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Generator must have default construct.", e);
        }
        LOGGER.info("Run params are " + Arrays.toString(args));
        generator.generate();
    }

    protected void generate() {
        boolean start = scanner();
        if (!start) {
            return;
        }
        AutoGenerator autoGenerator = new AutoGenerator()
                .setPackageInfo(getPackageInfo())
                .setGlobalConfig(getGlobalConfig())
                .setDataSource(getDataSourceConfig())
                .setStrategy(getStrategyConfig())
                .setTemplate(getTemplateConfig())
                ;

        autoGenerator.execute();
    }

    protected boolean scanner() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("代码生成器启动\n");
        help.append("是否开始生成代码（y/n）：");
        System.out.print(help);
        boolean start = false;
        if (scanner.hasNext()) {
            String in = scanner.next();
            start = "y".equalsIgnoreCase(in);
        }
        return start;
    }

    protected PackageConfig getPackageInfo() {
        return new PackageConfig()
                .setParent(null)
                .setController("com.athub.athubcloud.failure.controller")
                .setService("com.athub.athubcloud.failure.service")
                .setServiceImpl("com.athub.athubcloud.failure.service.impl")
                .setMapper("com.athub.athubcloud.failure.dal.mapper")
                .setEntity("com.athub.athubcloud.failure.dal.model")
                .setXml("com.athub.athubcloud.failure.dal.mapper.xml")
                ;
    }

    protected GlobalConfig getGlobalConfig() {
        return new GlobalConfig()
                .setOutputDir(System.getProperty("user.dir") + "/generate")
                .setOpen(false) // 是否打开输出目录
                .setFileOverride(true) // 是否覆盖已有文件
                .setActiveRecord(true) //
                .setEnableCache(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setXmlName("%sMapper")
                .setMapperName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController")
                .setAuthor("Fan Niu")
                ;
    }

    protected abstract DataSourceConfig getDataSourceConfig();

    protected StrategyConfig getStrategyConfig() {
        return new StrategyConfig()
                .setCapitalMode(true) // 大写命名
                .setDbColumnUnderline(true) // 下划线命名
                .setNaming(NamingStrategy.underline_to_camel) // 表名到类型命名
                .setEntityBooleanColumnRemoveIsPrefix(true) // IS_DELETE -> delete
                .setEntityBuilderModel(false) // 【实体】是否为构建者模型
                .setSuperEntityClass(Model.class.getName()) // 父Entity
                .setSuperEntityColumns("id")
                .setSuperMapperClass(BaseMapper.class.getName()) // 父Mapper
                .setSuperServiceClass(IService.class.getName()) // 父Service
                .setSuperServiceImplClass(ServiceImpl.class.getName()) // 父ServiceImpl
                // .setSuperControllerClass(ApiController.class.getName()) // 父Controller
                .setRestControllerStyle(true) // @RestController
                .setControllerMappingHyphenStyle(true) // 驼峰转连字符
                ;
    }

    protected TemplateConfig getTemplateConfig() {
        return new TemplateConfig()
                .setController("/templates/controller.java")
                .setService("/templates/service.java")
                .setServiceImpl("/templates/serviceImpl.java")
                .setMapper("/templates/mapper.java")
                .setXml("/templates/mapper.xml")
                .setEntity("/templates/entity.java")
                ;
    }
}
