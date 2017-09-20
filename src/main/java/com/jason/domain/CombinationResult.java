package com.jason.domain;

public enum CombinationResult {
    APPROVE("A", "通过"), REJECT("R", "拒绝"), PENDING("P", "待确认");
    private String code;
    private String desc;

    CombinationResult(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static CombinationResult getByCode(String code) {
        for (CombinationResult combinationResult : values()) {
            if (combinationResult.getCode().equals(code)) {
                return combinationResult;
            }
        }
        return null;
    }
}
