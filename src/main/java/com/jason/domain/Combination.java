package com.jason.domain;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    private List<Integer> combination = new ArrayList<>();
    private CombinationResult result = CombinationResult.PENDING;
    private long modelId;
    private double score;

    public boolean isRefuse() {
        return result == CombinationResult.REJECT;
    }

    public boolean isApprove() {
        return result == CombinationResult.APPROVE;
    }

    public void setResult(CombinationResult result) {
        this.result = result;
    }

    public Combination() {
    }

    public Combination(List<Integer> combination) {
        for (Integer integer : combination) {
            this.addAnswer(integer);
        }
    }

    public List<Integer> getCombination() {
        return combination;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public CombinationResult getResult() {
        return result;
    }


//    public String getCombinationStr() {
//        return Joiner.on(",").join(this.combination);
//    }

    public void addAnswer(Integer answer) {
        combination.add(answer);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Combination)) {
            return false;
        }
        return this.combination.equals(((Combination) obj).combination);
    }

    @Override
    public String toString() {
        return combination.toString() + ":" + result;
    }

    public int getSum() {
        int sum = 0;
        for (Integer integer : combination) {
            sum += (integer - 1);
        }
        return sum;
    }

    public String showLine() {
        StringBuffer sb = new StringBuffer();
        for (Integer integer : combination) {
            for (int i = 0; i < 4; i++) {
                if (i == integer - 1) {
                    sb.append(isApprove() ? "a" : "r");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int leftOrRight(Combination combination) {
        int t = 0;
        for (int i = 0; i < this.combination.size(); i++) {
            int t1 = combination.getCombination().get(i) - this.combination.get(i);
            if (t1 == 0) {
                continue;
            } else {
                if (t == 0) {
                    t = t1;
                }
                if (t1 * t > 0) {
                    continue;
                } else {
                    return 0;
                }
            }
        }
        return t;
    }

    public List<ChartPoint> getChartLine() {
        ArrayList<ChartPoint> chartPoints = new ArrayList<>();
        for (int i = 0; i < this.combination.size(); i++) {
            chartPoints.add(new ChartPoint(combination.get(i) + "", i + 1 + ""));
        }
        return chartPoints;
    }

    public Integer distance(Combination comb) {
        int sum = 0;
        for (int i = 0; i < this.combination.size(); i++) {
            sum += Math.abs(this.combination.get(i) - comb.getCombination().get(i));
        }
        return sum;
    }

    public static class ChartPoint {
        private String name;
        private String value;

        public ChartPoint(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    private static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getValue(2));
    }

}
