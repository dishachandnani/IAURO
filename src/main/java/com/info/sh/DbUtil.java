package com.info.sh;

import java.io.InputStream;
import java.util.Properties;

public class DbUtil {

	public static String DB_URL = "";
	public static String DB_USER = "";
	public static String DB_PASS = "";

	static {
		try (InputStream in = DbUtil.class.getResourceAsStream("/jdbc.properties")) {
			Properties props = new Properties();
			props.load(in);
			DB_URL = props.getProperty(BookConstant.DB_URL);
			DB_USER = props.getProperty(BookConstant.DB_USER);
			DB_PASS = props.getProperty(BookConstant.DB_PASSWORD);
		} catch (Exception e) {
			System.out.println("Exception in DbUtil : "+e);
		}
	}
}
