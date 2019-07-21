package org.github.scuml.jacksonuml.deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;

public class JacksonInjectMain {

    public static void main(String[] args) throws IOException {
        String json = "{\"name\":\"My bean\"}";

        InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);
        BeanWithInject bean = new ObjectMapper()
                .reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);
        System.out.println(bean);
    }
    public static class BeanWithInject {
        @JacksonInject
        public int id;
        public String name;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        }
    }
}
