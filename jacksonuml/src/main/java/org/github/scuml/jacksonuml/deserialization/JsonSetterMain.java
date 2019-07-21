package org.github.scuml.jacksonuml.deserialization;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;

public class JsonSetterMain {

    public static void main(String[] args) throws IOException {
        String json = "{\"id\":1,\"name\":\"My bean\"}";

        MyBean bean = new ObjectMapper()
                .readerFor(MyBean.class)
                .readValue(json);

        System.out.println(bean);
    }

    public static class MyBean {
        public int id;
        private String name;

        @JsonSetter("name")
        public void setTheName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        }
    }
}
