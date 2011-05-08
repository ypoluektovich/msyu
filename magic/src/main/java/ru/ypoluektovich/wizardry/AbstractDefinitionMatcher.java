package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class AbstractDefinitionMatcher implements DefinitionMatcher {
	protected final StringBuilder text = new StringBuilder();

	public boolean consumeChar(final int c)
			throws InapplicableDefinitionException {
		text.appendCodePoint(c);
		return true;
	}

	public final String getMatchedText() {
		return text.toString();
	}
}
