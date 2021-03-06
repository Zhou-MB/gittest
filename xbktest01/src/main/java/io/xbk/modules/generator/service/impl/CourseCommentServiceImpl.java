package io.xbk.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xbk.common.utils.PageUtils;
import com.xbk.common.utils.Query;

import io.xbk.modules.generator.dao.CourseCommentDao;
import io.xbk.modules.generator.entity.CourseCommentEntity;
import io.xbk.modules.generator.service.CourseCommentService;


@Service("courseCommentService")
public class CourseCommentServiceImpl extends ServiceImpl<CourseCommentDao, CourseCommentEntity> implements CourseCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseCommentEntity> page = this.page(
                new Query<CourseCommentEntity>().getPage(params),
                new QueryWrapper<CourseCommentEntity>()
        );

        return new PageUtils(page);
    }

}