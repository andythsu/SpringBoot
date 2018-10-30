package com.example.SpringBoot.Services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class UtilService {
    public JSONObject parseToJSON(String json) {
        try {
            return new JSONObject(json);
        } catch (JSONException e) {
            json = json.replace("\\","\\\\");
            try{
                return new JSONObject(json);
            } catch(JSONException ee){
                return null;
            }
        }
    }

    public JSONObject deepMergeJSON(JSONObject source, JSONObject target) throws JSONException {
        for (String key : JSONObject.getNames(source)) {
            Object source_value = source.get(key);
            if (!target.has(key)) {
                // new value for "key":
                target.put(key, source_value);
            } else {
                // if they are both JSONobjects, keep iterating
                if (source_value instanceof JSONObject) {
                    if (target.get(key) instanceof JSONObject) {
                        deepMergeJSON((JSONObject) source_value, (JSONObject) target.get(key));
                    } else {
                        deepMergeJSON((JSONObject) source_value, target);
                    }
                } else {
                    target.put(key, source_value);
                }
            }
        }
        return target;
    }
}
