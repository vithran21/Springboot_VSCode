package com.learn.springbootthymeleaftasks.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping("/")
    public String getTask() {
        return "task";
    }

    @GetMapping("/otp")
    public String getOtp(ModelMap map) {
        int otp = new Random().nextInt(1000, 10000);
        map.put("otp", otp);
        return "task";
    }

    @GetMapping("/toss")
    public String getToss(ModelMap map) {
        String[] toss = { "Head", "Tail" };
        map.put("toss", toss[new Random().nextInt(0, 2)]);
        return "task";
    }

    @GetMapping("/random-color")
    public String getRandomColorBox(ModelMap map)
    {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        
        map.put("randomcolor", String.format("#%02x%02x%02x", red, green, blue));
        return "task";
    }

    @GetMapping("/wish")
    public String getWish(@RequestParam String message, @RequestParam String color, ModelMap map)
    {
        map.put("message", message);
        map.put("color", color);
        return "task";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double num1, @RequestParam double num2, 
    @RequestParam String operation, ModelMap map)
    {
        switch (operation) {
            case "add":
                map.put("result", num1+num2);
                break;
            case "sub":
                map.put("result", num1-num2);
                break;
            case "mul":
                map.put("result", num1*num2);
                break;
            case "div":
                map.put("result", num1/num2);
                break;
            default:
                break;
        }
        map.put("num1", num1);
        map.put("num2", num2);
        return "task";
    }
}
