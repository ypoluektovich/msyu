package ru.ypoluektovich.wizardry;

import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class NumberDefinitionTest {

	private final NumberDefinition definition = new NumberDefinition();

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

	private void runMatcher(final String inputString)
			throws IOException, InapplicableDefinitionException {
		final Reader inputSource = getInputSource(inputString);
		final DefinitionMatcher matcher = definition.newMatcher();

		int c;
		do {
			c = inputSource.read();
			assertTrue((c == -1) ^ matcher.consumeChar(c));
		} while (c != -1);
		assertThat("Matcher's consumed text is wrong", matcher.getMatchedText(), is(inputString));
	}

	private static Reader getInputSource(final String inputString) {
		return new StringReader(inputString);
	}
}
