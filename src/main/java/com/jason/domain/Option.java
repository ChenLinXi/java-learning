package com.jason.domain;

/**
 * Created by zhaoshang on 2017/7/21.
 */
public class Option {

    private Integer seq;
    private String code;
    private String content;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Option{" +
            "seq=" + seq +
            ", code='" + code + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
