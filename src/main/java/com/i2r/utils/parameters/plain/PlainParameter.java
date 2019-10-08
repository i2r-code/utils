package com.i2r.utils.parameters.plain;

import java.io.Serializable;
import java.util.Objects;

import com.i2r.utils.parameters.Parameter;
import com.i2r.utils.parameters.ParameterType;

/**
 * General plain parameter structure.
 */
public abstract class PlainParameter<Value extends Serializable> extends Parameter<Value> {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = 4230911576771606033L;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		{@link Serializable} as value
	 * @param required
	 * 		is required
	 */
	protected PlainParameter(final String name, final Value value, final boolean required) {
		super(name, value, required);
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		{@link Serializable} as value
	 * @param required
	 * 		is required
	 * @param decorator
	 * 		decorate name
	 * @param preProcess
	 * 		value pre processing {@link String} expression
	 */
	protected PlainParameter(final String name, final Value value, final boolean required, final String decorator, final String preProcess) {
		super(name, value, required, decorator, preProcess);
	}

	/**
	 * Fetches type of the plain parameter.
	 *
	 * @return {@link PlainParameterType}
	 */
	public abstract PlainParameterType getPlainParameterType();

	@Override
	public ParameterType getType() {
		return ParameterType.PLAIN;
	}

	@Override
	public Class<?> getValueClass() {
		return getPlainParameterType().getMappedClazz();
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o) && getPlainParameterType() == PlainParameter.class.cast(o).getPlainParameterType();
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getPlainParameterType());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
		sb.append("[")
		  .append(super.toString())
		  .append(", plainParameterType=").append(getPlainParameterType()).append("]");
		return sb.toString();
	}

	/**
	 * Builder facility.
	 *
	 * @param <Value>
	 */
	public abstract static class Builder<Value extends Serializable, Result extends PlainParameter<Value>> extends Parameter.Builder<Value, Result> {
		/**
		 * Perform {@link PlainParameter} build.
		 *
		 * @return {@link PlainParameter}
		 */
		public abstract Result build();
	}
}
