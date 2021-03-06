package io.xbk.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xbk.common.utils.PageUtils;
import io.xbk.modules.generator.entity.CourseEntity;

import java.util.Map;

/**
 * 
 *
 * @author zmb
 * @email 1766237780@qq.com
 * @date 2021-02-03 19:57:10
 */
public interface CourseService extends IService<CourseEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

