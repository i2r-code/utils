package net.i2r.utils.parameters.complex;

import java.io.Serializable;

import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.ParameterType;
import org.apache.commons.lang.StringUtils;

/**
 * Complex parameter definition.
 */
public abstract class ComplexParameter<Value extends Serializable> extends Parameter<Value> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 5648686392474824567L;

	/**
	 * ComplexParameter 'valueClassName'.
	 */
	private String valueClassName;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Value} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	private ComplexParameter(final String name, final Value value, final boolean required, final String decorator, final String preProcess, final String valueClass) {
		super(name, value, required, decorator, preProcess);
		if (value != null)
			this.valueClassName = value.getClass().getName();
		if (value == null && !StringUtils.isEmpty(valueClass))
			this.valueClassName = valueClass;
	}

	@Override
	public ParameterType getType() {
		return ParameterType.COMPLEX;
	}

	/**
	 * Fetches type of the complex parameter.
	 *
	 * @return {@link ComplexParameterType}
	 */
	public abstract ComplexParameterType getComplexParameterType();

	@Override
	public Class<?> getValueClass() {
		if (StringUtils.isEmpty(valueClassName))
			throw new RuntimeException("valueClassName  property was not properly set");
		try {
			return Class.forName(valueClassName);
		} catch (final ClassNotFoundException e) {
			throw new RuntimeException(valueClassName + " property was not properly set", e);
		}
	}

	public String getValueClassName() {
		return valueClassName;
	}

	/**
	 * Fetches value in required type, if possible.
	 *
	 * @param clazz
	 * 		value type
	 * @param <T>
	 * 		value type param
	 * @return {@link T}
	 */
	public <T extends Serializable> T getValue(final Class<T> clazz) {
		return getValue(clazz, null);
	}

	/**
	 * Fetch value of required type.
	 *
	 * @param clazz
	 * 		value type
	 * @param defaultValue
	 * 		default value if not assigned
	 * @param <T>
	 * 		value type param
	 * @return {@link T}
	 */
	public <T extends Serializable> T getValue(final Class<T> clazz, final T defaultValue) {
		if (clazz == null)
			throw new IllegalArgumentException("Clazz parameter is not valid");
		final Serializable value = getValue();
		if (value == null || !clazz.isInstance(value))
			return defaultValue;
		return clazz.cast(value);
	}

	/**
	 * Builder facility.
	 *
	 * @param <Value>
	 */
	public abstract static class Builder<Value extends Serializable, Result extends ComplexParameter<Value>> extends Parameter.Builder<Value, Result> {
		/**
		 * Perform {@link ComplexParameter} build.
		 *
		 * @return {@link ComplexParameter}
		 */
		public abstract Result build();
	}
}
