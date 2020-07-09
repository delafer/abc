package net.delafer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.delafer.models.Entry;

public class GenerateJSON {

    public static String asJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            String json = mapper.writeValueAsString(obj);
            return json;
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Entry[] entries = new Entry[] {
          new Entry("a", "b", "c", "google.com"),
          new Entry("x", "y", "z", "microsoft.com"),
          new Entry("s", "o", "s", "yandex.com"),
        };
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            String json = mapper.writeValueAsString(entries);
            System.out.println("ResultingJSONstring = " + json);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
