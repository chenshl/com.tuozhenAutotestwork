package baseCode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class ParseProperties {  //封装properties,通过propertiespath直接调用
	
	private Properties pro = new Properties();
	String value = null;
	
	public ParseProperties(String propertiespath){
		this.loadProperties(propertiespath);
		
	}
	
	private void loadProperties(String propertiespath){
		try {
			InputStream in = new FileInputStream(propertiespath);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			pro.load(br);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	//通过keyname获取value值
	public String getValue(String keyname){
		value = pro.getProperty(keyname).trim();
		try {
			value = new String(value.getBytes("UTF-8"),"UTF-8");
			//此方法与UnsupportedEncodingException包相关联，需引入UnsupportedEncodingException包
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return value;
	}
	
	//应用方法实例
//	public  static void main(String[] args){
//		ParseProperties a = new ParseProperties("G:/SeleniumTraining1/FireflyAutomation/trunk/tool/test.properties");
//	
//		System.out.println(a.getValue("password"));
//	}

}
