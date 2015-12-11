/**
* TODO
* @Project: lmframework
* @Title: Tutorials.java
* @Package com.lmstudio.component.javase
* @author jason.liu
* @Date 2015年10月14日 下午3:43:45
* @Copyright
* @Version 
*/
package com.lmstudio.component.javase;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.lmstudio.component.javase.fusionchartsfree.Graph;
import com.lmstudio.component.javase.fusionchartsfree.Graph.Categories;
import com.lmstudio.component.javase.fusionchartsfree.Graph.Category;

/**
 * TODO
 * 
 * @ClassName: Tutorials
 * @author json.liu
 */
public class Tutorials {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		jaxbUse();
	}

	/**
	 * jaxb2.0 成为javase6的一部分，使用时需要jdk6的jar包 TODO
	 * reference:file:///F:/docs/java/tutorial/tutorial/jaxb/intro/index.html
	 * @Title: jaxbUse
	 */
	public static void jaxbUse() {
		Graph graph = new Graph();
		graph.setCaption("Cumulative Sales");
		graph.setxAxisName("Products");
		graph.setyAxisName("Sales");

		Category category1 = new Category();
		category1.setName("Product A");
		Category category2 = new Category();
		category2.setName("Product B");

		Categories categories = new Categories();
		List<Category> list = new ArrayList<Category>();
		list.add(category1);
		list.add(category2);
		categories.setCategories(list);

		graph.setCategories(categories);

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Graph.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Writer writer = new StringWriter();
			marshaller.marshal(graph, writer);
			
			System.out.println(writer.toString());
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
