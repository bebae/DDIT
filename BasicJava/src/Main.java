import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.*;

public class Main {

	public static void main(String[] args)  throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = 0;
		String text = bf.readLine();
		String[] word = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
//		Pattern p = Pattern.compile("[c=][c-][dz=][d-][lj][nj][s=][z=]");
//		Matcher m = p.matcher(text);
		
		
		
		for (int i = 0; i < word.length; i++) {
			if (text.indexOf(word[i]) != 0) {
				num += text.length() - text.replace(String.valueOf(word[i]), "").length();
			} else {
				num++;
			}
		}
		System.out.println(num);
		
		
		bf.close();
	}
}












