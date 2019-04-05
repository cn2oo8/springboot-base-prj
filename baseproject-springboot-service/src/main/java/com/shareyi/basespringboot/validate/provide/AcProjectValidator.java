package com.shareyi.basespringboot.validate.provide;

import com.shareyi.basespringboot.domain.test.AcProject;
import com.shareyi.basespringboot.validate.AbstractValidator;
import org.springframework.stereotype.Service;

/**
 * 测试项目 SDK 验证 类
 *
 * @author MoliCode
 * @date 2018-12-21
 */
@Service("acProjectValidator")
public class AcProjectValidator extends AbstractValidator<AcProject> {
}
