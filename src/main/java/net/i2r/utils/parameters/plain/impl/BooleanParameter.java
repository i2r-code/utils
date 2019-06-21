package net.i2r.utils.parameters.plain.impl;

import net.i2r.utils.common.CastOperationUtils;
import net.i2r.utils.parameters.Parameter;
import net.i2r.utils.parameters.plain.PlainParameter;
import net.i2r.utils.parameters.plain.PlainParameterType;

/**
 * Boolean parameter impl.
 */
public class BooleanParameter extends PlainParameter<Boolean> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 3138291787797933254L;

	/**
	 * Constructor, for lombok builder purposes.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		parameter value
	 * @param required
	 * 		is required
	 */
	private BooleanParameter(final String name, final Boolean value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor, for lombok builder purposes.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		parameter value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing expression
	 */
	private BooleanParameter(final String name, final Boolean value, final boolean required, final String decorator, final String preProcess) {
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
	public static class Builder extends PlainParameter.Builder<Boolean, BooleanParameter> {

		@Override
		public <BType extends Parameter.Builder<Boolean, BooleanParameter>> BType valueFromString(final String aValue) {
			if (aValue != null)
				value(Boolean.valueOf(aValue));

			return CastOperationUtils.cast(this);
		}

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
