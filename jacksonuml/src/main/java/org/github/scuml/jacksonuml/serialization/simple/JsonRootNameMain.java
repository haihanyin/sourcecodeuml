package org.github.scuml.jacksonuml.serialization.simple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRootNameMain {

    public static void main(String[] args) throws JsonProcessingException {
        String hello = new ObjectMapper().writeValueAsString(new UserWithRoot(123, "hello"));
        System.out.println(hello);
    }
    @JsonRootName(value = "user")
    private static class UserWithRoot {
        public int id;
        public String name;

        public UserWithRoot(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
