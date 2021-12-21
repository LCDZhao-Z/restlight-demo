package test.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.GetMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestParam;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;
import io.esastack.restlight.core.annotation.QueryBean;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/queryBean")
public class QueryBeanController {

    @GetMapping("/human")
    public String human(@QueryBean Human human) {
        System.out.println(human);
        return human.toString();
    }
}
