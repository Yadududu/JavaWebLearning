package com.lmj.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MyCollection {
	//สýื้
	private Object[] array;
	//list
	private List list;
	//set
	private Set set;
	//map
	private Map map;
	//properties
	private Properties prop;
	
	public Object[] getArray() {
		return array;
	}
	public void setArray(Object[] array) {
		this.array = array;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
//	@Override
//	public String toString() {
//		return "MyCollection [array=" + Arrays.toString(array) + ", list=" + list + ", set=" + set + "]";
//	}
	
	@Override
	public String toString() {
		return "MyCollection [ map=" + map + ", prop=" + prop + "]";
	}
	
}
