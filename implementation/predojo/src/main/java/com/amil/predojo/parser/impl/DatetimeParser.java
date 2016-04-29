/**
 * 
 */
package com.amil.predojo.parser.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import com.amil.predojo.parser.AbstracParser;

/**
 * @author Juliano Sena
 *
 */
public class DatetimeParser extends AbstracParser<Date> {

	public DatetimeParser() {
		super("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amil.predojo.parser.Parser#parse(java.lang.String)
	 */
	public Date parse(String value) {
		Date date = null;
		if (this.isParsed(value)) {
			try {
				date = getDatetime(value);

			} catch (ParseException pe){
				date = null;
			}
		}
		return date;
	}

	private Date getDatetime(String value) throws ParseException{
		Matcher matcher = this.pattern.matcher(value);
		matcher.find();
		String datetime = value.substring(matcher.start(), matcher.end());

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setLenient(false);
		return dateFormat.parse(datetime);
	}
}
