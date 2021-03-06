package ru.ypoluektovich.wizardry;

import org.junit.Test;

import java.io.IOException;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class NumberDefinitionTest extends AbstractDefinitionTest {

	public NumberDefinitionTest() {
		super(new NumberDefinition());
	}

	@Test
	public void testOneDigit() throws IOException, InapplicableDefinitionException {
		runMatcher("1");
	}

	@Test
	public void testTwoDigits() throws IOException, InapplicableDefinitionException {
		runMatcher("12");
	}

	@Test(expected = InapplicableDefinitionException.class)
	public void testEmptyString() throws IOException, InapplicableDefinitionException {
		runMatcher("");
	}

	@Test(expected = AssertionError.class)
	public void testOnePlusTwo() throws IOException, InapplicableDefinitionException {
		runMatcher("1+2");
	}
}
