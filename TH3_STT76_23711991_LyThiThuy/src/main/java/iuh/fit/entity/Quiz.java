/*
 * @ (#) Quiz        1.0     2/1/2026
 *
 * Copyright (c) 2026 IUH. All rights reserved.
 */

package iuh.fit.entity;

import java.util.List;

/*
 * @description:
 * @author: Thuy, Ly Thi
 * @version: 1.0
 * @created: 2/1/2026  7:25 AM
 */
public class Quiz {
    private String quizId;
    private String name;
    private int score;
    private List<Question> questions;
    private Category category;

    public Quiz() {
    }

    public Quiz(String quizId, String name, int score, List<Question> questions, Category category) {
        this.quizId = quizId;
        this.name = name;
        this.score = score;
        this.questions = questions;
        this.category = category;
    }
    public String getQuizId() {
        return quizId;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

