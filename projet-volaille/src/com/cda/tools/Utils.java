package com.cda.tools;

import java.text.DecimalFormat;

public class Utils {
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
	
	public static String formaterPrixOuPois(float pPrixOuPoids) {
		return DECIMAL_FORMAT.format(pPrixOuPoids);
	}
}
