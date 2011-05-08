package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public interface DefinitionMatcher {
	boolean feedChar(final int c, final int pos) throws InapplicableDefinitionException;

	int getStartPosition();

	int getEndPosition();
}
