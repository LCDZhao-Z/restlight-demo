package test.controller;

import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.CookieValue;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.GetMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RequestMapping;
import esa.restlight.spring.shaded.org.springframework.web.bind.annotation.RestController;
import io.esastack.commons.net.http.Cookie;

import java.util.Set;

@RestController
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping("cookie")
    public String cookie(@CookieValue Cookie cookie) {
        System.out.println(cookie.value());
        return cookie.toString();
    }

    @GetMapping("cookies")
    public String cookies(@CookieValue Set<Cookie> cookies) {
        cookies.forEach((cookie -> System.out.println(cookie.value())));
        return cookies.toString();
    }

    @GetMapping("requiredCookieValue")
    public String requiredCookieValue(@CookieValue("cookieValue") Integer cookieValue) {
        return cookieValue.toString();
    }

    @GetMapping("unRequiredCookieValue")
    public String unRequiredCookieValue(@CookieValue(value = "cookieValue", required = false) Integer cookieValue) {
        return cookieValue.toString();
    }

    @GetMapping("cookieValueWithDefault")
    public String cookieValue(@CookieValue(value = "cookieValue", defaultValue = "8888") Integer cookieValue) {
        return cookieValue.toString();
    }

    @GetMapping("unRequiredCookieValueWithDefault")
    public String unRequiredCookieValueWithDefault(@CookieValue(value = "cookieValue", defaultValue = "8888", required = false) Integer cookieValue) {
        return cookieValue.toString();
    }

}
