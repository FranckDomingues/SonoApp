package com.example.sono;


public class Question {
    private int id;
    private String question;
    private String optA;
    private String optB;
    private String optC;
    private String optD;
    private String explanation;//revisar

    public Question(){
        id=0;
        question = "";
        optA = "";
        optB = "";
        optC = "";
        optD = "";

        explanation = "";
    }

    public Question(String question, String optA, String optB, String optC, String optD, String explanation){
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.optD = optD;
        this.explanation = explanation;
    }


    public int getId() {
        return id;
    }

    public String getOptD() {
        return optD;
    }

    public String getOptC() {
        return optC;
    }

    public String getOptB() {
        return optB;
    }

    public String getOptA() {
        return optA;
    }

    public String getQuestion() {
        return question;
    }

    public String getExplanation() {
        return explanation;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public void setOptD(String optD) {
        this.optD = optD;
    }

    public void setExplanation(String explanation) { this.explanation = explanation;
    }
}
