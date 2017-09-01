package pl.coderslab.testrepos.java.exam1;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;


public class Main6Test {
	public static Class clazz;

	@Test
	public void givenCodeMyCode() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		String str = "code my code";
		String forReplace = "code";
		String replacement = "xxx";
		
		Method method = clazz.getDeclaredMethod("replaceStr", String.class, String.class, String.class);
		method.setAccessible(true);
		String result = (String) method.invoke(null, str, forReplace, replacement);
		
		assertEquals("xxx my xxx", result);

	}

}
