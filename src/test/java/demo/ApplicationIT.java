package demo;

import demo.configuration.WebMvc;
import demo.transport.MyComplexType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Slf4j
public class ApplicationIT {

    @Value("${local.server.port}")
    int httpPort;

    @Test
    public void testGetSomResourceJson() {
        getSomeResource(Versions.V1_0_JSON);
    }

    @Test
    public void testGetSomeResourceXml() {
        getSomeResource(Versions.V1_0_XML);
    }

    @Test
    public void unauthorizedRequestShouldBeDenied() {
        final TestRestTemplate restTemplate = new TestRestTemplate();
        final ResponseEntity<String> responseEntity = restTemplate.exchange(
                uriGetSomeResourceWith("foo", "bar"),
                HttpMethod.GET, null, String.class);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.UNAUTHORIZED));
    }

    private ResponseEntity<MyComplexType> getSomeResource(final String mediaType) {
        ResponseEntity<MyComplexType> responseEntity = getSomeResource(restTemplate(), mediaType);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().getValue1(), is("foo"));
        assertThat(responseEntity.getBody().getValue2(), is("bar"));

        return responseEntity;
    }

    private ResponseEntity<MyComplexType> getSomeResource(
            final RestTemplate restTemplate,
            final String mediaType) {
        final HttpEntity<String> requestEntity = new HttpEntity<>(httpHeadersWithAccept(mediaType));

        ResponseEntity<MyComplexType> responseEntity = restTemplate.exchange(
                uriGetSomeResourceWith("foo", "bar"),
                HttpMethod.GET,
                requestEntity,
                MyComplexType.class);
        log.debug("Response: " + responseEntity);

        return responseEntity;
    }

    private HttpHeaders httpHeadersWithAccept(final String mediaType) {
        final HttpHeaders headers = new HttpHeaders();
        final List<MediaType> mediaTypes = new ArrayList<>();

        mediaTypes.add(MediaType.valueOf(mediaType));
        headers.setAccept(mediaTypes);

        return headers;
    }

    private URI uriGetSomeResourceWith(final String value1, final String value2) {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost").port(httpPort)
                .path("demo/getSomeResource")
                .queryParam("param1", value1)
                .queryParam("param2", value2)
                .build().toUri();
    }

    private RestTemplate restTemplate() {
        final RestTemplate restTemplate = new TestRestTemplate("user", "password");
        restTemplate.getMessageConverters().add(WebMvc.xStreamMessageConverter());
        return restTemplate;
    }
}
