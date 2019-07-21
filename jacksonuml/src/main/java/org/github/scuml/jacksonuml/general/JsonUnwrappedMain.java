package org.github.scuml.jacksonuml.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUnwrappedMain {

    public static void main(String[] args) throws JsonProcessingException {
        Name name = new Name("John", "Doe");
        UnwrappedUser user = new UnwrappedUser(1, name);

        String result = new ObjectMapper().writeValueAsString(user);

        System.out.println(result);
    }

    public static class UnwrappedUser {
        public int id;

        @JsonUnwrapped
        public Name name;

        public UnwrappedUser(int id, Name name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Name {
        public String firstName;
        public String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
