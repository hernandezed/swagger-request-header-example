package demo.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import demo.transport.Greeting;
import demo.transport.MyComplexType;
import demo.Versions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo", produces = {Versions.V1_0_JSON, Versions.V1_0_XML})
@Api("demo")
public class DemoController {

    @RequestMapping(value = "/getSomeResource", method = RequestMethod.GET)
    @ApiOperation("Get some resource")
    public MyComplexType getSomeResource(@RequestParam final String param1, @RequestParam final String param2) {
        return new MyComplexType(param1, param2);
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ApiOperation("Say hello")
    public Greeting sayHello(@RequestParam final String name) {
        return new Greeting("Hello " + name + "!");
    }
}
