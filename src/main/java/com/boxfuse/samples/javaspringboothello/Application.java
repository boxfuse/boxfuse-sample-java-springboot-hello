package com.boxfuse.samples.javaspringboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller
public class Application {
    @RequestMapping(value = "/name", produces = "text/html", method = RequestMethod.POST)
    @ResponseBody
    public String name(@RequestParam("name") String name) {
        return "<html><body><h1>Hello " + name + "</h1>Welcome to Boxfuse!</body></html>";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}