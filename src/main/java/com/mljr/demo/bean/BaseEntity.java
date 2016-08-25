package com.mljr.demo.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 基类，实现序列化接口
 *
 */
public abstract class BaseEntity implements Serializable {

	public String toString() {
		try {
			return this.getClass().getName() + " = " + JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
		} catch (Exception e) {
			return super.toString();
		}
	}
}