package org.github.scuml.jacksonuml.property;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAutoDetectMain {

    public static void main(String[] args) throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(1, "My bean");

        String result = new ObjectMapper()
                .writeValueAsString(bean);

        System.out.println(result);
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class PrivateBean {
        private int id;
        private String name;

        public PrivateBean(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
