package org.shiyuan;

/**
 * =====================Unit Test IO==========================
 * 
 * Reader's and Writer's
 * If your input or output component uses a Reader or Writer instead of an InputStream or OutputStream, you can use the classes CharArrayReader and CharArrayWriter instead of ByteArrayInputStream and ByteArrayOutputStream.
 * You may also be able to use the StringReader and StringWriter classes in your unit tests.
 */
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;

public class MyIOUnitTest {

	@Test
	public void testRead() throws IOException {
		MyIOUnit unit = new MyIOUnit();

		byte[] data = "123,456,789,123,456,789".getBytes();

		InputStream input = new ByteArrayInputStream(data);//

		unit.read(input);

		assertEquals("123", unit.tokens.get(0));
		assertEquals("456", unit.tokens.get(1));
		assertEquals("789", unit.tokens.get(2));
		assertEquals("123", unit.tokens.get(3));
		assertEquals("456", unit.tokens.get(4));
		assertEquals("789", unit.tokens.get(5));
	}

	@Test
	public void testWrite() throws IOException {
		MyIOUnit unit = new MyIOUnit();

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		unit.tokens.add("one");
		unit.tokens.add("two");
		unit.tokens.add("three");

		unit.write(output);

		String string = new String(output.toByteArray());//
		assertEquals("one,two,three", string);
	}
}