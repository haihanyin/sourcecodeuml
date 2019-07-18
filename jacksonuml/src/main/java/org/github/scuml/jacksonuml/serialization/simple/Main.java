package org.github.scuml.jacksonuml.serialization.simple;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {
        SimpleBean sb = new SimpleBean("Haihan", 33);
        String json = new ObjectMapper().writeValueAsString(sb);
        System.out.println(json);
    }
}
