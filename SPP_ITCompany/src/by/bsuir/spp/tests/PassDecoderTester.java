package by.bsuir.spp.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.service.PassDecoder;

public class PassDecoderTester {
	
	private PassDecoder passDecoder;
	
	@Before
	public void initPassDecoder() {
		passDecoder = new PassDecoder();
	}
	
	@Test
	public void testPassDecoder() {
		String passhash = "lydq";
		String expected = "ivan";
		String actual = passDecoder.decode(passhash);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassDecoder2() {
		String passhash = "4567";
		String expected = "1234";
		String actual = passDecoder.decode(passhash);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassDecoder3() {
		String passhash = "דהו";
		String expected = "אבג";
		String actual = passDecoder.decode(passhash);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassDecoder4() {
		String passhash = "abc";
		String expected = "xyz";
		String actual = passDecoder.decode(passhash);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassDecoder5() {
		String passhash = "123";
		String expected = "890";
		String actual = passDecoder.decode(passhash);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassDecoder6() {
		String passhash = "123";
		String expected = "891";
		String actual = passDecoder.decode(passhash);
		assertEquals(actual,expected);
	}
}
