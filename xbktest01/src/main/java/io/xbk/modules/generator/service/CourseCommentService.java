package io.xbk.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xbk.common.utils.PageUtils;
import io.xbk.modules.generator.entity.CourseCommentEntity;

import java.util.Map;

/**
 * 
 *
 * @author zmb
 * @email 1766237780@qq.com
 * @date 2021-02-03 19:57:11
 */
public interface CourseCommentService extends IService<CourseCommentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

