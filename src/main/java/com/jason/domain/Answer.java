package com.jason.domain;

/**
 * Created by zhaoshang on 2017/7/18.
 */
public class Answer {

    private int questionSeq;
    private int answerSeq;

    public int getQuestionSeq() {
        return questionSeq;
    }

    public void setQuestionSeq(int questionSeq) {
        this.questionSeq = questionSeq;
    }

    public int getAnswerSeq() {
        return answerSeq;
    }

    public void setAnswerSeq(int answerSeq) {
        this.answerSeq = answerSeq;
    }

    public Answer(int questionSeq, int answerSeq) {
        this.questionSeq = questionSeq;
        this.answerSeq = answerSeq;
    }

    @Override
    public String toString() {
        return questionSeq +
            "," + answerSeq;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(questionSeq + 7 * answerSeq);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Answer)) {
            return false;
        }
        Answer target = (Answer) obj;
        return target.questionSeq == this.questionSeq && target.answerSeq == this.answerSeq;
    }
}
