package org.github.scuml.jacksonuml.serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropOrderMain {

    public static void main(String[] args) throws Exception {
        MyBean myBean = new MyBean("myname", 123);
        String s = new ObjectMapper().writeValueAsString(myBean);
        System.out.println(s);
    }

    @JsonPropertyOrder({"value", "name"})
    private static class MyBean {
        private String name;
        private Integer value;

        public MyBean(String name, Integer value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
