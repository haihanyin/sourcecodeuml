package org.github.scuml.jacksonuml.general;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * - How is a field serialized by its getter?
 *
 * Call getter by using reflection in BeanPropertyWriter.serializeAsField (ln688)
 *
 * BeanPropertyWriter originates from BeanSerializerFactory (ln368)
 * List<BeanPropertyWriter> props = findBeanProperties(prov, beanDesc, builder);
 *
 * The bean description contains all the metadata of the bean, where the property information
 * is retrieved.
 * The bean description is initialized in BeanSerializerFactory (ln135)
 * BeanDescription beanDesc = config.introspect(origType);
 *
 * origType is derived from the type of the bean class
 *
 * - How the @JsonProperty is read in serialization?
 *
 * The field name is written by BeanPropertyWriter, which is used earlier for calling the getter
 * gen.writeFieldName(_name); (ln725)
 *
 * The _name originates from a POJOPropertyBuilder, in which _name represents the string for
 * serialization and _internalName represents the actual field name
 *
 * the name value originates from POJOPropertyBuilder.findExplicitNames
 * the POJOProertyBuilder contains information about the fields, getters, setters related to
 * a property etc
 *
 * the getters are retrieved by calling
 * AnnotatedMember valueAccessor = beanDesc.findJsonValueAccessor();
 * in BasicSerializerFactory (ln346)
 * ??
 *
 * - What is the relationship between the bean serializer and its fields serializers
 *
 * BeanSerializer(ln151) write object start
 * BeanSerializerBase serializes each field in a bean
 * the found serializers for fiels are stored as attributes in BeanPropertyWriter
 * BeanSerializer(ln157) write object end
 *
 * Therefore:
 * BeanSerializer_MyBean
 * --BeanPropertyWriter
 *   --NumberSerializer$IntergerSerializer
 * --BeanPropertyWriter
 *   --StringSerializer
 */
public class JsonPropertyMain {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MyBean bean = new MyBean(1, "My bean");
        String result1 = objectMapper.writeValueAsString(bean);
        System.out.println(result1);

        MyBean bean2 = new MyBean(2, "My bean2");
        String result2 = objectMapper.writeValueAsString(bean2);
        System.out.println(result2);
    }

    public static class MyBean {
        public int id;
        private String name;

        public MyBean(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @JsonProperty("thename")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("thename")
        public String getName() {
            return name;
        }
    }
}
