package com.jason.domain;

import java.text.DecimalFormat;

/**
 * Created by zhaoshang on 2017/7/19.
 */
public class ScoreRejectCount {

    private CombinationResult result;
    private Double score;
    // 小于此通过率被拒绝的线的数量-被通过的数量
    private Integer rejectedCount;

    public ScoreRejectCount(Double score, int count, CombinationResult combinationResult) {
        this.score = score;
        this.rejectedCount = count;
        this.result = result;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getRejectedCount() {
        return rejectedCount;
    }

    public void setRejectedCount(Integer rejectedCount) {
        this.rejectedCount = rejectedCount;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%d", new DecimalFormat("#.##########").format(score), result, rejectedCount);
    }
}
