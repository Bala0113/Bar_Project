package bar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Beolvasas {
	
	public static ArrayList<Ital>ItalLap=new ArrayList<Ital>();

	
	public static void beolvasas() {
		

        BufferedReader reader;
        ItalLap.removeAll(ItalLap);
        try {
            reader = new BufferedReader(new FileReader(".\\ItalLap.txt",StandardCharsets.UTF_8 ));
            String line = reader.readLine();
            while(line != null) {
            	String[]parts = line.split(" ");
            	Integer ar = Integer.parseInt(parts[1]);
            	Ital egyeb = new Ital(parts[0],ar, parts[2], parts[3]);
                ItalLap.add(egyeb);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e)  {
            e.printStackTrace();
        }
	}
}