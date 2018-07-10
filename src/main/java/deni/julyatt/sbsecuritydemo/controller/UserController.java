package deni.julyatt.sbsecuritydemo.controller;

import deni.julyatt.sbsecuritydemo.util.JSONResult;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping("/")
    public Map<String, String> home() {
        Map<String,String> map = new HashMap<>();
        map.put("content","hello");
        return map;
    }

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public String hello() throws JSONException {
        ArrayList<String> user = new ArrayList<String>(){{add("hello");}};
        return JSONResult.fillResultString(0,"",user);
    }

    @GetMapping(value = "/world",produces = "application/json;charset=UTF-8")
    public String world() throws JSONException {
        ArrayList<String> users = new ArrayList<String>(){{add("world");}};
        return JSONResult.fillResultString(0, "", users);

    }
}
