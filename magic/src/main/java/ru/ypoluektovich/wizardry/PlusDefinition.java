package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class PlusDefinition implements SyntaxDefinition {
	@Override
	public DefinitionMatcher newMatcher() {
		return new Matcher();
	}

	private class Matcher extends AbstractDefinitionMatcher {
		@Override
		protected boolean checkConsume(final int c, final int pos) throws InapplicableDefinitionException {
			if (getStartPosition() != pos) {
				return false;
			}
			if (c != '+') {
				throw new InapplicableDefinitionException();
			}
			return true;
		}
	}
}
