package com.jason.domain;

import java.util.ArrayList;
import java.util.List;

public class AnswerGroup {

    private List<Answer> answerList = new ArrayList<>();

    public AnswerGroup(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return answerList.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AnswerGroup)) {
            return false;
        }
        return ((AnswerGroup) obj).answerList.equals(this.answerList);
    }

    @Override
    public int hashCode() {
        return answerList.hashCode();
    }

    public Answer getAnswer() {
        if (answerList == null) {
            return null;
        } else {
            return answerList.get(0);
        }
    }
}
