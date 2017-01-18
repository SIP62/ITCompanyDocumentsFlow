package by.bsuir.spp.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import by.bsuir.spp.service.PassScrambler;

public class PassScramblerTester {

private PassScrambler passScrambler;
	
	@Before
	public void initPassScrambler() {
		passScrambler = new PassScrambler();
	}
	
	@Test
	public void testPassScrambler() {
		String pass = "ivan";
		String expected = "lydq";
		String actual = passScrambler.scramble(pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassScrambler2() {
		String pass = "1234";
		String expected = "4567";
		String actual = passScrambler.scramble(pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassScrambler3() {
		String pass = "אבג";
		String expected = "דהו";
		String actual = passScrambler.scramble(pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassScrambler4() {
		String pass = "xyz";
		String expected = "abc";
		String actual = passScrambler.scramble(pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassScrambler5() {
		String pass = "890";
		String expected = "123";
		String actual = passScrambler.scramble(pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void testPassScrambler6() {
		String pass = "891";
		String expected = "123";
		String actual = passScrambler.scramble(pass);
		assertEquals(actual,expected);
	}
}
