package net.i2r.utils.parameters.plain;

/**
 * Define types of the plain parameters.
 */
public enum PlainParameterType {
	/**
	 * String type.
	 */
	STRING(String.class),

	/**
	 * Int type.
	 */
	INT(Integer.class),

	/**
	 * Long type.
	 */
	LONG(Long.class),

	/**
	 * Float type.
	 */
	FLOAT(Float.class),

	/**
	 * Double type.
	 */
	DOUBLE(Double.class),

	/**
	 * Double type.
	 */
	BOOLEAN(Boolean.class),

	/**
	 * Timestamp type.
	 */
	TIMESTAMP(Long.class);

	/**
	 * Class mapping, for class representation fetch.
	 */
	private Class<?> mappedClazz;

	/**
	 * Constructor.
	 *
	 * @param mappedClazz
	 * 		class that represents the value
	 */
	PlainParameterType(Class<?> mappedClazz) {
		this.mappedClazz = mappedClazz;
	}

	public Class<?> getMappedClazz() {
		return mappedClazz;
	}
}
