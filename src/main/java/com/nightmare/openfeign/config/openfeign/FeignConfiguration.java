package com.nightmare.openfeign.config.openfeign;

import feign.Request;
import feign.RequestInterceptor;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: WuChang
 * @Description:
 * @Date: Created in  2022-09-06 8:54 AM
 * @Modified By:
 */
@Configuration
public class FeignConfiguration {

    @Value("${feign.client.config.default.connectTimeout:50000}")
    private int connectTimeout;

    @Value("${feign.client.config.default.readTimeout:20000}")
    private int readTimeout;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, readTimeout);
    }

    // new一个form编码器，实现支持form表单提交
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    @Scope("prototype")
    public Encoder feignFormEncoder() {
        Encoder encoder = new FormEncoder(new SpringEncoder(this.messageConverters));
        return encoder;
    }

    // 请求头处理
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignRequestInterceptor();
    }
}

