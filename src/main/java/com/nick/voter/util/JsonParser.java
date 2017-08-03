package com.nick.voter.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nick.voter.dto.Theme;
import com.nick.voter.entity.Quiz;
import com.nick.voter.util.converters.ThemeToQuiz;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class JsonParser {


    public static synchronized Quiz parseJsonStrToObject(String s) throws IOException {
        if (s == null){
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        Theme theme = mapper.readValue(s, Theme.class);
        ThemeToQuiz toQuiz = new ThemeToQuiz();
        Quiz quiz = toQuiz.convert(theme);

        return quiz;
    }

    public static synchronized String objectToStringJson(Quiz quiz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(quiz);
        return jsonInString;
    }
}
