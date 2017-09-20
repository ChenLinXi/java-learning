package com.jason.domain;

import java.util.List;

/**
 * Created by zhaoshang on 2017/7/21.
 */
public class Project {

    private Long id;
    private String projectName;
    private List<Question> questionList;
    private String desciption;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "Project{" +
            "questionList=" + questionList +
            '}';
    }


    public Integer getQuestionQty() {
        return questionList == null ? 0 : questionList.size();
    }

}
