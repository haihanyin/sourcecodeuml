package org.github.scuml.jacksonuml.deserialization;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonAnySetterMain {

    public static void main(String[] args) throws IOException {
        String json
                = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
        ExtendableBean bean = new ObjectMapper().readerFor(ExtendableBean.class).readValue(json);
        System.out.println(bean);
    }
    public static class ExtendableBean {
        public String name;
        private Map<String, String> properties = new HashMap<>();

        @JsonAnySetter
        public void add(String key, String value) {
            properties.put(key, value);
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        }
    }
}
