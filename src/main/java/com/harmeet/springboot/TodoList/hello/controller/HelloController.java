package com.harmeet.springboot.TodoList.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello!";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer str = new StringBuffer();
        str.append("<html>");
        str.append("<body>");
        str.append("<h1>HELLO HTML</h1>");
        str.append("</body>");
        str.append("</html>");
        return str.toString();
    }
}
