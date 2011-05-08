package ru.ypoluektovich.wizardry;

import org.junit.Test;

import java.io.IOException;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class PlusDefinitionTest extends AbstractDefinitionTest {


	public PlusDefinitionTest() {
		super(new PlusDefinition());
	}

	@Test
	public void testPlus() throws IOException, InapplicableDefinitionException {
		runMatcher("+");
	}

	@Test(expected = AssertionError.class)
	public void testTwoPluses() throws IOException, InapplicableDefinitionException {
		runMatcher("++");
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
