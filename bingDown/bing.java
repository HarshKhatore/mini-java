package down;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.imageio.ImageIO;

public class bing {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
		
		
		URL url = new URL("http://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=en-US");
      
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String date1 =  dateFormat.format(cal.getTime());
		String loc ="";
		Scanner sc = new Scanner(url.openStream());
		String br = sc.nextLine();
		String imurl="http://www.bing.com";
			
			
			JSONObject obj = new JSONObject(br);
			JSONArray data =obj.getJSONArray("images");
			JSONObject imagge = data.getJSONObject(0);
			imurl =	imurl+	imagge.getString("url");
				
			URL url2 = new URL(imurl);
			BufferedImage img = ImageIO.read(url2);
			loc="D:\\image\\"+date1+".jpg";
			System.out.println(loc);
	        File file = new File(loc);
	        ImageIO.write(img, "jpg", file);
			
			
	}

}
