import com.hpzc.common.util.PropertiesUtil;

public class TestUtil {

	// 获取properties文件中配置的地址
	private static String getAddress(String propertyName) {
		PropertiesUtil util = new PropertiesUtil("hessian.properties");
		String address = util.getValue(propertyName);
		return address;
	}

}
