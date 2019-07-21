package org.github.scuml.jacksonuml.property;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeMain {

    public static void main(String[] args) throws JsonProcessingException {
        MyBean bean = new MyBean(1, null);

        String result = new ObjectMapper()
                .writeValueAsString(bean);

        System.out.println(result);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MyBean {
        public int id;
        public String name;

        public MyBean(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }


}
