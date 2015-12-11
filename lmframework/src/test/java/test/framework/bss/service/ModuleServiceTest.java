/**
* TODO
* @Project: lmframework
* @Title: ModuleServiceTest.java
* @Package test.framework.bss.service
* @author jason.liu
* @Date 2015年11月3日 下午3:12:50
* @Copyright
* @Version 
*/
package test.framework.bss.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* TODO
* @ClassName: ModuleServiceTest
* @author json.liu
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/root-context-test.xml"})
public class ModuleServiceTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	
	@Test
	public void testFindModulesByUser(){
	
	}

}
