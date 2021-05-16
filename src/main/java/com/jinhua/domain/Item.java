package com.jinhua.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author Jinhua
 */
@Data
public class Item {
	private Integer id;
	private String name;
	private Double price;
	private Date createTime;
	private String detail;
}
