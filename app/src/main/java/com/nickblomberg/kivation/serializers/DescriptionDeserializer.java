package com.nickblomberg.kivation.serializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.nickblomberg.kivation.models.Description;

import java.lang.reflect.Type;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

public class DescriptionDeserializer implements JsonDeserializer<Description> {
    @Override
    public Description deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject().getAsJsonObject("texts");

        String value = "";

        if (object != null) {
            value = object.get("en").getAsString();
        }

        Description description = new Description();
        description.setDescription(value);

        return description;
    }
}
