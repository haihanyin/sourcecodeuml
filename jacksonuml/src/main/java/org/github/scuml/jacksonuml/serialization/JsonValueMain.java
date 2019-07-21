package org.github.scuml.jacksonuml.serialization;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValueMain {

    public static void main(String[] args) throws Exception {
        String s = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println(s);
    }

    private enum TypeEnumWithValue {
        TYPE1(1, "Type A"), TYPE2(2, "Type 2");

        private Integer id;
        private String name;

        // standard constructors

        TypeEnumWithValue(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @JsonValue
        public String getName() {
            return name;
        }
    }
}
