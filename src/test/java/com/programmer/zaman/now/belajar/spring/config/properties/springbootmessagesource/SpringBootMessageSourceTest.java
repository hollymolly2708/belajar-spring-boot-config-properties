package com.programmer.zaman.now.belajar.spring.config.properties.springbootmessagesource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
public class SpringBootMessageSourceTest {
    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void testHelloFiqri() {
        Assertions.assertEquals("Hello Fiqri", sampleSource.helloFiqri(Locale.ENGLISH));
        Assertions.assertEquals("Halo Fiqri", sampleSource.helloFiqri(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestApplication {
        @Component
        public static class SampleSource implements MessageSourceAware {
            private MessageSource messageSource;

            @Override
            public void setMessageSource(MessageSource messageSource) {
                this.messageSource = messageSource;
            }

            public String helloFiqri(Locale locale) {
                String message = messageSource.getMessage("hello", new Object[]{"Fiqri"}, locale);
                return message;
            }
        }

    }
}
