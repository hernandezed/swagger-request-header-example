package demo.transport;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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

    @JsonGetter
    public String value1() {
        return value1;
    }

    @JsonGetter
    public String value2() {
        return value2;
    }
}
