package maven_ssm_service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmj.mapper.ItemMapper;
import com.lmj.bean.ItemInfo;

@RunWith(SpringJUnit4ClassRunner.class)
/*@ContextConfiguration(locations = {"classpath:applicationContext_service.xml",
								"classpath:applicationContext_mapper.xml"})*/
@ContextConfiguration("classpath*:applicationContext_*.xml")
public class ItemServiceImplTest {

	@Autowired
	private ItemMapper itemMapper;
	
	@Test
	public void test() {
		List<ItemInfo> allList = itemMapper.getAllList();
		
		for(ItemInfo itemInfo:allList) {
			System.out.println("itemInfo = " + itemInfo);
		}
	}

}
