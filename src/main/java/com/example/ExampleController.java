package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class ExampleController {

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<String> postHandler(String string) {
        return HttpResponse.ok(string);
    }

}
