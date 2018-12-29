package day5;
import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class Day5Test {
	Day5 day = new Day5(new File("src\\day5\\input.txt"));

	@Test
	public void testEmptyString() {
		Assert.assertEquals("", day.removeChar("", 'C'));
	}

	@Test
	public void testUppercase() {
		Assert.assertEquals("", day.removeChar("AAA", 'A'));
	}

	@Test
	public void testLowercase() {
		Assert.assertEquals("", day.removeChar("aaa", 'A'));
	}

	@Test
	public void testBothCasesWhichAreKey() {
		Assert.assertEquals("", day.removeChar("aaA", 'A'));
	}

	@Test
	public void testDifferentKey() {
		Assert.assertEquals("a", day.removeChar("a", 'C'));
	}

	@Test
	public void testBothCasesWhichAreNotKey() {
		Assert.assertEquals("", day.removeChar("aA", 'B'));
	}

	@Test
	public void testDifferentLetters() {
		Assert.assertEquals("ab", day.removeChar("ab", 'C'));
	}

	@Test
	public void testDifferentLettersContainingKey() {
		Assert.assertEquals("bc", day.removeChar("abc", 'A'));
	}

	@Test
	public void testStringWithMultipleInstancesOfKey() {
		Assert.assertEquals("b", day.removeChar("aba", 'A'));
	}

	@Test
	public void testKeysWhichCauseMatches() {
		Assert.assertEquals("", day.removeChar("abA", 'B'));
	}

	@Test
	public void testKeysWhichCauseMatchesAndReturnNonEmpty() {
		Assert.assertEquals("c", day.removeChar("abAc", 'B'));
	}

}
