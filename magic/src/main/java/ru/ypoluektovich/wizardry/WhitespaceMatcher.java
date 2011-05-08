package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
class WhitespaceMatcher extends AbstractDefinitionMatcher {
	@Override
	protected boolean checkConsume(final int c, final int pos) {
		return Character.isWhitespace(c);
	}
}
