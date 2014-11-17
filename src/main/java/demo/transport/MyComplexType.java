package demo.transport;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.Value;

@Value
@ApiModel("Some complex type")
public class MyComplexType {

    @ApiModelProperty(required = true)
    private final String value1;
    @ApiModelProperty(required = true)
    private final String value2;

    // Required for Jackson and XStream
    private MyComplexType() {
        this(null, null);
    }

    public MyComplexType(final String value1, final String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    // @JsonGetter (disable as workaround for #494 in swagger-springmvc)
    public String value1() {
        return value1;
    }

    // @JsonGetter (disable as workaround for #494 in swagger-springmvc)
    public String value2() {
        return value2;
    }
}
