package com.i2r.utils.common;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.UUID;

/**
 * Identifier utilities.
 */
public final class UUIDUtils {

	/**
	 * Default constructor with preventing instantiations of this class.
	 */
	private UUIDUtils() {
		throw new IllegalAccessError("Shouldn't be instantiated.");
	}

	/**
	 * Generate unique identifier.
	 *
	 * @return generated {@link String} identifier
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Is given string are {@link UUID}.
	 *
	 * @param value string
	 * @return <code>true</code> if {@link UUID} or <code>false</code>
	 */
	public static boolean isUUID(final String value) {
		try {
			return isNotEmpty(UUID.fromString(value).toString());
			// CHECKSTYLE:OFF
		} catch (final RuntimeException e) {
			// CHECKSTYLE:ON
			return false;
		}
	}

}
