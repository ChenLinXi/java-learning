package com.jason.domain;

/**
 * Created by zhaoshang on 2017/7/27.
 */
public class AnswerScore {

    private Long modelId;

    private Integer questionSeq;

    private Integer answerSeq;

    private Integer rejectTimes;

    private Integer approveTimes;

    private Double score;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Integer getQuestionSeq() {
        return questionSeq;
    }

    public void setQuestionSeq(Integer questionSeq) {
        this.questionSeq = questionSeq;
    }

    public Integer getAnswerSeq() {
        return answerSeq;
    }

    public void setAnswerSeq(Integer answerSeq) {
        this.answerSeq = answerSeq;
    }

    public Integer getRejectTimes() {
        return rejectTimes;
    }

    public void setRejectTimes(Integer rejectTimes) {
        this.rejectTimes = rejectTimes;
    }

    public Integer getApproveTimes() {
        return approveTimes;
    }

    public void setApproveTimes(Integer approveTimes) {
        this.approveTimes = approveTimes;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "AnswerScore{" +
            "modelId=" + modelId +
            ", questionSeq=" + questionSeq +
            ", answerSeq=" + answerSeq +
            ", rejectTimes=" + rejectTimes +
            ", approveTimes=" + approveTimes +
            ", score=" + score +
            '}';
    }
}
