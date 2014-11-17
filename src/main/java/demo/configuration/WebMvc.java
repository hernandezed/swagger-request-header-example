package demo.configuration;

import demo.Versions;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvc extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        final List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_XML);
        mediaTypes.add(MediaType.valueOf(Versions.V1_0_XML));

        final XStreamMarshaller marshaller = new XStreamMarshaller();
        // Omit package names in XML
        marshaller.getXStream().aliasPackage("", "demo.transport");
        final MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter(marshaller,
                                                                                                 marshaller);
        xmlConverter.setSupportedMediaTypes(mediaTypes);

        converters.add(xmlConverter);
    }

    @Override
    public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
}
