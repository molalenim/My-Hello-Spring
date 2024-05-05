package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

/*    //Handles request at path /hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    // lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles request of the form /hello?name=<name>

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "hello, " + name + "!!!";
    }

    // handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "hello, " + name + "!!!";
    }


    // lives /hello/form
    // displays a form with text input
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}