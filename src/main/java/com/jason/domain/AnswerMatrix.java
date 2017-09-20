package com.jason.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerMatrix {

    private List<List<Integer>> answerMatrix;

    public AnswerMatrix() {
    }

    /**
     * 生成答案矩阵 (问题数Question*每个问题答案数Answer)
     *
     * @param answerCountList 记录每个问题的答案个数
     */
    public AnswerMatrix(List<Integer> answerCountList) {
        this.answerMatrix = new ArrayList<>(answerCountList.size());
        for (int i = 0; i < answerCountList.size(); i++) {
            int answerCount = answerCountList.get(i);
            List<Integer> answers = new ArrayList<>();
            for (int j = 0; j < answerCount; j++) {
                answers.add(j + 1);
            }
            this.answerMatrix.add(i, answers);
        }
    }

    public List<List<Integer>> getAnswerMatrix() {
        return answerMatrix;
    }

    /**
     * 获得一个问题的所有答案数
     *
     * @param questionSeq 问题id
     * @return
     */
    public List<Integer> getAnswers(int questionSeq) {
        // 序号和数组下标一致
        return answerMatrix.get(questionSeq - 1);
    }

    public void setAnswerMatrix(List<List<Integer>> answerMatrix) {
        this.answerMatrix = answerMatrix;
    }

    /**
     * 获得被覆盖的答案
     *
     * @param combination
     * @return
     */
    public AnswerMatrix getCoveredAnswerMatrix(Combination combination) {
        // generate answerMatrix
        AnswerMatrix answerMatrix = new AnswerMatrix();
        answerMatrix.answerMatrix = new ArrayList<>(this.answerMatrix.size());

        for (int i = 0; i < this.answerMatrix.size(); i++) {
            // answers per question
            List<Integer> answers = new ArrayList<>();
            // 获得指定组合每个问题的答案序号
            Integer answerId = combination.getCombination().get(i);
            // 获得第i个问题的答案通过/拒绝覆盖数目
            for (Integer answer : this.answerMatrix.get(i)) {
                if (combination.isRefuse()) {
                    if (answer < answerId) {
                        answers.add(answer);
                    }
                } else if (combination.isApprove()) {
                    if (answer >= answerId) {
                        answers.add(answer);
                    }
                }
            }
            // and question answers that are included in Combination
            answerMatrix.answerMatrix.add(answers);
        }
        return answerMatrix;
    }

    /**
     * 递归生成所有组合
     *
     * @param questionCount 问题数目
     * @return 所有组合
     */
    public Set<Combination> recursive(int questionCount) {
        List<Integer> answers = this.getAnswers(questionCount);
        if (questionCount == 1) {
            Set<Combination> result = new HashSet<>();
            for (int i = 0; i < answers.size(); i++) {
                Combination combination = new Combination();
                combination.addAnswer(answers.get(i));
                result.add(combination);
            }
            return result;
        } else {
            int subCount = --questionCount;
            Set<Combination> combinations = recursive(subCount);
            // 加下一个数组的元素
            HashSet<Combination> result = new HashSet<>();
            for (int i = 0; i < answers.size(); i++) {
                Integer answerId = answers.get(i);
                for (Combination combination : combinations) {
                    Combination combination1 = new Combination(combination.getCombination());
                    combination1.addAnswer(answerId);
                    result.add(combination1);
                }
            }
            return result;
        }
    }

    /**
     * 生成所有组合
     *
     * @return 所有组合
     */
    public Set<Combination> generateCombinations() {
        return this.recursive(this.answerMatrix.size());
    }

    public static void main(String[] args) {
        // generate answer count list
        int questionCount = 4;
        List<Integer> answerCountList = new ArrayList<>();
        for (int i = 1; i <= questionCount; i++) {
            answerCountList.add(5);
        }
        System.out.println(answerCountList);

        // generate answerMatrix
        AnswerMatrix answerMatrix = new AnswerMatrix(answerCountList);
        System.out.println(answerMatrix.getAnswerMatrix().size());

        // generate combinations by answerMatrix and question count
        Set<Combination> combinationSet = answerMatrix.recursive(questionCount);
        System.out.println("Total combinations: " + combinationSet.size());
        for (Combination combination : combinationSet) {
            System.out.println(combination.toString());
        }
    }
}
