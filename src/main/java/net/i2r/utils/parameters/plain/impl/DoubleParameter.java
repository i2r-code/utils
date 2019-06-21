package net.i2r.utils.parameters.plain.impl;

import net.i2r.utils.common.CastOperationUtils;
import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.plain.PlainParameter;
import net.i2r.utils.parameters.plain.PlainParameterType;

/**
 * Double plain param impl.
 */
public class DoubleParameter extends PlainParameter<Double> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 2611390987159870291L;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		{@link Double} as value
	 * @param required
	 * 		is required
	 */
	private DoubleParameter(final String name, final Double value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		{@link Double} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	private DoubleParameter(final String name, final Double value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	@Override
	public PlainParameterType getPlainParameterType() {
		return PlainParameterType.DOUBLE;
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
	public static class Builder extends PlainParameter.Builder<Double, DoubleParameter> {

		@Override
		public <BType extends Parameter.Builder<Double, DoubleParameter>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Double.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

		/**
		 * Perform {@link DoubleParameter} creation.
		 *
		 * @return {@link DoubleParameter} instance
		 */
		public DoubleParameter build() {
			return new DoubleParameter(name, value, required, decorator, preProcess);
		}
	}


}
