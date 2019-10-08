package com.i2r.utils.parameters.plain.impl;

import com.i2r.utils.common.CastOperationUtils;
import com.i2r.utils.parameters.Parameter;
import com.i2r.utils.parameters.plain.PlainParameter;
import com.i2r.utils.parameters.plain.PlainParameterType;

/**
 * Integer plain param impl.
 */
public class IntegerParameter extends PlainParameter<Integer> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = -2982383732594302684L;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Integer} as value
	 * @param required
	 * 		is required
	 */
	protected IntegerParameter(final String name, final Integer value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Integer} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	protected IntegerParameter(final String name, final Integer value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	@Override
	public PlainParameterType getPlainParameterType() {
		return PlainParameterType.INT;
	}

	/**
	 * Creates {@link Builder} instance.
	 *
	 * @return {@link Builder}
	 */
	public static Builder builder() {
		return new IntegerBuilder();
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
	public abstract static class Builder<Value extends IntegerParameter> extends PlainParameter.Builder<Integer, Value> {

		@Override
		public <BType extends Parameter.Builder<Integer, Value>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Integer.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

		@Override
		public abstract Value build();
	}

	/**
	 * Builder facility.
	 */
	public static class IntegerBuilder extends Builder<IntegerParameter> {

		/**
		 * Perform {@link IntegerParameter} creation.
		 *
		 * @return {@link IntegerParameter} instance
		 */
		public IntegerParameter build() {
			return new IntegerParameter(name, value, required, decorator, preProcess);
		}
	}
}
