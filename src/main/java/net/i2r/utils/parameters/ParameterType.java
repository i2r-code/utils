package net.i2r.utils.parameters;

/**
 * Type of the parameter.
 *
 * @author h3llka
 */
public enum ParameterType {
	/**
	 * Plain type, eg, parameter value simple string, etc.
	 */
	PLAIN,

	/**
	 * Complex type allow to resolve value as some pojo, etc.
	 */
	COMPLEX;

}
