package com.github.avano.regex4j;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple regex class.
 * Created by avano on 17.10.16.
 */
public final class Regex {
	/**
	 * Constructor.
	 */
	private Regex() {
	}

	/**
	 * Returns a first substring that matches the regex in specified string.
	 * @param text text to search in
	 * @param regex regex to search for
	 * @return first substring that matches the regex in specified string.
	 */
	public static String getSubstring(String text, String regex) {
		return getSubstring(text, regex, -1);
	}

	/**
	 * Returns a first substring that matches the regex in specified string. Flag from @{java.util.regex.Pattern} class.
	 * @param text text to search in
	 * @param regex regex to search for
	 * @param flag flag from Pattern class.
	 * @return first substring that matches the regex in specified string.
	 */
	public static String getSubstring(String text, String regex, int flag) {
		final Pattern pattern;
		pattern = (flag == -1 ? Pattern.compile(regex) : Pattern.compile(regex, flag));
		final Matcher matcher = pattern.matcher(text);
		if (matcher.find(0)) {
			return matcher.group();
		}
		return null;
	}

	/**
	 * Returns a list of all the substrings that matches the regex in specified string.
	 * @param text text to search in
	 * @param regex regex to search for
	 * @return list of all substrings that matches the regex
	 */
	public static List<String> getSubstrings(String text, String regex) {
		return getSubstrings(text, regex, -1);
	}

	/**
	 * Returns a list of all the substrings that matches the regex in specified string. Flag from @{java.util.regex.Pattern} class.
	 * @param text text to search in
	 * @param regex regex to search for
	 * @param flag flag from Pattern class.
	 * @return list of all substrings that matches the regex
	 */
	public static List<String> getSubstrings(String text, String regex, int flag) {
		final Pattern pattern;
		pattern = (flag == -1 ? Pattern.compile(regex) : Pattern.compile(regex, flag));
		final Matcher matcher = pattern.matcher(text);
		final List<String> groupList = new ArrayList<String>();
		while (matcher.find()) {
			groupList.add(matcher.group(1));
		}
		return groupList;
	}

	/**
	 * Checks if the text contains a substring that matches the specified regex.
	 * @param text text to search in
	 * @param substringRegex substring regex to search for
	 * @return true if the text contains a substring specified by the regex, false otherwise
	 */
	public static boolean contains(String text, String substringRegex) {
		return contains(text, substringRegex, -1);
	}

	/**
	 * Checks if the text contains a substring that matches the specified regex.
	 * @param text text to search in
	 * @param substringRegex substring regex to search for
	 * @param flag flag from Pattern class.
	 * @return true if the text contains a substring specified by the regex, false otherwise
	 */
	public static boolean contains(String text, String substringRegex, int flag) {
		final Pattern pattern;
		pattern = (flag == -1 ? Pattern.compile(substringRegex) : Pattern.compile(substringRegex, flag));
		final Matcher matcher = pattern.matcher(text);
		return matcher.find(0);
	}
}
