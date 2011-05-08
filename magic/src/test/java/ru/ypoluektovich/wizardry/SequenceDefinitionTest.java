package ru.ypoluektovich.wizardry;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class SequenceDefinitionTest extends AbstractDefinitionTest {

	public SequenceDefinitionTest() throws IncorrectDefinitionException {
		super(
				new SequenceDefinition(
						Arrays.asList(
								new NumberDefinition(),
								new PlusDefinition(),
								new NumberDefinition()
						)
				)
		);
	}

	@Test
	public void testOnePlusTwo() throws IOException, InapplicableDefinitionException {
		runMatcher("1+2");
	}

	@Test(expected = InapplicableDefinitionException.class)
	public void testJustNumber() throws IOException, InapplicableDefinitionException {
		runMatcher("123");
	}

	@Test(expected = InapplicableDefinitionException.class)
	public void testOnePlus() throws IOException, InapplicableDefinitionException {
		runMatcher("1+");
	}

	@Test(expected = InapplicableDefinitionException.class)
	public void testEmptyString() throws IOException, InapplicableDefinitionException {
		runMatcher("");
	}

	@Test
	public void testWithWhitespace() throws IOException, InapplicableDefinitionException {
		runMatcher("1  \t\n + 2");
	}
}
