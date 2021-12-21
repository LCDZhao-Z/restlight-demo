package test.controller;

import io.esastack.commons.net.http.Cookie;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@Path("/cookie")
public class CookieController {


    @GET
    @Path("/cookie")
    public String cookie(@CookieParam("cookie") Cookie cookie) {
        System.out.println(cookie.value());
        return cookie.toString();
    }

    @GET
    @Path("/cookies")
    public String cookies(@CookieParam("cookies") Set<Cookie> cookies) {
        cookies.forEach((cookie -> System.out.println(cookie.value())));
        return cookies.toString();
    }

    @GET
    @Path("/unRequiredCookieValue")
    public String unRequiredCookieValue(@CookieParam("cookieValue") Integer cookieValue) {
        return cookieValue.toString();
    }

    @GET
    @Path("/cookieValueWithDefault")
    public String cookieValue(@CookieParam("cookieValue") @DefaultValue("8888") Integer cookieValue) {
        return cookieValue.toString();
    }

}
