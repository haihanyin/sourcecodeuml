package org.github.scuml.jacksonuml.serialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class SerializerMain {

    public static void main(String[] args) throws JsonProcessingException {
        MyBean myBean = new MyBean();
        myBean.setName("nameOfMyBean");
        myBean.setDate(new Date());
        String s = new ObjectMapper().writeValueAsString(myBean);
        System.out.println(s);
    }

    private static class MyBean {
        private String name;
        @JsonSerialize(using = CustomDateSerializer.class)
        private Date date;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }

    private static class CustomDateSerializer extends StdSerializer<Date> {

        private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        protected CustomDateSerializer() {
            super(Date.class);
        }

        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeString(sdf.format(value));
        }
    }
}
