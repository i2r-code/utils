package com.i2r.utils.parameters.plain.impl;

import com.i2r.utils.common.CastOperationUtils;
import com.i2r.utils.parameters.Parameter;
import com.i2r.utils.parameters.plain.PlainParameter;
import com.i2r.utils.parameters.plain.PlainParameterType;

/**
 * Boolean parameter impl.
 */
public class BooleanParameter extends PlainParameter<Boolean> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 3138291787797933254L;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Boolean} as value
	 * @param required
	 * 		is required
	 */
	protected BooleanParameter(final String name, final Boolean value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Boolean} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	protected BooleanParameter(final String name, final Boolean value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	@Override
	public PlainParameterType getPlainParameterType() {
		return PlainParameterType.BOOLEAN;
	}

	/**
	 * Creates {@link Builder} instance.
	 *
	 * @return {@link Builder}
	 */
	public static Builder builder() {
		return new BooleanBuilder();
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
	public abstract static class Builder<Value extends BooleanParameter> extends PlainParameter.Builder<Boolean, Value> {

		@Override
		public <BType extends Parameter.Builder<Boolean, Value>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Boolean.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

		@Override
		public abstract Value build();
	}

	/**
	 * Builder facility.
	 */
	public static class BooleanBuilder extends Builder<BooleanParameter> {

		/**
		 * Perform {@link BooleanParameter} creation.
		 *
		 * @return {@link BooleanParameter} instance
		 */
		public BooleanParameter build() {
			return new BooleanParameter(name, value, required, decorator, preProcess);
		}
	}
}
