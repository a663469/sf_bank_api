package org.example.bank.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONGetValueByKey {
    public static String getValueByKeyInJSONArray(String jsonArrayStr, String key) {
        String value = "";
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        for (int idx = 0; idx < jsonArray.length(); idx++) {
            JSONObject jsonObj = jsonArray.getJSONObject(idx);
            value = jsonObj.optString(key);
        }
        return value;
    }
}
