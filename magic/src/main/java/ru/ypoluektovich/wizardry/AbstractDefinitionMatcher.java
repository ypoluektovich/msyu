package ru.ypoluektovich.wizardry;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class AbstractDefinitionMatcher implements DefinitionMatcher {
	private int startPosition = -1;
	private int endPosition = -1;

	public final boolean feedChar(final int c, final int pos)
			throws InapplicableDefinitionException {
		if (startPosition == -1) {
			startPosition = pos;
		}
		final boolean consumed = checkConsume(c, pos);
		endPosition = pos + (consumed ? 1 : 0);
		return consumed;
	}

	protected boolean checkConsume(final int c, final int pos) throws InapplicableDefinitionException {
		return true;
	}

	@Override
	public int getStartPosition() {
		return startPosition;
	}

	@Override
	public int getEndPosition() {
		return endPosition;
	}
}
