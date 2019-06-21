package net.i2r.utils.parameters;

import java.io.Serializable;
import java.util.Objects;

import net.i2r.utils.common.CastOperationUtils;

/**
 * Describes parameter structure.
 */
public abstract class Parameter<Value extends Serializable> implements Serializable {
	/**
	 * Basic serial version UID.
	 */
	private static final long serialVersionUID = -5664656090285846800L;

	/**
	 * Parameter name.
	 */
	private String name;
	/**
	 * Parameter value.
	 */
	private Value value;
	/**
	 * Parameter required flag.
	 */
	private boolean required;
	/**
	 * Param decorator name.
	 */
	private String decorator;
	/**
	 * Param pre processing EL.
	 */
	private String preProcess;

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		parameter value
	 * @param required
	 * 		is required
	 */
	protected Parameter(final String name, final Value value, final boolean required) {
		this.name = name;
		this.value = value;
		this.required = required;
	}

	/**
	 * Constructor.
	 *
	 * @param name
	 * 		parameter name
	 * @param value
	 * 		parameter value
	 * @param required
	 * 		is required
	 */
	protected Parameter(final String name, final Value value, final boolean required, final String decorator, final String preProcess) {
		this.name = name;
		this.value = value;
		this.required = required;
		this.decorator = decorator;
		this.preProcess = preProcess;
	}

	public String getName() {
		return name;
	}

	public Value getValue() {
		return value;
	}

	public boolean isRequired() {
		return required;
	}

	public String getDecorator() {
		return decorator;
	}

	public String getPreProcess() {
		return preProcess;
	}

	/**
	 * Resolves {@link ParameterType}.
	 *
	 * @return {@link ParameterType}
	 */
	public abstract ParameterType getType();

	/**
	 * Return {@link Class} which current wrapper created.
	 *
	 * @return {@link Class}
	 */
	public abstract Class<?> getValueClass();

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Parameter parameter = (Parameter) o;
		return getType() == parameter.getType() &&
				Objects.equals(name, parameter.name) &&
				Objects.equals(getType(), parameter.getType()) &&
				Objects.equals(value, parameter.value) &&
				Objects.equals(decorator, parameter.decorator) &&
				Objects.equals(preProcess, parameter.preProcess);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, value, getType());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("name=").append(name);
		sb.append(", value=").append(value);
		sb.append(", required=").append(required);
		sb.append(", type=").append(getType());
		sb.append(", decorator=").append(decorator);
		sb.append(", preProcess=").append(preProcess);
		return sb.toString();
	}

	/**
	 * Convert current into {@link Builder}.
	 *
	 * @return {@link Builder}
	 */
	public abstract Builder<Value, ? extends Parameter<Value>> toBuilder();

	/**
	 * Provides builder basics.
	 *
	 * @param builder
	 *        {@link Builder}
	 */
	protected void populateBuilder(final Builder<Value, ? extends Parameter<Value>> builder) {
		builder.required(isRequired()).name(getName()).value(getValue());
	}

	/**
	 * Builder facility.
	 *
	 * @param <Value>
	 * 		value
	 * @param <Result>
	 * 		result
	 */
	public abstract static class Builder<Value extends Serializable, Result extends Parameter<Value>> {
		/**
		 * Parameter name.
		 */
		protected String name;
		/**
		 * Parameter value.
		 */
		protected Value value;
		/**
		 * Parameter required flag.
		 */
		protected boolean required = false;
		/**
		 * Param decorator name.
		 */
		protected String decorator;
		/**
		 * Param pre processing EL.
		 */
		protected String preProcess;

		/**
		 * Allow to provide name.
		 *
		 * @param aName
		 * 		name of the parameter
		 * @return {@link Builder}
		 */
		public <BType extends Builder<Value, Result>> BType name(final String aName) {
			this.name = aName;
			return CastOperationUtils.cast(this);
		}

		/**
		 * Allow to provide value.
		 *
		 * @param aValue
		 *        {@link Value} to use
		 * @return {@link Builder}
		 */
		public <BType extends Builder<Value, Result>> BType value(final Value aValue) {
			this.value = aValue;
			return CastOperationUtils.cast(this);
		}

		/**
		 * Provides 'required' property.
		 *
		 * @param aReq
		 * 		required property value
		 * @return {@link Builder}
		 */
		public <BType extends Builder<Value, Result>> BType required(final boolean aReq) {
			this.required = aReq;
			return CastOperationUtils.cast(this);
		}

		/**
		 * Provides 'decorator' property.
		 *
		 * @param aDecorator
		 *        {@link String} decorated name
		 * @return {@link Builder}
		 */
		public <BType extends Builder<Value, Result>> BType decorator(final String aDecorator) {
			this.decorator = aDecorator;
			return CastOperationUtils.cast(this);
		}

		/**
		 * Provides 'preProcess' property.
		 *
		 * @param aPreProcess
		 *        {@link String} value that should be pre processed to 'value' field value
		 * @return {@link Builder}
		 */
		public <BType extends Builder<Value, Result>> BType preProcess(final String aPreProcess) {
			this.preProcess = aPreProcess;
			return CastOperationUtils.cast(this);
		}

		/**
		 * Allow to provide value from {@link String}.
		 *
		 * @param aValue
		 *        {@link String} to use
		 * @return {@link Builder}
		 */
		public abstract <BType extends Builder<Value, Result>> BType valueFromString(final String aValue);

		/**
		 * Perform {@link Parameter} build.
		 *
		 * @return {@link Parameter}
		 */
		public abstract Result build();
	}
}
