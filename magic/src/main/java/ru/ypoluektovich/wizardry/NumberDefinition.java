package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class NumberDefinition implements SyntaxDefinition {
	public DefinitionMatcher newMatcher() {
		return new Matcher();
	}

	private class Matcher extends AbstractDefinitionMatcher {
		@Override
		protected boolean checkConsume(final int c, final int pos) throws InapplicableDefinitionException {
			final boolean digit = Character.isDigit(c);
			if (!digit && pos == getStartPosition()) {
				throw new InapplicableDefinitionException();
			}
			return digit;
		}
	}
}
