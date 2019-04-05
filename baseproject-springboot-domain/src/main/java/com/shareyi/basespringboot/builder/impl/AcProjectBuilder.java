package com.shareyi.basespringboot.builder.impl;

import com.shareyi.basespringboot.builder.AbstractBuilder;
import com.shareyi.basespringboot.domain.test.AcProject;
import org.springframework.stereotype.Service;

/**
 * 测试项目 Builder 类
 *
 * @author MoliCode
 * @date 2018-12-21
 */
@Service("acProjectBuilder")
public class AcProjectBuilder extends AbstractBuilder<AcProject> {

    @Override
    public String getBizName() {
        return "测试项目";
    }

    @Override
    public Class getBizClass() {
        return AcProject.class;
    }
}
