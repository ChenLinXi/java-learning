package com.jason.domain;

/**
 * Created by zhaoshang on 2017/7/18.
 */
public class Score {

    public Integer getApprovedCount() {
        return approvedCount;
    }

    public Integer getRejectedCount() {
        return rejectedCount;
    }

    private Integer approvedCount = 0;
    private Integer rejectedCount = 0;

    public void addScore(int result) {
        if (result == 1) {
            approvedCount++;
        } else if (result == -1) {
            rejectedCount++;
        }
    }

    public void addCombination(Combination combination) {
        CombinationResult result = combination.getResult();
        switch (result) {
            case REJECT:
                rejectedCount++;
                return;
            case APPROVE:
                approvedCount++;
                return;
            default:
                return;
        }
    }

    public double getScore() {
//        return approvedCount-rejectedCount;
        return (double) approvedCount / (approvedCount + rejectedCount);
    }

    @Override
    public String toString() {
        return approvedCount +
            "," + rejectedCount + "," + getScore();
    }
}
