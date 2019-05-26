package cc.daleyzou.common.config;

import cc.daleyzou.common.xss.XssFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Configuration
@SuppressWarnings("unchecked")
public class WebConfig {

    /**
     * XssFilter Bean
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*,/sketchImgs/*");
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }

    @Bean
    public ObjectMapper getObjectMapper(FebsProperties febsProperties) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(febsProperties.getTimeFormat()));
        return mapper;
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        /**
//         * @Description: 对文件的路径进行配置,创建一个虚拟路径/file/** ，即只要在<img src="/file/images/20180522/9aa64b2b-a558-421e-929c-537ff0aecdba.jpg" />便可以直接引用图片
//         *这是图片的物理路径 "file:/+本地图片的地址"
//         * @Date： Create in 14:08 2017/12/20
//         *
//         */
//        //读取配置文件中的上传路径
//        String url = "D:/Graduation/EasyPACS/tmp/workspace/sketch/";
//        registry.addResourceHandler("/sketchImgs/*").addResourceLocations("file:"+url);
//        super.addResourceHandlers(registry);
//    }
}