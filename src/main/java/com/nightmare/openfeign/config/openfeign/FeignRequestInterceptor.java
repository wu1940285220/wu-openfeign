package com.nightmare.openfeign.config.openfeign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author: WuChang
 * @Description:
 * @Date: Created in  2022-09-06 10:14 AM
 * @Modified By:
 */
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes!=null){
            String token = attributes.getRequest().getHeader("token");
            if (!StringUtils.isEmpty(token)){
                log.info("feignClient requestHeader  add token:{}",token );
                requestTemplate.header("token",token);
            }
        }
    }
}
