package com.i2r.utils.parameters.plain.impl;

import com.i2r.utils.common.CastOperationUtils;
import com.i2r.utils.parameters.Parameter;
import com.i2r.utils.parameters.plain.PlainParameter;
import com.i2r.utils.parameters.plain.PlainParameterType;

/**
 * Float plain param impl.
 */
public class FloatParameter extends PlainParameter<Float> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 7218766809746700443L;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Float} as value
	 * @param required
	 * 		is required
	 */
	protected FloatParameter(final String name, final Float value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Float} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	protected FloatParameter(final String name, final Float value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	@Override
	public PlainParameterType getPlainParameterType() {
		return PlainParameterType.FLOAT;
	}

	/**
	 * Creates {@link Builder} instance.
	 *
	 * @return {@link Builder}
	 */
	public static Builder builder() {
		return new FloatBuilder();
	}

	@Override
	public Builder toBuilder() {
		final Builder result = builder();
		populateBuilder(result);
		return result;
	}

	/**
	 * Builder facility.
	 */
	public abstract static class Builder<Value extends FloatParameter> extends PlainParameter.Builder<Float, Value> {

		@Override
		public <BType extends Parameter.Builder<Float, Value>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Float.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

		@Override
		public abstract Value build();
	}

	/**
	 * Builder facility.
	 */
	public static class FloatBuilder extends Builder<FloatParameter> {

		/**
		 * Perform {@link FloatParameter} creation.
		 *
		 * @return {@link FloatParameter} instance
		 */
		public FloatParameter build() {
			return new FloatParameter(name, value, required, decorator, preProcess);
		}
	}
}
