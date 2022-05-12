import java.io.*;
import java.util.ArrayList;

public class ThreadStaffInfo extends Thread {

    ArrayList<Staff> staffArray = new ArrayList<>();
    ArrayList<String> staffIdArray = new ArrayList<>();

    public ThreadStaffInfo(ArrayList<String> staffIdArray){
        this.staffIdArray = staffIdArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < staffIdArray.size(); i++) {
            File file = new File("data\\" + staffIdArray.get(i) + ".txt");

            Reader reader = null;
            try {
                reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(reader);

            String line = null;
            int position = 0;
            String nom = null;
            String prenom = null;
            String poste = null;
            String mdp = null;
            ArrayList<String> materielUtilise = new ArrayList<>();
            while (true) {
                position++;
                try {
                    if (!((line = br.readLine()) != null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (position == 1) {
                    nom = line;
                } else if (position == 2) {
                    prenom = line;
                } else if (position == 3) {
                    poste = line;
                } else if (position == 4) {
                    mdp = line;
                } else if (position >= 6) {
                    materielUtilise.add(line);
                }
            }
            staffArray.add(new Staff(nom, prenom, poste, mdp, materielUtilise));
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
