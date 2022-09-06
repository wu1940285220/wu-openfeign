package com.nightmare.openfeign.controller;

import com.nightmare.openfeign.service.OpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: WuChang
 * @Description:
 * @Date: Created in  2022-08-22 10:05 AM
 * @Modified By:
 */
@RestController
@RequestMapping(value="/custom/base")
@Slf4j
public class BaseController {

    @Autowired
    OpenFeignService openFeignService;

    @GetMapping(value ="/queryString")
    @ResponseBody
    public String queryString(){
        String str = openFeignService.queryFeginString();
        log.info(str);
        return str;
    }

    @GetMapping(value ="/queryFeginString")
    @ResponseBody
    public String queryFeginString(HttpServletRequest request){
        String token = request.getHeader("token");
        if(token==null || "".equals(token)){
            return "请求头信息为空!";
        }
        return "queryFeginString:token:"+token;
    }
}
