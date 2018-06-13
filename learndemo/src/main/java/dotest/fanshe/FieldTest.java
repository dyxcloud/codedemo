package dotest.fanshe;

import java.lang.reflect.Field;

public class FieldTest {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.fanshe.goOne");
		Object obj = clazz.newInstance();
		
		Field field = clazz.getField("name");
		field.set(obj, "你好");
		
		Object object = field.get(obj);
		System.out.println(object);
		System.out.println(obj);
		
	}
}

class goOne{
	public static String name="jack";

	@Override
	public String toString() {
		return "goOne [name="+name+"]";
	}
	
	
}