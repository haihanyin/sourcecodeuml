package org.github.scuml.jacksonuml.afterburner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

public class AbJsonPropertyMain {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new AfterburnerModule());

        MyBean bean = new MyBean(1, "My bean");
        String result1 = mapper.writeValueAsString(bean);
        System.out.println(result1);
    }

    public static class MyBean {
        private int id;
        private String name;

        public MyBean(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @JsonProperty("thename")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("thename")
        public String getName() {
            return name;
        }
    }
}
