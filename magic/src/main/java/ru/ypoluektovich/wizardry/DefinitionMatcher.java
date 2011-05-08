package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public interface DefinitionMatcher {
	boolean consumeChar(final int c) throws InapplicableDefinitionException;
	String getMatchedText();
}
