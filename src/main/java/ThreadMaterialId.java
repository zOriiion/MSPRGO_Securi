import java.io.*;
import java.util.ArrayList;

public class ThreadMaterialId extends Thread {

    ArrayList<Materiel> materielArray = new ArrayList<>();

    @Override
    public void run(){
        File file = new File("data\\liste.txt");

        Reader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(reader);

        String line = null;
        while (true) {
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] materielLineSplitted = line.split("\t");
            materielArray.add(new Materiel(materielLineSplitted[0], materielLineSplitted[1]));
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
