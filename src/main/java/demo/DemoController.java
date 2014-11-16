package demo;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demo", produces = {Versions.V1_0_JSON, Versions.V1_0_XML})
@Api("demo")
public class DemoController {

    @RequestMapping(value = "/getSomeResource", method = RequestMethod.GET)
    @ApiOperation("Get some resource")
    public MyComplexType getSomeResource(final String param1, final String param2) {
        return new MyComplexType(param1, param2);
    }
}
