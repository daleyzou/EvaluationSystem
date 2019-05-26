/**
 * @projectName project
 * @package cc.daleyzou.common.config
 * @className cc.daleyzou.common.config.WebMvcConfig
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfig
 * @description TODO
 * @author daleyzou
 * @date 2019年05月25日 17:45
 * @version 1.0.0
 */
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            /**
             * @Description: 对文件的路径进行配置,创建一个虚拟路径/file/** ，即只要在<img src="/file/images/20180522/9aa64b2b-a558-421e-929c-537ff0aecdba.jpg" />便可以直接引用图片
             *这是图片的物理路径 "file:/+本地图片的地址"
             * @Date： Create in 14:08 2017/12/20
             *
             */
            //读取配置文件中的上传路径
            String url = "D:/Graduation/EasyPACS/tmp/workspace/sketch/";
            registry.addResourceHandler("/sketchImgs/**").addResourceLocations("file:"+url);
        }

}
