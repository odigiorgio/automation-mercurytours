package com.utils;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegexMatcher extends TypeSafeMatcher<String> {

	private final String regex;

    public RegexMatcher(final String regex) {
            this.regex = regex;
    }

    @Override
    public void describeTo(final Description description) {
            description.appendText("matches regular expression=`" + regex + "`");
    }

    @Override
    public boolean matchesSafely(final String string) {
            return string.matches(regex);
    }


     // matcher method you can call on this matcher class
    public static RegexMatcher matchesRegex(final String regex) {
    	return new RegexMatcher(regex);
}

}
