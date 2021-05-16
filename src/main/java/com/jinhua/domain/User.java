package com.jinhua.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Jinhua
 */
@Repository("user")
@Data
@NoArgsConstructor
public class User {

	/**
	 * 编号
	 */
	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String pwd;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 家乡
	 */
	private String home;

	/**
	 * 备注
	 */
	private String info;

	public User(int id) {
		this.id = id;
	}

	/**
	 * 指定在对象创建后执行
	 */
	@PostConstruct
	public void init() {
		System.out.println("对象创建后");
	}

	/**
	 * 指定在对象销毁前执行
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("对象销毁前");
	}
}
