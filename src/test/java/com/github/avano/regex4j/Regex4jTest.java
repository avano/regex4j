package com.github.avano.regex4j;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Tests for {@link Regex} class.
 * Created by avano on 17.10.16.
 */
public class Regex4jTest {
	private static final String TEXT = "this is my example text. This is my example text.";
	private static final String VERSION_TEXT = "myproduct-1.0.0.SNAPSHOT";

	@Test
	public void shouldGetSingleStringTest() {
		final String regex = "(\\w+)";
		assertEquals("Result", "this", Regex.getSubstring(TEXT, regex));
	}

	@Test
	public void shouldGetSingleStringCaseInsensitiveTest() {
		// Case insensitive
		final String regex = "This";
		assertEquals("Result", "this", Regex.getSubstring(TEXT, regex, Pattern.CASE_INSENSITIVE));
	}

	@Test
	public void shouldReturnNullWhenNoMatchTest() {
		final String regex = "mytext";
		assertNull("Result was not null", Regex.getSubstring(TEXT, regex));
	}

	@Test
	public void shouldGetMultipleSubstringsTest() {
		final String regex = "(\\w+)";
		assertEquals("Count", 10, Regex.getSubstrings(TEXT, regex, 0).size());
		final List<String> expected = Arrays.asList(TEXT.replaceAll("\\.", "").split(" "));
		assertEquals("Substring list", expected, Regex.getSubstrings(TEXT, regex, 0));
	}

	@Test
	public void shouldReturnEmptyListWhenNoSubstringsFoundTest() {
		final String regex = "[0-9]";
		assertEquals("Count", 0, Regex.getSubstrings(TEXT, regex, 0).size());
	}

	@Test
	public void shouldReturnTrueWhenContainsSubstring() {
		final String versionRegex = "^.*([0-9]\\.){3}.*$";
		assertTrue("Contains returned false", Regex.contains(VERSION_TEXT, versionRegex));
	}
}
