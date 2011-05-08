package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class NumberDefinition implements SyntaxDefinition {
	public DefinitionMatcher newMatcher() {
		return new Matcher();
	}

	protected class Matcher extends AbstractDefinitionMatcher {
		public boolean consumeChar(final int c)
				throws InapplicableDefinitionException {
			final boolean digit = Character.isDigit(c);
			if (!digit && text.length() == 0) {
				throw new InapplicableDefinitionException();
			}
			return digit && super.consumeChar(c);
		}
	}
}
