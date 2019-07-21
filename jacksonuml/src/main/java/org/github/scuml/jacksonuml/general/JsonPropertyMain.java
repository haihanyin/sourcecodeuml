package org.github.scuml.jacksonuml.general;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPropertyMain {

    public static void main(String[] args) throws JsonProcessingException {
        MyBean bean = new MyBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        System.out.println(result);
    }
    public static class MyBean {
        public int id;
        private String name;

        public MyBean(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @JsonProperty("name")
        public void setTheName(String name) {
            this.name = name;
        }

        @JsonProperty("name")
        public String getTheName() {
            return name;
        }
    }
}
