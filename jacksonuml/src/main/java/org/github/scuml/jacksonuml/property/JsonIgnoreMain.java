package org.github.scuml.jacksonuml.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreMain {

    public static void main(String[] args) throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");

        String result = new ObjectMapper()
                .writeValueAsString(bean);

        System.out.println(result);
    }

    public static class BeanWithIgnore {
        @JsonIgnore
        public int id;
        public String name;

        public BeanWithIgnore(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
