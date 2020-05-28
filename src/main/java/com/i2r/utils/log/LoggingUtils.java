package com.i2r.utils.log;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Utility methods for logging purposes.
 */
public final class LoggingUtils {

	/**
	 * {@link Marker} name for 'FATAL' error message case.
	 */
	public static final String FATAL_NAME = "FATAL";

	/**
	 * {@link Marker} for 'FATAL' error case.
	 */
	public static final Marker FATAL = MarkerFactory.getMarker(FATAL_NAME);

	/**
	 * {@link Marker} name for 'EVENT' message case.
	 */
	public static final String EVENT_NAME = "EVENT";

	/**
	 * {@link Marker} for 'EVENT' message case.
	 */
	public static final Marker EVENT = MarkerFactory.getMarker(EVENT_NAME);

	/**
	 * {@link Marker} name for 'STATS' message case.
	 */
	public static final String STATS_NAME = "STATS";

	/**
	 * {@link Marker} for 'STATS' message case.
	 */
	public static final Marker STATS = MarkerFactory.getMarker(STATS_NAME);

	/**
	 * Default constructor with preventing instantiations of this class.
	 */
	private LoggingUtils() {
		throw new IllegalAccessError("Shouldn't be instantiated.");
	}

	/**
	 * Log trace message.<br>
	 * Is trace enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 */
	public static void trace(final Logger logger, final String message) {
		if (logger.isTraceEnabled())
			logger.trace(message);
	}

	/**
	 * Log trace message.<br>
	 * Is trace enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 */
	public static void trace(final Logger logger, final Marker marker, final String message) {
		if (logger.isTraceEnabled())
			logger.trace(marker, message);
	}

	/**
	 * Log trace message.<br>
	 * Is trace enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void trace(final Logger logger, final String message, final Throwable cause) {
		if (logger.isTraceEnabled())
			logger.trace(message, cause);
	}

	/**
	 * Log trace message.<br>
	 * Is trace enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void trace(final Logger logger, final Marker marker, final String message, final Throwable cause) {
		if (logger.isTraceEnabled())
			logger.trace(marker, message, cause);
	}

	/**
	 * Log debug message.<br>
	 * Is debug enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 */
	public static void debug(final Logger logger, final String message) {
		if (logger.isDebugEnabled())
			logger.debug(message);
	}

	/**
	 * Log debug message.<br>
	 * Is debug enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 */
	public static void debug(final Logger logger, final Marker marker, final String message) {
		if (logger.isDebugEnabled())
			logger.debug(marker, message);
	}

	/**
	 * Log debug message.<br>
	 * Is debug enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void debug(final Logger logger, final String message, final Throwable cause) {
		if (logger.isDebugEnabled())
			logger.debug(message, cause);
	}

	/**
	 * Log debug message.<br>
	 * Is debug enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void debug(final Logger logger, final Marker marker, final String message, final Throwable cause) {
		if (logger.isDebugEnabled())
			logger.debug(marker, message, cause);
	}

	/**
	 * Log info message.<br>
	 * Is info enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 */
	public static void info(final Logger logger, final String message) {
		if (logger.isInfoEnabled())
			logger.info(message);
	}

	/**
	 * Log info message.<br>
	 * Is info enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 */
	public static void info(final Logger logger, final Marker marker, final String message) {
		if (logger.isInfoEnabled())
			logger.info(marker, message);
	}

	/**
	 * Log info message.<br>
	 * Is info enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void info(final Logger logger, final String message, final Throwable cause) {
		if (logger.isInfoEnabled())
			logger.info(message, cause);
	}

	/**
	 * Log info message.<br>
	 * Is info enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void info(final Logger logger, final Marker marker, final String message, final Throwable cause) {
		if (logger.isInfoEnabled())
			logger.info(marker, message, cause);
	}

	/**
	 * Log warn message.<br>
	 * Is warn enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 */
	public static void warn(final Logger logger, final String message) {
		if (logger.isWarnEnabled())
			logger.warn(message);
	}

	/**
	 * Log warn message.<br>
	 * Is warn enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 */
	public static void warn(final Logger logger, final Marker marker, final String message) {
		if (logger.isWarnEnabled())
			logger.warn(marker, message);
	}

	/**
	 * Log warn message.<br>
	 * Is warn enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void warn(final Logger logger, final String message, final Throwable cause) {
		if (logger.isWarnEnabled())
			logger.warn(message, cause);
	}

	/**
	 * Log warn message.<br>
	 * Is warn enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void warn(final Logger logger, final Marker marker, final String message, final Throwable cause) {
		if (logger.isWarnEnabled())
			logger.warn(marker, message, cause);
	}

	/**
	 * Log error message.<br>
	 * Is error enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 */
	public static void error(final Logger logger, final String message) {
		if (logger.isErrorEnabled())
			logger.error(message);
	}

	/**
	 * Log error message.<br>
	 * Is error enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 */
	public static void error(final Logger logger, final Marker marker, final String message) {
		if (logger.isErrorEnabled())
			logger.error(marker, message);
	}

	/**
	 * Log error message.<br>
	 * Is error enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void error(final Logger logger, final String message, final Throwable cause) {
		if (logger.isErrorEnabled())
			logger.error(message, cause);
	}

	/**
	 * Log error message.<br>
	 * Is error enabled check will be performed.
	 *
	 * @param logger  logger instance, can't be <code>null</code>
	 * @param marker  logging marker
	 * @param message logging message
	 * @param cause   logging cause
	 */
	public static void error(final Logger logger, final Marker marker, final String message, final Throwable cause) {
		if (logger.isErrorEnabled())
			logger.error(marker, message, cause);
	}
}
