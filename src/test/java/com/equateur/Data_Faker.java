package com.equateur;

import org.apache.commons.lang3.ArrayUtils;

import com.github.javafaker.Faker;

public class Data_Faker {
	
	private Faker faker = new Faker();
	
	public static Data_Faker getDataHelper() {
		return new Data_Faker();
	}
	
	 public String getReferenceName() {
		 return faker.commerce().productName();
	 }
	 
	 public String getCdnEAN() {
		 System.out.println("EAN ");
//		 Faker.instance().expression("\\d{12}");
//		 faker.expression("#{code.ean_13}");
//		 char[] values = Faker.instance().expression("\\d{12}").toCharArray();
//		 char[] values = faker.regexify("\\d{12}").toCharArray();
//		 int sum = 0;
//		 int[] GTIN_13_CHECK_DIGITS = { 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3 };
//	        for (int i = 0; i < values.length; i++) {
//	            sum += Character.getNumericValue(values[i]) * GTIN_13_CHECK_DIGITS[i];
//	        }
//	        int checkDigit = 10 - sum % 10;
//	        if (checkDigit == 10) {
//	            return new String(ArrayUtils.add(values, Character.forDigit(0, 10)));
//	        } else {
//	            return new String(ArrayUtils.add(values, Character.forDigit(checkDigit, 10)));
//	        }
//		 Faker.instance().expression("#{regexify '" + PHONE_NUMER_REGEX + "'}")
		 return faker.code().ean13();
	 }

}
