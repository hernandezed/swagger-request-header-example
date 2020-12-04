package demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "X-My-Header", required = true, paramType = "header", dataTypeClass = String.class, example = "Homer Simpson")
    )
    public String hello(@RequestHeader("X-My-Header") MyHeader myHeader) {
        return "hello";
    }

}
