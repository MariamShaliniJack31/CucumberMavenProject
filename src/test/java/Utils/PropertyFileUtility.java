//package Utils;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//import org.testng.Assert;
//import Base.DriverScript;
//
//public class PropertyFileUtility extends DriverScript {
//	
//	public Properties PropertyFileInitialization(String PathOfFile) {
//		Properties properties = null ;
//		try {
//			File file = new File(PathOfFile);
//			FileInputStream fileInput;
//			fileInput = new FileInputStream(file);
//			properties= new Properties();
//			properties.load(fileInput);
//			fileInput.close();
//		} catch (FileNotFoundException e1) {
//			reporter.Log(ReporterType, "ERROR", "PropertyFileInitialization - FileNotFoundException: "+ e1.toString());
//			e1.printStackTrace();
//			Assert.assertFalse(true);
//		} catch (IOException e2) {
//			reporter.Log(ReporterType, "ERROR", "PropertyFileInitialization - IOException: "+ e2.toString());
//			e2.printStackTrace();
//			Assert.assertFalse(true);
//		} catch (Exception e3) {
//			reporter.Log(ReporterType, "ERROR", "PropertyFileInitialization - Exception: "+ e3.toString());
//			e3.printStackTrace();
//			Assert.assertFalse(true);
//		}
//		return properties;
//	}
//	
//}