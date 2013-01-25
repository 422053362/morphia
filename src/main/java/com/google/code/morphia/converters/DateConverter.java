/**
 * 
 */
package com.google.code.morphia.converters;

import java.util.Calendar;
import java.util.Date;

import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;

/**
 * @author Uwe Schaefer, (us@thomas-daily.de)
 * @author scotthernandez
 */
@SuppressWarnings({"rawtypes"})
public class DateConverter extends TypeConverter implements SimpleValueConverter{
	
	public DateConverter() { this(Date.class); };
	protected DateConverter(Class clazz) { super(clazz); }

	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
		if(value!=null){
		   return ((Date) value).getTime();
		}else{
			return null;
		}
	}

	@Override
	public Object decode(Class targetClass, Object fromDBObject, MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject == null)
			return null;
		Calendar ins = Calendar.getInstance();
	    ins.setTimeInMillis(Long.valueOf(fromDBObject.toString()));
		return ins.getTime();
	}
	
	@Override
	protected boolean isSupported(Class<?> c, MappedField optionalExtraInfo) {
		return Date.class.isAssignableFrom(c);
	}
}
