package io.xbk.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author zmb
 * @email 1766237780@qq.com
 * @date 2021-02-03 19:57:10
 */
@Data
@TableName("COURSE")
public class CourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 课程id
	 */
	@TableId
	private Integer courseid;
	/**
	 * 课程名
	 */
	private String course;
	/**
	 * 是否核心 true false
	 */
	private Integer iscore;
	/**
	 * 课程类型id 1:人文科学  2:科学技术 3:社会科学
	 */
	private Integer coursetypeid;
	/**
	 * 课程类型名
	 */
	private String coursetype2;
	/**
	 * 带核心的课程类型名
	 */
	private String coursetype;
	/**
	 * 教师
	 */
	private String teacher;
	/**
	 * 状态》 1审核通过； 0审核未通过 ； 2 待审核
	 */
	private Integer status;
	/**
	 * 用户信息
	 */
	private String openid;
	/**
	 * 用户信息
	 */
	private String nickname;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}
