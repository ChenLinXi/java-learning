package com.jason.domain;

import java.util.HashSet;
import java.util.Set;

public class ScoreGroup {

    private Double score;
    private Set<Combination> rejectedCombinations = new HashSet<>();
    private Set<Combination> approvedCombinations = new HashSet<>();

    public void addCombination(Combination combination) {
        if (combination.isApprove()) {
            approvedCombinations.add(combination);
        } else {
            approvedCombinations.add(combination);
        }
    }

    public Integer getCount(int result) {
        return result == 1 ? approvedCombinations.size() : rejectedCombinations.size();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Set<Combination> getRejectedCombinations() {
        return rejectedCombinations;
    }

    public void setRejectedCombinations(Set<Combination> rejectedCombinations) {
        this.rejectedCombinations = rejectedCombinations;
    }

    public Set<Combination> getApprovedCombinations() {
        return approvedCombinations;
    }

    public void setApprovedCombinations(Set<Combination> approvedCombinations) {
        this.approvedCombinations = approvedCombinations;
    }

    @Override
    public String toString() {
        return score + ":" + rejectedCombinations.size() + "," + approvedCombinations.size();
    }

}
