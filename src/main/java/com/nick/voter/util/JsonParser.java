package com.nick.voter.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nick.voter.dto.Theme;
import com.nick.voter.entity.Quiz;
import com.nick.voter.util.converters.ThemeToQuiz;
import org.json.simple.JSONObject;

import java.io.IOException;

public class JsonParser {


    @Deprecated
    public static synchronized Quiz parseJsonStrToObject(String s) throws IOException {
        if (s == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        Theme theme = mapper.readValue(s, Theme.class);
        ThemeToQuiz toQuiz = new ThemeToQuiz();
        return toQuiz.convert(theme);
    }

    @Deprecated
    public static synchronized String objectToStringJson(Quiz quiz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(quiz);
    }

    public static synchronized JSONObject makeStatus(String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",message);
        return jsonObject;
    }

    public static synchronized JSONObject makeUrl(String message){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url",message);
        return jsonObject;
    }
}
