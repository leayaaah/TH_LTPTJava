package iuh.fit;

import iuh.fit.entity.Category;
import iuh.fit.entity.Question;
import iuh.fit.entity.Quiz;
import iuh.fit.mapper.QuizJsonMapper;
import iuh.fit.mapper.StreamingAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test QuizJsonMapper
//        List<Question> question = new ArrayList<>();
//        question.add(new Question("Q001", "What is Java?", List.of("A programming language", "A coffee", "An island"), "A programming language"));
//        Quiz quiz = new Quiz("QZ001", "Java Basics Quiz", 100, question, new Category("C001", "Programming"));
//        QuizJsonMapper quizJsonMapper = new QuizJsonMapper();
//        String quizJson = quizJsonMapper.toJson(quiz);
//        System.out.println(quizJson);


        //test Parser
        File file = new File("json/quizzes.json");
        Quiz quiz = StreamingAPI.readFromFile(file);

        System.out.println(quiz);
    }
}