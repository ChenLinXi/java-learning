package com.jason.domain;


import java.util.List;

/**
 * Created by zhaoshang on 2017/7/21.
 */
public class Question {

    private Integer seq;
    private Long projectId;
    private String code;
    private String content;
    private List<Option> optionList;

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

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Question question = (Question) o;

        if (!projectId.equals(question.projectId)) {
            return false;
        }
        return seq.equals(question.seq);
    }

    @Override
    public int hashCode() {
        int result = seq.hashCode();
        result = 31 * result + projectId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "seq=" + seq +
                ", projectId=" + projectId +
                ", code='" + code + '\'' +
                ", content='" + content + '\'' +
                ", optionList=" + optionList +
                '}';
    }


//    public String getOptionsStr() {
//        if (CollectionUtils.isEmpty(optionList)) {
//            return "";
//        }
//        List<String> collect = optionList.stream().map(option -> option.getContent()).collect(Collectors.toList());
//        return Joiner.on(",").skipNulls().join(collect);
//    }
}
