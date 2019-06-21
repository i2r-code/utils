package net.i2r.utils.parameters.plain.impl;

import net.i2r.utils.common.CastOperationUtils;
import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.plain.PlainParameter;
import net.i2r.utils.parameters.plain.PlainParameterType;

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
	 * 		name to use
	 * @param value
	 * 		parameter value
	 * @param required
	 * 		is required property
	 */
	private IntegerParameter(final String name, final Integer value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		name to use
	 * @param value
	 * 		parameter value
	 * @param required
	 * 		is required property
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing expression
	 */
	private IntegerParameter(final String name, final Integer value, final boolean required, final String decorator, final String preProcess) {
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
		return new Builder();
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
	public static class Builder extends PlainParameter.Builder<Integer, IntegerParameter> {

		@Override
		public <BType extends Parameter.Builder<Integer, IntegerParameter>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Integer.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

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