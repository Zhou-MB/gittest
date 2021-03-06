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
 * @date 2021-02-03 19:57:11
 */
@Data
@TableName("COURSE_COMMENT")
public class CourseCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论id
	 */
	@TableId
	private Integer id;
	/**
	 * 课程id
	 */
	private Integer courseid;
	/**
	 * 用户信息
	 */
	private String nickname;
	/**
	 * 状态》 1审核通过； 0审核未通过 ； 2 待审核
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 满意度
	 */
	private String satisfaction;
	/**
	 * 点名情况
	 */
	private String countfrequency;
	/**
	 * 点名方式
	 */
	private String countway;
	/**
	 * 考试方式
	 */
	private String exam;
	/**
	 * 成绩范围
	 */
	private String grade;
	/**
	 * 评论
	 */
	private String remarks;
	/**
	 * 用户信息
	 */
	private String openid;
	/**
	 * 修改时间
	 */
	private Date updatetime;

}
