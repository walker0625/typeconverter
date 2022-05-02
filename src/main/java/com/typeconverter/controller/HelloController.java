package com.typeconverter.controller;

import com.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    @GetMapping("/v1/test")
    public Integer test1(HttpServletRequest request) {
        String data = request.getParameter("data"); // 모두 문자로만 나옴
        Integer integer = Integer.valueOf(data);
        return integer;
    }

    @GetMapping("/v2/test")
    public String test2(@RequestParam Integer data) { // 넘어온 문자를 Integer로 형변환한 것
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort PORT = " + ipPort.getPort());
        return "ok";
    }

}
