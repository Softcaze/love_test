package com.softcaze.nicolas.testdamour;

/**
 * Created by Nicolas on 27/11/2017.
 */

public class QuestionQuizz {
    protected int num;
    protected String question;
    protected String answer1;
    protected String answer2;
    protected String answer3;

    public QuestionQuizz(int n, String q, String a1, String a2, String a3){
        this.num = n;
        this.question = q;
        this.answer1 = a1;
        this.answer2 = a2;
        this.answer3 = a3;
    }

    public int getNum() {
        return num;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
