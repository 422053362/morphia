/**
 * 
 */
package com.google.code.morphia.mapping.lazy.proxy;

/**
 * @author Uwe Schäfer, (schaefer@thomas-daily.de)
 * 
 */
@SuppressWarnings("rawtypes")
public interface ProxiedReference {
	boolean __isFetched();

	Class __getReferenceObjClass();

	Object __unwrap();
}
