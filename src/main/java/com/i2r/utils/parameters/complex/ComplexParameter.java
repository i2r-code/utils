package com.i2r.utils.parameters.complex;

import java.io.Serializable;

import com.i2r.utils.parameters.Parameter;
import com.i2r.utils.parameters.ParameterType;
import org.apache.commons.lang.StringUtils;

/**
 * Complex parameter definition.
 */
public class ComplexParameter extends Parameter<Serializable> {
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
	 *        {@link Serializable} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	protected ComplexParameter(final String name, final Serializable value, final boolean required, final String decorator, final String preProcess, final String valueClass) {
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
	 * Fetches {@link Builder}.
	 *
	 * @return {@link Builder}
	 */
	public static Builder builder() {
		return new ComplexBuilder();
	}

	@Override
	public Builder toBuilder() {
		final Builder result = builder();
		populateBuilder(result);
		return result;
	}

	@Override
	protected void populateBuilder(final Parameter.Builder<Serializable, ? extends Parameter<Serializable>> builder) {
		super.populateBuilder(builder);
		Builder.class.cast(builder).valueClass(valueClassName);
	}

	/**
	 * Builder for the {@link ComplexParameter}.
	 */
	public abstract static class Builder<Value extends ComplexParameter> extends Parameter.Builder<Serializable, Value> {
		/**
		 * Builder 'valueClass'.
		 */
		protected String valueClass;

		/**
		 * Allow to provide {@link #valueClass}/
		 *
		 * @param vClass
		 * 		class name
		 * @return {@link Builder}
		 */
		public Builder valueClass(final String vClass) {
			if (StringUtils.isEmpty(vClass))
				return this;
			valueClass = vClass;

			return this;
		}

		@Override
		public Builder value(final Serializable aValue) {
			if (aValue == null)
				return this;
			super.value(aValue);
			valueClass = aValue.getClass().getName();
			return this;
		}

		@Override
		public <BType extends Parameter.Builder<Serializable, Value>> BType valueFromString(final String aValue) {
			throw new IllegalStateException("Not supported method");
		}

		@Override
		public abstract Value build();
	}

	/**
	 * Builder facility.
	 */
	public static class ComplexBuilder extends Builder<ComplexParameter> {

		/**
		 * Perform {@link ComplexParameter} creation.
		 *
		 * @return {@link ComplexParameter} instance
		 */
		public ComplexParameter build() {
			return new ComplexParameter(name, value, required, decorator, preProcess, valueClass);
		}
	}
}
