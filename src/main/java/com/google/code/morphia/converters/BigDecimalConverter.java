package com.google.code.morphia.converters;

import java.math.BigDecimal;

import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;

@SuppressWarnings({ "rawtypes" })
public class BigDecimalConverter extends TypeConverter implements
		SimpleValueConverter {

	public BigDecimalConverter() {
		super(BigDecimal.class);
	}

	protected BigDecimalConverter(Class clazz) {
		super(clazz);
	}

	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
		if (value != null) {
			return value.toString();
		}else {
			return null;
		}
	}
	@Override
	public Object decode(Class targetClass, Object fromDBObject, MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject == null)
			return null;
		return new BigDecimal(fromDBObject.toString());
	}

	@Override
	protected boolean isSupported(Class<?> c, MappedField optionalExtraInfo) {
		return BigDecimal.class.isAssignableFrom(c);
	}

}
