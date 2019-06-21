package net.i2r.utils.parameters.plain.impl;

import net.i2r.utils.common.CastOperationUtils;
import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.plain.PlainParameter;
import net.i2r.utils.parameters.plain.PlainParameterType;

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
	 * 		{@link Float} as value
	 * @param required
	 * 		is required
	 */
	private FloatParameter(final String name, final Float value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		{@link Float} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	private FloatParameter(final String name, final Float value, final boolean required, final String decorator, final String preProcess) {
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
	public static class Builder extends PlainParameter.Builder<Float, FloatParameter> {

		@Override
		public <BType extends Parameter.Builder<Float, FloatParameter>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Float.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

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
