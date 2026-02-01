/*
 * @ (#) Question        1.0     2/1/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package iuh.fit.entity;

import java.util.List;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 2/1/2026  7:30 AM
 */
public class Question {
    private String questionId;
    private String text;
    private List<String> options;
    private String correctAnswer;

    public Question() {
    }


    public Question(String questionId, String text, List<String> options, String correctAnswer) {
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.questionId = questionId;
        this.text = text;
    }
    public String getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }
    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public void setText(String text) {
        this.text = text;
    }
}

