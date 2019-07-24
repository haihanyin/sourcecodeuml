package org.github.scuml.jacksonuml.general;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * - How the format is applied?
 *
 * BeanSerializerFactory registers a list of serializers for common types, including Date (ln61)
 *
 * Based on the value type, SerializerProvider.findPrimaryPropertySerializer() resolves
 * DateSerializer (which extends DateTimeSerializerBase)
 * ser = _createAndCacheUntypedSerializer(valueType);; (ln668)
 *
 * The DateTimeSerializerBase.createContextual finds the format information
 *
 * BeanWriter uses the revolved serializer to serialize the date value
 *
 */
public class JsonFormatMain {

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        Event event = new Event("party", date);

        String result = new ObjectMapper().writeValueAsString(event);

        System.out.println(result);
    }

    public static class Event {
        public String name;

        @JsonFormat(
                shape = JsonFormat.Shape.STRING,
                pattern = "dd-MM-yyyy hh:mm:ss")
        public Date eventDate;

        public Event(String name, Date eventDate) {
            this.name = name;
            this.eventDate = eventDate;
        }
    }
}
