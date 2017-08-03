package com.nick.voter.util.converters;


import com.nick.voter.dto.Theme;
import com.nick.voter.entity.Quiz;
import org.springframework.core.convert.converter.Converter;

public class ThemeToQuiz implements Converter<Theme, Quiz>{
    @Override
    public Quiz convert(Theme theme) {
        Quiz quiz = new Quiz();
        quiz.setTheme(theme.getTheme());
        quiz.setVotes(0);
        return quiz;
    }
}
