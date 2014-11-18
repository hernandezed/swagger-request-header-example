package demo.transport;

import lombok.Value;

@Value
public class Greeting {
    private final String greeting;

    public Greeting(final String greeting) {
        this.greeting = greeting;
    }
}
