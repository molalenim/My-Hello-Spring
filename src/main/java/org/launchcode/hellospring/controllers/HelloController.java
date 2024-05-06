package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

/*    //Handles request at path /hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/

    // lives /hello/goodbye
    @GetMapping("goodbye")

    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //lives /hello/hello
    // handles request of the form /hello?name=<name>
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name) {
        return "hello, " + name + "!!!";
    }

    // handles request of the form /hello/LaunchCode
    @GetMapping("{name}")

    public String helloWithPathParam(@PathVariable String name) {
        return "hello, " + name + "!!!";
    }

    // handles POST request from form submission
    @PostMapping("hello")
    public String helloFormSubmit(@RequestParam String name) {
        return "hello, " + name + "!!!";
    }

    // lives /hello/form
    // displays a form with text input
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='/hello/hello' method='post'>" + // submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}