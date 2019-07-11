package net.i2r.utils.parameters.plain.impl;

import net.i2r.utils.common.CastOperationUtils;
import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.plain.PlainParameter;
import net.i2r.utils.parameters.plain.PlainParameterType;

/**
 * Long plain param impl.
 */
public class LongParameter extends PlainParameter<Long> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 1738555596150540302L;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Long} as value
	 * @param required
	 * 		is required
	 */
	protected LongParameter(final String name, final Long value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 *        {@link Long} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	protected LongParameter(final String name, final Long value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	@Override
	public PlainParameterType getPlainParameterType() {
		return PlainParameterType.LONG;
	}

	/**
	 * Creates {@link Builder} instance.
	 *
	 * @return {@link Builder}
	 */
	public static Builder builder() {
		return new LongBuilder();
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
	public abstract static class Builder<Value extends LongParameter> extends PlainParameter.Builder<Long, Value> {

		@Override
		public <BType extends Parameter.Builder<Long, Value>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Long.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

		@Override
		public abstract Value build();
	}

	/**
	 * Builder facility.
	 */
	public static class LongBuilder extends Builder<LongParameter> {

		/**
		 * Perform {@link LongParameter} creation.
		 *
		 * @return {@link LongParameter} instance
		 */
		public LongParameter build() {
			return new LongParameter(name, value, required, decorator, preProcess);
		}
	}
}
