package is.hi.hbv601g.quizlet;

import java.util.Arrays;

public class QuizModel {

    private int id;
    private String quizName;
    private String quizQuestion;
    private String quizAnswer;
    private String quizWrongAnswerOne;
    private String quizWrongAnswerTwo;
    private String quizWrongAnswerThree;
    private String quizGenre;
    private String quizImageURL;


    public QuizModel(int id, String quizName, String quizQuestion, String quizAnswer, String quizWrongAnswerOne, String quizWrongAnswerTwo, String quizWrongAnswerThree, String quizGenre, String quizImageURL) {
        this.id = id;
        this.quizName = quizName;
        this.quizQuestion = quizQuestion;
        this.quizAnswer = quizAnswer;
        this.quizWrongAnswerOne = quizWrongAnswerOne;
        this.quizWrongAnswerTwo = quizWrongAnswerTwo;
        this.quizWrongAnswerThree = quizWrongAnswerThree;
        this.quizGenre = quizGenre;
        this.quizImageURL = quizImageURL;
    }

    public QuizModel() {

    }


    @Override
    public String toString() {
        return "QuizModel{" +
                "id=" + id +
                ", quizName='" + quizName + '\'' +
                ", quizQuestion='" + quizQuestion + '\'' +
                ", quizAnswer='" + quizAnswer + '\'' +
                ", quizWrongAnswerOne='" + quizWrongAnswerOne + '\'' +
                ", quizWrongAnswerTwo='" + quizWrongAnswerTwo + '\'' +
                ", quizWrongAnswerThree='" + quizWrongAnswerThree + '\'' +
                ", quizGenre='" + quizGenre + '\'' +
                ", quizImageURL='" + quizImageURL + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(String quizQuestion) {
        this.quizQuestion = quizQuestion;
    }

    public String getQuizAnswer() {
        return quizAnswer;
    }

    public void setQuizAnswer(String quizAnswer) {
        this.quizAnswer = quizAnswer;
    }

    public String getQuizWrongAnswerOne() {
        return quizWrongAnswerOne;
    }

    public void setQuizWrongAnswerOne(String quizWrongAnswerOne) {
        this.quizWrongAnswerOne = quizWrongAnswerOne;
    }

    public String getQuizWrongAnswerTwo() {
        return quizWrongAnswerTwo;
    }

    public void setQuizWrongAnswerTwo(String quizWrongAnswerTwo) {
        this.quizWrongAnswerTwo = quizWrongAnswerTwo;
    }

    public String getQuizWrongAnswerThree() {
        return quizWrongAnswerThree;
    }

    public void setQuizWrongAnswerThree(String quizWrongAnswerThree) {
        this.quizWrongAnswerThree = quizWrongAnswerThree;
    }

    public String getQuizGenre() {
        return quizGenre;
    }

    public void setQuizGenre(String quizGenre) {
        this.quizGenre = quizGenre;
    }

    public String getQuizImageURL() {
        return quizImageURL;
    }

    public void setQuizImageURL(String quizImageURL) {
        this.quizImageURL = quizImageURL;
    }
}
