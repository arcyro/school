package pl.coderslab.testrepos.java.exam1;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Main2Test {
	public static Class clazz;

	@Test
	public void givenStr_whenExecute_thenEqualsNa() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "Naucz się programować od podstaw";
		int length = 2;
		Method method = clazz.getDeclaredMethod("shorten", String.class, int.class);
		method.setAccessible(true);
		String result = (String) method.invoke(null, str, length);
		assertEquals("Na", result);
	}

}
