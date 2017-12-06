package com.softcaze.nicolas.testdamour;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Nicolas on 27/11/2017.
 */

public class Quizz {
    QuestionQuizz qActu;
    QuestionQuizz[] tabQuestion = new QuestionQuizz[5];

    public Quizz(Context c){
        addQuestion(c);
        this.qActu = this.tabQuestion[0];
    }

    public QuestionQuizz[] getTabQuestion() {
        return tabQuestion;
    }

    public void addQuestion(Context c){
        QuestionQuizz question1;
        QuestionQuizz question2;
        QuestionQuizz question3;
        QuestionQuizz question4;
        QuestionQuizz question5;

        question1 = new QuestionQuizz(1, c.getResources().getString(R.string.question_1), c.getResources().getString(R.string.reponse_1_1), c.getResources().getString(R.string.reponse_1_2), c.getResources().getString(R.string.reponse_1_3));
        question2 = new QuestionQuizz(2, c.getResources().getString(R.string.question_2), c.getResources().getString(R.string.reponse_2_1), c.getResources().getString(R.string.reponse_2_2), c.getResources().getString(R.string.reponse_2_3));
        question3 = new QuestionQuizz(3, c.getResources().getString(R.string.question_3), c.getResources().getString(R.string.reponse_3_1),c.getResources().getString(R.string.reponse_3_2), c.getResources().getString(R.string.reponse_3_3));
        question4 = new QuestionQuizz(4, c.getResources().getString(R.string.question_4), c.getResources().getString(R.string.reponse_4_1), c.getResources().getString(R.string.reponse_4_2), c.getResources().getString(R.string.reponse_4_3));
        question5 = new QuestionQuizz(5, c.getResources().getString(R.string.question_5), c.getResources().getString(R.string.reponse_5_1), c.getResources().getString(R.string.reponse_5_2), c.getResources().getString(R.string.reponse_5_3));

        this.tabQuestion[0] = question1;
        this.tabQuestion[1] = question2;
        this.tabQuestion[2] = question3;
        this.tabQuestion[3] = question4;
        this.tabQuestion[4] = question5;
    }

    public void setQActu(int action){ // 0 to incremente 1 to decremente
        if(action == 0){
            this.qActu = this.tabQuestion[(this.qActu.getNum() - 1) + 1];
        }
        else{
            this.qActu = this.tabQuestion[(this.qActu.getNum()) - 1 - 1];
        }
    }
}
