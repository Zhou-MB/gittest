package io.xbk.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.xbk.modules.generator.entity.CourseCommentEntity;
import io.xbk.modules.generator.service.CourseCommentService;
import com.xbk.common.utils.PageUtils;
import com.xbk.common.utils.R;



/**
 * 
 *
 * @author zmb
 * @email 1766237780@qq.com
 * @date 2021-02-03 19:57:11
 */
@RestController
@RequestMapping("generator/coursecomment")
public class CourseCommentController {
    @Autowired
    private CourseCommentService courseCommentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:coursecomment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseCommentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:coursecomment:info")
    public R info(@PathVariable("id") Integer id){
		CourseCommentEntity courseComment = courseCommentService.getById(id);

        return R.ok().put("courseComment", courseComment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:coursecomment:save")
    public R save(@RequestBody CourseCommentEntity courseComment){
		courseCommentService.save(courseComment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:coursecomment:update")
    public R update(@RequestBody CourseCommentEntity courseComment){
		courseCommentService.updateById(courseComment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:coursecomment:delete")
    public R delete(@RequestBody Integer[] ids){
		courseCommentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
