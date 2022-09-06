package com.nightmare.openfeign.service;

import com.nightmare.openfeign.config.openfeign.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: WuChang
 * @Description:
 * @Date: Created in  2022-09-05 11:11 PM
 * @Modified By:
 */
@FeignClient(
        name = "wuCommon" ,
        url = "localhost:8080" ,
        configuration = FeignConfiguration.class
)
@Component
public interface OpenFeignService {

    @GetMapping(value ="/custom/base/queryFeginString")
    @ResponseBody
    String queryFeginString();
}
