package pl.coderslab.testrepos.java.exam1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class Main4Test {
	public static Class clazz;

	@Before
	public void setData() {
		String input = "3";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}

	@Test
	public void given4_whenExecute_thenSizeEquals3() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = clazz.getDeclaredMethod("returnTab");
		method.setAccessible(true);
		int[] result = (int[]) method.invoke(null);
		assertEquals(3, result.length);

	}

	@Test
	public void given4_whenExecute_thenArrayNotContain0() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method method = clazz.getDeclaredMethod("returnTab");
		method.setAccessible(true);
		int[] result = (int[]) method.invoke(null);
		System.out.println(Arrays.toString(result));
		Integer[] what = Arrays.stream(result).boxed().toArray(Integer[]::new);
		assertThat(what, not(hasItemInArray(0)));
	}

}
