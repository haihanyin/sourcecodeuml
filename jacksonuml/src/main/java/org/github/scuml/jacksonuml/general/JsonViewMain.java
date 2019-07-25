package org.github.scuml.jacksonuml.general;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * View values are found in PropertyBuilder.buildWriter
 *
 * a BeanPropertyWriter is created with the View info
 *
 * BeanSerializerFactory (ln425) processViews
 *
 * In the end, FilteredBeanPropertyWriter.SingleView is created
 */
public class JsonViewMain {

    public static void main(String[] args) throws JsonProcessingException {
        Item item = new Item(2, "book", "John");

        String result = new ObjectMapper()
                .writerWithView(Public.class)
                .writeValueAsString(item);

        System.out.println(result);
    }

    public static class Public {}
    public static class Internal extends Public {}

    public static class Item {
        @JsonView(JsonViewMain.Public.class)
        public int id;

        @JsonView(JsonViewMain.Public.class)
        public String itemName;

        @JsonView(JsonViewMain.Internal.class)
        public String ownerName;

        public Item(int id, String itemName, String ownerName) {
            this.id = id;
            this.itemName = itemName;
            this.ownerName = ownerName;
        }
    }
}
