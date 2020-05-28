package com.i2r.utils.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Utils for object cast operations.
 */
public final class CastOperationUtils {

	/**
	 * Default constructor.
	 */
	private CastOperationUtils() {
		throw new IllegalAccessError("Shouldn't be instantiated.");
	}

	/**
	 * Cast {@link Object} to expected type.
	 *
	 * @param object {@link Object}
	 * @return {@link Object} with expected type
	 */
	@SuppressWarnings ("unchecked")
	public static <T> T cast(final Object object) {
		return (T) object;
	}

	/**
	 * Cast {@link Object} to {@link List}.
	 *
	 * @param object {@link Object}
	 * @return {@link List}
	 */
	@SuppressWarnings ("unchecked")
	public static <T> List<T> castList(final Object object) {
		return (List<T>) object;
	}

	/**
	 * Cast {@link Object} to {@link Set}.
	 *
	 * @param object {@link Object}
	 * @return {@link Set}
	 */
	@SuppressWarnings ("unchecked")
	public static <T> Set<T> castSet(final Object object) {
		return (Set<T>) object;
	}

	/**
	 * Cast {@link Object} to {@link Map}.
	 *
	 * @param object {@link Object}
	 * @return {@link Map}
	 */
	@SuppressWarnings ("unchecked")
	public static <K, V> Map<K, V> castMap(final Object object) {
		return (Map<K, V>) object;
	}
}
