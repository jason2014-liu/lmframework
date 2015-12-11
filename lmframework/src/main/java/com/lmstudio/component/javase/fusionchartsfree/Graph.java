/**
* TODO
* @Project: lmframework
* @Title: Graph.java
* @Package com.lmstudio.component.javase.fusionchartsfree
* @author jason.liu
* @Date 2015年10月16日 上午10:07:42
* @Copyright
* @Version 
*/
package com.lmstudio.component.javase.fusionchartsfree;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO
 * 
 * @ClassName: Graph
 * @author json.liu
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "graph")
public class Graph {

	@XmlAttribute(name = "xAxisName")
	private String xAxisName;
	@XmlAttribute(name = "yAxisName")
	private String yAxisName;
	@XmlAttribute(name = "caption")
	private String caption;

	@XmlElement(name = "categories")
	private Categories categories;

	public String getxAxisName() {
		return xAxisName;
	}

	public void setxAxisName(String xAxisName) {
		this.xAxisName = xAxisName;
	}

	public String getyAxisName() {
		return yAxisName;
	}

	public void setyAxisName(String yAxisName) {
		this.yAxisName = yAxisName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@XmlAccessorType(value = XmlAccessType.FIELD)
	public static class Categories {

		@XmlElement(name = "category")
		private List<Category> categories;

		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Category {

		@XmlAttribute(name = "name")
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
