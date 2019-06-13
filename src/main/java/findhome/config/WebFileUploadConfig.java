package findhome.config;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.MultipartProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.Servlet;

/**
 * 文件上传配置
 * Created by 瓦力.
 */
@Configuration
//其用途是判断当前classpath下是否存在指定类
@ConditionalOnClass({Servlet.class, StandardServletMultipartResolver.class, MultipartConfigElement.class})
/**
 使用@EnableConfigurationProperties开启使用自动配置的文件，当配置文件缺失的时候默认 spring.http.multipart.enabled为true
 String[] value() default {}; //数组，获取对应property名称的值，与name不可同时使用

 String prefix() default "";//property名称的前缀，可有可无

 String[] name() default {};//数组，property完整名称或部分名称（可与prefix组合使用，组成完整的property名称），与value不可同时使用

 String havingValue() default "";//可与name组合使用，比较获取到的属性值与havingValue给定的值是否相同，相同才加载配置

 boolean matchIfMissing() default false;//缺少该property时是否可以加载。如果为true，没有该property也会正常加载；反之报错

 boolean relaxedNames() default true;//是否可以松散匹配，至今不知道怎么使用的**/
@ConditionalOnProperty(prefix = "spring.http.multipart", name = "enabled", matchIfMissing = true, havingValue = "true")
/**如果一个配置类只配置@ConfigurationProperties注解，而没有使用@Component，那么在IOC容器中是获取不到properties 配置文件转化的bean。
 说白了 @EnableConfigurationProperties 相当于把使用  @ConfigurationProperties 的类进行了一次注入。
 **/
@EnableConfigurationProperties(MultipartProperties.class)
public class WebFileUploadConfig {
    private final MultipartProperties multipartProperties;

    public WebFileUploadConfig(MultipartProperties multipartProperties) {
        this.multipartProperties = multipartProperties;
    }

    /**
     * 上传配置
     */
    @Bean
    @ConditionalOnMissingBean
    public MultipartConfigElement multipartConfigElement() {
        return this.multipartProperties.createMultipartConfig();
    }

    /**
     * 注册解析器
     */
    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    @ConditionalOnMissingBean(MultipartResolver.class)
    public StandardServletMultipartResolver multipartResolver() {
        StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
        multipartResolver.setResolveLazily(this.multipartProperties.isResolveLazily());
        return multipartResolver;
    }

    /**
     * 华东机房
     */
    @Bean
    public com.qiniu.storage.Configuration qiniuConfig() {
        return new com.qiniu.storage.Configuration(Zone.zone0());
    }

    /**
     * 构建一个七牛上传工具实例
     */
    @Bean
    public UploadManager uploadManager() {
        return new UploadManager(qiniuConfig());
    }

    @Value("${qiniu.AccessKey}")
    private String accessKey;
    @Value("${qiniu.SecretKey}")
    private String secretKey;

    /**
     * 认证信息实例
     * @return
     */
    @Bean
    public Auth auth() {
        return Auth.create(accessKey, secretKey);
    }

    /**
     * 构建七牛空间管理实例
     */
    @Bean
    public BucketManager bucketManager() {
        return new BucketManager(auth(), qiniuConfig());
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
