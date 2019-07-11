package net.i2r.utils.parameters.plain.impl;

import net.i2r.utils.common.CastOperationUtils;
import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.plain.PlainParameter;
import net.i2r.utils.parameters.plain.PlainParameterType;

/**
 * Timestamp plain param impl.
 */
public class TimestampParameter extends PlainParameter<Long> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 5448072644271379132L;

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
	protected TimestampParameter(final String name, final Long value, final boolean required) {
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
	protected TimestampParameter(final String name, final Long value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	@Override
	public PlainParameterType getPlainParameterType() {
		return PlainParameterType.TIMESTAMP;
	}

	/**
	 * Creates {@link Builder} instance.
	 *
	 * @return {@link Builder}
	 */
	public static Builder builder() {
		return new TimestampBuilder();
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
	public abstract static class Builder<Value extends TimestampParameter> extends PlainParameter.Builder<Long, Value> {

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
	public static class TimestampBuilder extends Builder<TimestampParameter> {

		/**
		 * Perform {@link TimestampParameter} creation.
		 *
		 * @return {@link TimestampParameter} instance
		 */
		public TimestampParameter build() {
			return new TimestampParameter(name, value, required, decorator, preProcess);
		}
	}
}
