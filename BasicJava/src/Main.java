import java.io.*;

public class Main {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word[] = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String str = br.readLine();

		for(String search : word)
            while(str.contains(search))
            	str = str.replaceFirst(search,"1");

        System.out.println(String.valueOf(str.length()));
	}
}












