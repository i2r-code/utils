package net.i2r.utils.parameters.plain.impl;

import net.i2r.utils.common.CastOperationUtils;
import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.plain.PlainParameter;
import net.i2r.utils.parameters.plain.PlainParameterType;

/**
 * String parameter impl.
 */
public class StringParameter extends PlainParameter<String> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 1324916381393259112L;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		{@link String} as value
	 * @param required
	 * 		is required
	 */
	private StringParameter(final String name, final String value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		{@link String} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	private StringParameter(final String name, final String value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	@Override
	public PlainParameterType getPlainParameterType() {
		return PlainParameterType.STRING;
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
	public static class Builder extends PlainParameter.Builder<String, StringParameter> {

		@Override
		public <BType extends Parameter.Builder<String, StringParameter>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(aValue);

			return CastOperationUtils.cast(this);
		}

		/**
		 * Perform {@link StringParameter} creation.
		 *
		 * @return {@link StringParameter} instance
		 */
		public StringParameter build() {
			return new StringParameter(name, value, required, decorator, preProcess);
		}
	}
}
