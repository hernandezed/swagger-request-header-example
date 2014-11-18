package demo.transport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonCreator
    public MyComplexType(@JsonProperty("value1") final String value1, @JsonProperty("value2") final String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}
