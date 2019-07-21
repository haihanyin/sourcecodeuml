package org.github.scuml.jacksonuml.property;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnorePropertiesMain {

    public static void main(String[] args) throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");

        String result = new ObjectMapper()
                .writeValueAsString(bean);

        System.out.println(result);
    }

    @JsonIgnoreProperties({ "id" })
    public static class BeanWithIgnore {
        public int id;
        public String name;

        public BeanWithIgnore(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
