package de.ralfebert.rcputils.builder.table.format;

import java.text.DateFormat;
import java.text.DecimalFormat;

import org.eclipse.core.databinding.conversion.IConverter;

import de.ralfebert.rcputils.properties.IValueFormatter;

public class Formatter {

	public static StringValueFormatter forDouble(DecimalFormat decimalFormat) {
		return new StringValueFormatter(decimalFormat) {
			@Override
			public Object parse(String str) {
				return ((Number) super.parse(str)).doubleValue();
			}
		};
	}

	public static StringValueFormatter forLong(DecimalFormat decimalFormat) {
		return new StringValueFormatter(decimalFormat) {
			@Override
			public Object parse(String str) {
				return ((Number) super.parse(str)).longValue();
			}
		};
	}

	public static StringValueFormatter forFloat(DecimalFormat decimalFormat) {
		return new StringValueFormatter(decimalFormat) {
			@Override
			public Object parse(String str) {
				return ((Number) super.parse(str)).floatValue();
			}
		};
	}

	public static StringValueFormatter forInt(DecimalFormat decimalFormat) {
		decimalFormat.setParseIntegerOnly(true);
		return new StringValueFormatter(decimalFormat);
	}

	public static StringValueFormatter forDate(DateFormat dateFormat) {
		return new StringValueFormatter(dateFormat);
	}

	public static IValueFormatter<Object, Object> fromConverters(final IConverter format, final IConverter parse) {
		return new IValueFormatter<Object, Object>() {

			public Object format(Object obj) {
				return format.convert(obj);
			}

			public Object parse(Object obj) {
				return parse.convert(obj);
			}
		};
	}

	public static IValueFormatter<Integer, String> forInt() {
		return new IValueFormatter<Integer, String>() {

			public String format(Integer obj) {
				return Integer.toString(obj);
			}

			public Integer parse(String obj) {
				return Integer.parseInt(obj);
			}

		};
	}

}
