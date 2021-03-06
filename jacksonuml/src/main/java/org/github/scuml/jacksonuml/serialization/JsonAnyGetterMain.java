package org.github.scuml.jacksonuml.serialization;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * BeanSerializerBase
 * for (final int len = props.length; i < len; ++i) {
 *                 BeanPropertyWriter prop = props[i];
 *                 if (prop != null) { // can have nulls in filtered list
 *                     prop.serializeAsField(bean, gen, provider);
 *                 }
 *             }
 *             if (_anyGetterWriter != null) {
 *                 _anyGetterWriter.getAndSerialize(bean, gen, provider);
 *             }
 *
 *  first serialize all "normal" properties
 *  then anyGetter properties
 *
 * AnyGetterWriter (ln62)
 * _mapSerializer.serializeFields((Map<?,?>) value, gen, provider);
 *
 * -->MapSerializer.serializeFields
 *
 *
 * - How is it different with keyserializer and other serializers?
 *
 */
public class JsonAnyGetterMain {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>() {{
            put("firstProp", "firstVal");
            put("secondProp", "secondVal");
        }};

        MyBean bean = new MyBean("jsonAnyGetterBean", "admin", map);

        String s = new ObjectMapper().writeValueAsString(bean);
        System.out.println(s);
    }

    private static class MyBean {
        @JsonProperty
        private String name;

        private String myrole;
        private Map<String, String> properties;

        public MyBean(String name, String myrole, Map<String, String> properties) {
            this.name = name;
            this.myrole = myrole;
            this.properties = properties;
        }

        @JsonGetter("role")
        public String getMyrole() {
            return myrole;
        }

        @JsonAnyGetter
        public Map<String, String> getProperties() {
            return properties;
        }
    }
}
