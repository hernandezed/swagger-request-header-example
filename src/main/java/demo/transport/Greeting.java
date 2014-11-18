package demo.transport;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Greeting {
    private final String greeting;
}
