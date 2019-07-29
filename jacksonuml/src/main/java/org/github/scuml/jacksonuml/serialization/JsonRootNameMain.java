package org.github.scuml.jacksonuml.serialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 *  - How the rootname is found?
 *  DefaultSerializerProvider
 *   if (_config.isEnabled(SerializationFeature.WRAP_ROOT_VALUE)) {
 *                 _serialize(gen, value, ser, _config.findRootName(cls));
 *                 return;
 *             }
 *
 * - How the bean is serialized with the rootName?
 *  DefaultSerializerProvider
 *  gen.writeStartObject();
 *             gen.writeFieldName(rootName.simpleAsEncoded(_config));
 *             ser.serialize(value, gen, this);
 *             gen.writeEndObject();
 */
public class JsonRootNameMain {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String hello = objectMapper.writeValueAsString(new UserWithRoot(123, "hello"));
        System.out.println(hello);
    }
    @JsonRootName(value = "user")
    public static class UserWithRoot {
        public int id;
        public String name;

        public UserWithRoot(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
