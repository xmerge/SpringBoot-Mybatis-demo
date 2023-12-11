package com.example.demo.config;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.alibaba.fastjson2.support.spring.http.converter.FastJsonHttpMessageConverter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xmerge
 */
@Configuration
public class FastjsonConfig implements WebMvcConfigurer {
    /**
     * 配置fastjson输出格式
     **/
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 1. 配置fastjson
        FastJsonConfig config = getFastJsonConfig();

        // 2. 添加fastjson转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();

        // 3. 添加支持的媒体类型
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);

        converter.setSupportedMediaTypes(supportedMediaTypes);

        //4 将convert添加到converters
        converter.setFastJsonConfig(config);
        converters.add(0,converter);
    }

    private static FastJsonConfig getFastJsonConfig() {
        FastJsonConfig config = new FastJsonConfig();

        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        config.setCharset(StandardCharsets.UTF_8);
        config.setWriterFeatures(
                JSONWriter.Feature.WriteNullListAsEmpty,
                //json格式化
                JSONWriter.Feature.PrettyFormat,
                //输出map中value为null的数据
                JSONWriter.Feature.WriteMapNullValue,
                //输出boolean 为 false
                JSONWriter.Feature.WriteNullBooleanAsFalse,
                //输出list 为 []
                JSONWriter.Feature.WriteNullListAsEmpty,
                //输出number 为 0
                JSONWriter.Feature.WriteNullNumberAsZero,
                //输出字符串 为 ""
                JSONWriter.Feature.WriteNullStringAsEmpty,
                //对map进行排序
                JSONWriter.Feature.MapSortField
        );
        return config;
    }
}
