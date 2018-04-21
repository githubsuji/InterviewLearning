package com.myinterview.immutable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class ImmutableExecutor {
	  private static final Logger logger = Logger.getLogger(ImmutableExecutor.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImmutableClass s =  new ImmutableClass("suji");
		
		System.out.println(s);
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date d = null;
		     try {
				d = df.parse("1999/03/25 11:23:20");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Planet p = new Planet(200.0, "mars", d);
		d = new Date();
		System.err.println(300000);
		logger.info(p.getDateOfDiscovery());
		
	}

}
