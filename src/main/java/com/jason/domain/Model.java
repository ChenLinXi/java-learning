package com.jason.domain;

import java.util.Date;

/**
 * Created by zhaoshang on 2017/7/12.
 */
public class Model {

    private Long id;

    private Long projectId;

    private Long userId;

    private String modelName;

    private Integer qtySum;

    private Integer qtyApproved;

    private Integer qtyRejected;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    private Date gmtUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Integer getQtySum() {
        return qtySum;
    }

    public void setQtySum(Integer qtySum) {
        this.qtySum = qtySum;
    }

    public Integer getQtyApproved() {
        return qtyApproved;
    }

    public void setQtyApproved(Integer qtyApproved) {
        this.qtyApproved = qtyApproved;
    }

    public Integer getQtyRejected() {
        return qtyRejected;
    }

    public void setQtyRejected(Integer qtyRejected) {
        this.qtyRejected = qtyRejected;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }


    public Integer getQtyPending() {
        return qtySum - qtyApproved - qtyRejected;
    }


    @Override
    public String toString() {
        return "Model{" +
            "id=" + id +
            ", projectId=" + projectId +
            ", userId=" + userId +
            ", modelName='" + modelName + '\'' +
            ", qtySum=" + qtySum +
            ", qtyApproved=" + qtyApproved +
            ", qtyRejected=" + qtyRejected +
            ", gmtCreate=" + gmtCreate +
            ", gmtUpdate=" + gmtUpdate +
            '}';
    }
}
