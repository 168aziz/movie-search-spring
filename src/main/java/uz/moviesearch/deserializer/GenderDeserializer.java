package uz.moviesearch.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import uz.moviesearch.models.Gender;

import java.io.IOException;
import java.time.LocalTime;

public class GenderDeserializer extends JsonDeserializer<Gender> {
    @Override
    public Gender deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        int value = Integer.parseInt(jsonParser.getValueAsString());
        switch (value) {
            case 1:
                return Gender.FEMALE;
            case 2:
                return Gender.MALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}


