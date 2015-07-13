/**
 * Project Name:ImmioSocket
 * File Name:Person.java
 * Package Name:cn.immio.com.obj
 * Date:2015年7月9日
 * Copyright (c) 2015, zhaofeng@ushayden.com All Rights Reserved.
 *
*/

package cn.immio.com.obj;

import java.io.Serializable;

/**
 * ClassName:Person ().<br/>
 * Date:     2015年7月9日  <br/>
 * @author   zhaofeng
 * @version  
 * @see 	 
 */
public class Person implements Serializable {

	private int id;
	private String name;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", password=" + password
				+ "]";
	}
}

