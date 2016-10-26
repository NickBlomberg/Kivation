package com.nickblomberg.kivation.network.serializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.nickblomberg.kivation.models.Tags;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * // TODO create class javadoc
 *
 * @author Nick Blomberg
 */

public class TagsDeserializer implements JsonDeserializer<Tags> {
    @Override
    public Tags deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray array = json.getAsJsonArray();

        List<String> tags = new ArrayList<String>();
        for (int i = 0; i < array.size(); i++) {
            JsonElement tag = ((JsonObject) array.get(i)).get("name");
            tags.add(tag.getAsString());
        }

        return new Tags(tags);
    }
}
