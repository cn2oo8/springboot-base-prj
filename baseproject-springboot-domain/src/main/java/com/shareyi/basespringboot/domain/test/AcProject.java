package com.shareyi.basespringboot.domain.test;

import com.shareyi.basespringboot.domain.BasicDomain;

import java.io.Serializable;

/**
 * @author MoliCode
 * @date 2018-12-21 测试项目 Domain 类
 */
public class AcProject extends BasicDomain implements Serializable {

    private static final long serialVersionUID = 938825467195063542L;

    /**
     * 名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 项目key
     */
    private String projectKey;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 扩展1
     */
    private String ext1;
    /**
     * 扩展2
     */
    private String ext2;
    /**
     * 扩展3
     */
    private String ext3;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProjectKey() {
        return this.projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExt1() {
        return this.ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return this.ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return this.ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }


}
