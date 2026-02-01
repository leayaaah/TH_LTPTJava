/*
 * @ (#) StreamingAPI        1.0     2/1/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package iuh.fit.mapper;

import iuh.fit.entity.Category;
import iuh.fit.entity.Question;
import iuh.fit.entity.Quiz;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import static jakarta.json.stream.JsonParser.Event.KEY_NAME;
import static jakarta.json.stream.JsonParser.Event.VALUE_STRING;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 2/1/2026  8:14 AM
 */
public class StreamingAPI {
    public static Quiz readFromFile(File jsonFile) {
        Quiz quiz = null;
        Question question = null;
        String keyName = "";
        String currentOj = "";
        try (
                JsonParser parser = Json.createParser(new FileReader(jsonFile));
        ){
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();
                switch (event) {
                    case KEY_NAME -> {
                        keyName = parser.getString();
                    }
                    case START_OBJECT -> {
                        if ("".equals(keyName)) {
                            quiz = new Quiz();
                            currentOj = "quiz";
                        } else if ("category".equals(keyName)) {
                            quiz.setCategory(new Category());
                            currentOj = "category";
                        } else if ("questions".equals(currentOj)) {
                            question = new Question();
                            currentOj = "question";

                        }
                    }
                    case START_ARRAY -> {
                        if ("questions".equals(keyName)) {
                            quiz.setQuestions(new ArrayList<>());
                            currentOj = "questions";
                        } else if ("options".equals(keyName)) {
                            question.setOptions(new ArrayList<>());
                            currentOj = "option";

                        }
                    }
                    case VALUE_STRING -> {
                        String value = parser.getString();
                        switch (keyName){
                            case "quiz_id" -> quiz.setQuizId(value);
                            case "name" -> {
                                if ("quiz".equals(currentOj))
                                    quiz.setName(value);
                                else if ("category".equals(currentOj)) {
                                    quiz.getCategory().setName(value);

                                }
                            }
                            case "question_id" -> question.setQuestionId(value);
                            case "text" -> question.setText(value);
                            case "options" -> question.getOptions().add(value);
                            case "correct_answer" -> question.setCorrectAnswer(value);
                            case "category" -> quiz.getCategory().setCategoryId(value);
                        }
                    }
                    case VALUE_NUMBER -> {
                        int score = parser.getInt();
                        quiz.setScore(score);
                    }
                    case END_ARRAY -> {
                        if("options".equals(currentOj)){
                            currentOj = "question";
                        }
                    }
                    case END_OBJECT -> {
                        if ("question".equals(currentOj)){
                            currentOj = "questions";
                            quiz.getQuestions().add(question);
                        } else if ("category".equals(currentOj)) {
                            currentOj = "quiz";

                        } else if ("quiz".equals(currentOj)) {
                            return quiz;
                        }
                    }

                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
}

