import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/** 
* <p>Title: Q1 </p> 
* <p>Description: </p> 
* <p>Copyright: Copyright (c) 2017</p> 
* <p>Company: </p> 
* @author Xi Zhang 
* @version 1.0
*/ 
public class IPValidationRegex {

	private String ip;
	private static final String REG = "^(((0?\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((0?\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))";

	public IPValidationRegex() {

	}

	public IPValidationRegex(String ip) {
		super();
		this.ip = ip;
	}
	
	/**
	 * 0-99: 0?\d{1,2}
	 * 100-199: 1\d{2}
	 * 200-249: 2[0-4]\d
	 * 250-255: 25[0-5]
	 */
	public boolean isValidIp() {

		return ip.matches(REG);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public static void main(String[] args) {

		try {
			File file = new File(System.getProperty("user.dir") + "\\" + args[0]);
			if (file.isFile() && file.exists()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
				BufferedReader bfreader = new BufferedReader(reader);

				String line = null;

				while ((line = bfreader.readLine()) != null) {
					line = line.trim();
					IPValidationRegex ipv = new IPValidationRegex(line);
					if (!ipv.isValidIp())
						System.out.println(line);
				}

				bfreader.close();
				reader.close();
			} else {
				System.out.println("error: no such file");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
