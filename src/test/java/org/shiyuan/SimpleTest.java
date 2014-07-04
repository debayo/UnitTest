/**
 * refer to http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html#validateMockitoUsage()
 */
package org.shiyuan;

import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {

	@Test
	public void testSimpleMockito() {

		List<String> list = mock(List.class);

		when(list.get(0)).thenReturn("helloworld");

		String result = list.get(0);

		verify(list).get(0);

		Assert.assertEquals("helloworld", result);

		when(list.get(1)).thenThrow(new RuntimeException("test excpetion"));
		try {
			list.get(1);
		} catch (RuntimeException e) {
			System.out.println("runtimeExpception:" + e);
		}
		verify(list).get(1);

		doNothing().doThrow(new RuntimeException("void exception")).when(list)
				.clear();
		list.clear();

		verify(list, times(1)).clear();
	}

	@Test
	public void testArgumentMatcher() {

		List<String> list = mock(List.class);

		when(list.get(anyInt())).thenReturn("hello", "world");

		String result = list.get(1) + list.get(2);

		verify(list, times(2)).get(anyInt());

		Assert.assertEquals("helloworld", result);

	}

	@Test
	public void testSPY() {

		List list = new LinkedList();

		List spy = spy(list);

		// optionally, you can stub out some methods:

		when(spy.size()).thenReturn(100);

		// using the spy calls *real* methods

		spy.add("one");

		spy.add("two");

		// prints "one" - the first element of a list

		System.out.println(spy.get(0));

		// size() method was stubbed - 100 is printed

		System.out.println(spy.size());

		// optionally, you can verify

		verify(spy).add("one");

		verify(spy).add("two");

	}

	@Test
	public void testUserDefinedClass() {

		List<Book> list = mock(List.class);

		when(list.get(anyInt())).thenReturn(new Book("hello", 10.0));
		Book result = list.get(2);

		verify(list, times(1)).get(anyInt());

		Assert.assertEquals("hello", result.getName());
	}

	@Test
	public void userDefinedClassTest() {

		BookUtil c = mock(BookUtil.class);
		when(c.add(anyInt(), anyInt())).thenReturn(42);

		int result = c.add(1, 2);

		verify(c, times(1)).add(anyInt(), anyInt());

		Assert.assertEquals(42, result);
	}

}
