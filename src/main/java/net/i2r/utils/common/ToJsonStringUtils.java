package net.i2r.utils.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ClassUtils;

/**
 * Utilities for <code>toString</code>.
 *
 * @author rkapushchak
 */
public final class ToJsonStringUtils {

	/**
	 * Result first character.
	 */
	public static final String FIRST_CHAR = "{";

	/**
	 * Result last character.
	 */
	public static final String LAST_CHAR = "}";

	/**
	 * Result first character.
	 */
	public static final String ARRAY_FIRST_CHAR = "[";

	/**
	 * Result last character.
	 */
	public static final String ARRAY_LAST_CHAR = "]";

	/**
	 * Result elements delimiter.
	 */
	public static final String DELIMITER = ",";

	/**
	 * Result elements delimiter for map elements.
	 */
	public static final String MAP_VALUE_DELIMITER = ":";

	/**
	 * Result suffix if elements in collection more then allowed in result.
	 */
	public static final String MORE_CHARS = "...";

	/**
	 * Result for empty or <code>null</code> collection.
	 */
	public static final String EMPTY_RESULT = FIRST_CHAR + LAST_CHAR;

	/**
	 * Result for empty or <code>null</code> collection.
	 */
	public static final String ARRAY_EMPTY = ARRAY_FIRST_CHAR + ARRAY_LAST_CHAR;

	/**
	 * Result for not empty collection but with limit less than '1'.
	 */
	public static final String EMPTY_MORE_RESULT = FIRST_CHAR + MORE_CHARS + LAST_CHAR;

	/**
	 * Result for not empty collection but with limit less than '1'.
	 */
	public static final String ARRAY_EMPTY_MORE_RESULT = ARRAY_FIRST_CHAR + MORE_CHARS + ARRAY_LAST_CHAR;

	/**
	 * Default collection elements limit for representation.
	 */
	public static final int DEFAULT_LIMIT = 10;

	/**
	 * Private constructor.
	 */
	private ToJsonStringUtils() {
		throw new IllegalAccessError("Can't be instantiated.");
	}

	/**
	 * Create string representation for any array with default elements limit.
	 *
	 * @param obj
	 * 		object to string
	 * @return {@link String}
	 */
	public static String toString(final Object obj) {
		if (obj == null)
			return "";

		if (ClassUtils.isPrimitiveOrWrapper(obj.getClass()))
			return obj.toString();

		if (obj.getClass().isArray()) {
			final Object[] array = (Object[]) obj;
			return toString(array, array.length);
		}

		final StringBuilder result = new StringBuilder();
		if (obj instanceof String)
			return result.append("\"").append(obj.toString()).append("\"").toString();
		if (obj instanceof Collection)
			return toString(Collection.class.cast(obj));
		if (obj instanceof Map)
			return toString(Map.class.cast(obj));

		result.append(FIRST_CHAR);
		final Field[] fields = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			final Field field = fields[i];
			field.setAccessible(true);

			try {
				result.append("\"").append(field.getName()).append("\":");

				final Object value = field.get(obj);
				if (ClassUtils.isPrimitiveOrWrapper(value.getClass())) {
					result.append(value.toString());

					if (i != fields.length - 1)
						result.append(",");

					continue;
				}

				result.append(toString(value));
			} catch (final IllegalAccessException e) {
				e.printStackTrace();
			}

			if (i != fields.length - 1)
				result.append(",");
		}

		return result.append(LAST_CHAR).toString();
	}

	/**
	 * Create string representation for any array with default elements limit.
	 *
	 * @param array
	 * 		array, can be <code>null</code> or empty
	 * @return {@link String}
	 */
	public static String toString(final Object[] array) {
		return toString(array, DEFAULT_LIMIT);
	}

	/**
	 * Create string representation for any array with default elements limit.
	 *
	 * @param array
	 * 		array, can be <code>null</code> or empty
	 * @param maxLen
	 * 		elements limit used in representation
	 * @return {@link String}
	 */
	public static String toString(final Object[] array, final int maxLen) {
		return toString(array == null || array.length == 0 ? Collections.emptyList() : Arrays.asList(array), maxLen);
	}

	/**
	 * Create string representation for any collection with default elements limit.
	 *
	 * @param collection
	 * 		collection, can be <code>null</code> or empty
	 * @return {@link String}
	 */
	public static String toString(final Collection<?> collection) {
		return toString(collection, DEFAULT_LIMIT);
	}

	/**
	 * Create string representation for any collection.
	 *
	 * @param collection
	 * 		collection, can be <code>null</code> or empty
	 * @param maxLen
	 * 		elements limit used in representation
	 * @return {@link String}
	 */
	public static String toString(final Collection<?> collection, final int maxLen) {
		if (collection == null || collection.isEmpty())
			return ARRAY_EMPTY;
		if (maxLen < 1)
			return ARRAY_EMPTY_MORE_RESULT;

		final StringBuilder builder = new StringBuilder(ARRAY_FIRST_CHAR);
		int i = 0;
		for (final Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(DELIMITER);

			builder.append(toString(iterator.next()));
		}

		if (collection.size() > maxLen)
			builder.append(DELIMITER).append(MORE_CHARS);

		builder.append(ARRAY_LAST_CHAR);
		return builder.toString();
	}

	/**
	 * Create string representation for map with default elements limit.
	 *
	 * @param map
	 * 		map, can be <code>null</code> or empty
	 * @return {@link String}
	 */
	public static String toString(final Map<?, ?> map) {
		return toString(map, DEFAULT_LIMIT);
	}

	/**
	 * Create string representation for map.
	 *
	 * @param map
	 * 		map, can be <code>null</code> or empty
	 * @param maxLen
	 * 		elements limit used in representation
	 * @return {@link String}
	 */
	public static String toString(final Map<?, ?> map, final int maxLen) {
		if (map == null || map.isEmpty())
			return EMPTY_RESULT;
		if (maxLen < 1)
			return EMPTY_MORE_RESULT;

		final StringBuilder builder = new StringBuilder(FIRST_CHAR);
		int i = 0;
		for (final Entry<?, ?> entry : map.entrySet()) {
			if (i > 0)
				builder.append(DELIMITER);

			final Object key = entry.getKey();
			final Object value = entry.getValue();
			builder.append(toString(key)).append(MAP_VALUE_DELIMITER).append(toString(value));
			if (++i >= maxLen) // increment and break if limit exceeded
				break;
		}

		if (map.size() > maxLen)
			builder.append(DELIMITER).append(MORE_CHARS);

		builder.append(LAST_CHAR);
		return builder.toString();
	}
}
