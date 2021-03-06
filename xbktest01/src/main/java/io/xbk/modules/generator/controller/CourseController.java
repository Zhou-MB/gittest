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

import io.xbk.modules.generator.entity.CourseEntity;
import io.xbk.modules.generator.service.CourseService;
import com.xbk.common.utils.PageUtils;
import com.xbk.common.utils.R;



/**
 * 
 *
 * @author zmb
 * @email 1766237780@qq.com
 * @date 2021-02-03 19:57:10
 */
@RestController
@RequestMapping("generator/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:course:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{courseid}")
    @RequiresPermissions("generator:course:info")
    public R info(@PathVariable("courseid") Integer courseid){
		CourseEntity course = courseService.getById(courseid);

        return R.ok().put("course", course);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:course:save")
    public R save(@RequestBody CourseEntity course){
		courseService.save(course);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:course:update")
    public R update(@RequestBody CourseEntity course){
		courseService.updateById(course);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:course:delete")
    public R delete(@RequestBody Integer[] courseids){
		courseService.removeByIds(Arrays.asList(courseids));

        return R.ok();
    }

}
