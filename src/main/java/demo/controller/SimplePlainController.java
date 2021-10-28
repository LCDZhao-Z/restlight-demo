package demo.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

/**
 * HttpClientController
 *
 * @author duanwei
 * @date 2020/10/14 19:59
 */
@Controller
@RequestMapping("/")
public class SimplePlainController {

    @RequestMapping("/12345")
    @ResponseBody
    public String list() {
        return "ABC";
    }

}
