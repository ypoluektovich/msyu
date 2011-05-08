package ru.ypoluektovich.wizardry;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanus Poluektovich (ypoluektovich@gmail.com)
 */
public class SequenceDefinition implements SyntaxDefinition {
	private final List<SyntaxDefinition> sequence;

	public SequenceDefinition(@NotNull final List<SyntaxDefinition> sequence)
			throws IncorrectDefinitionException {
		if (sequence.size() == 0) {
			throw new IncorrectDefinitionException("Empty definition sequence");
		}
		this.sequence = sequence;
	}

	@Override
	public DefinitionMatcher newMatcher() {
		return new Matcher();
	}

	private class Matcher extends AbstractDefinitionMatcher {
		private final int maxMatcherCount = sequence.size() * 2 - 1;

		private final List<DefinitionMatcher> matchers =
				new ArrayList<DefinitionMatcher>(maxMatcherCount);

		{
			matchers.add(sequence.get(0).newMatcher());
		}

		@Override
		protected boolean checkConsume(final int c, final int pos) throws InapplicableDefinitionException {
			while (matchers.size() <= maxMatcherCount) {
				final DefinitionMatcher matcher = matchers.get(matchers.size() - 1);
				if (matcher.feedChar(c, pos)) {
					return true;
				}
				final int currentSize = matchers.size();
				if (currentSize == maxMatcherCount) {
					break;
				}
				matchers.add(
						(currentSize % 2 == 1) ?
								new WhitespaceMatcher() :
								sequence.get(currentSize / 2).newMatcher()
				);
			}
			return false;
		}
	}
}
