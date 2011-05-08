package ru.ypoluektovich.wizardry;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public abstract class AbstractDefinitionTest {
	protected final SyntaxDefinition definition;

	protected AbstractDefinitionTest(final SyntaxDefinition definition) {
		this.definition = definition;
	}

	protected void runMatcher(final String inputString)
			throws IOException, InapplicableDefinitionException {
		final Reader inputSource = getInputSource(inputString);
		final DefinitionMatcher matcher = definition.newMatcher();

		int c;
		int pos = 0;
		do {
			c = inputSource.read();
			assertTrue((c == -1) ^ matcher.feedChar(c, pos));
			pos++;
		} while (c != -1);
		assertThat("Match start is wrong", matcher.getStartPosition(), is(0));
		assertThat("Match end is wrong", matcher.getEndPosition(), is(inputString.length()));
	}

	private static Reader getInputSource(final String inputString) {
		return new StringReader(inputString);
	}
}
