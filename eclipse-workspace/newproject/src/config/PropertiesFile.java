package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import newpackage.MyClass;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	
	public static void main(String[] args) {
		readPropertiesFile();
		writePropertiesFile();
	}
	
	public static void readPropertiesFile() {
		
		try {
			InputStream input = new FileInputStream("C:\\Users\\Ayan\\eclipse-workspace\\newproject\\src\\config\\config.properties");
			prop.load(input);
			//System.out.println(prop.getProperty("browser"));
			MyClass.browser = prop.getProperty("browser");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writePropertiesFile() {
		try {
			OutputStream output = new FileOutputStream("C:\\\\Users\\\\Ayan\\\\eclipse-workspace\\\\newproject\\\\src\\\\config\\\\config.properties");
			prop.setProperty("browser", "Chrome");
			prop.store(output, "Result Pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
