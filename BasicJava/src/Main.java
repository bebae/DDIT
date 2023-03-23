import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean run = true;
		String text = "";
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int i = 0;
		while (st.hasMoreTokens()) {
		text = st.nextToken();
		
			bw.write(text+"\n");
			if (i%3 == 1) {
				bw.write(String.format("%d\n", i));
			}
			if (i%3 == 2) {
				bw.write(String.format("%d\n", i));
			}
			bw.flush();
			i++;
		}
		
		
        
	}
}












