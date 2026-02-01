/*
 * @ (#) QuizJsonMapper        1.0     2/1/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package iuh.fit.mapper;

import iuh.fit.entity.Question;
import iuh.fit.entity.Quiz;
import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

import java.io.StringWriter;
import java.util.List;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 2/1/2026  7:27 AM
 */
public class QuizJsonMapper {
    public String toJson(Quiz quiz){
        try(
                StringWriter writer = new StringWriter();
                JsonGenerator gen = JsonUtil.createGenerator(writer);
                ){
            gen.writeStartObject()
                    .write("quiz_id", quiz.getQuizId())
                    .write("name", quiz.getName())
                    .write("score", quiz.getScore());
                    toJson(gen, quiz.getQuestions());
                    categoryToJson(gen, quiz.getCategory());
            gen.writeEnd();

            gen.flush();
            return writer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static void toJson(JsonGenerator gen, List<Question> questions){
        gen.writeKey("questions");
        gen.writeStartArray();
        for (Question question: questions){
            gen.writeStartObject()
                    .write("question_id", question.getQuestionId())
                    .write("text", question.getText())
                    .write("correct_answer", question.getCorrectAnswer());
            gen.writeKey("options");
            gen.writeStartArray();
            for (String option: question.getOptions()) {
                gen.write(option);
            }
            gen.writeEnd();
            gen.writeEnd();
        }
        gen.writeEnd();
    }
    private static void categoryToJson(JsonGenerator gen, iuh.fit.entity.Category category){
        gen.writeKey("category");
        gen.writeStartObject()
                .write("category_id", category.getCategoryId())
                .write("name", category.getName())
                .writeEnd();
    }
}

