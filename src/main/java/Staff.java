import java.util.ArrayList;

public class Staff {

    String nom;
    String prenom;
    String poste;
    String mdp;
    ArrayList<String> arrayMateriel;

    public Staff(String nom, String prenom, String poste, String mdp, ArrayList<String> arrayMateriel){
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.mdp = mdp;
        this.arrayMateriel = arrayMateriel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPoste() {
        return poste;
    }

    public String getMdp() {
        return mdp;
    }

    public ArrayList<String> getArrayMateriel() {
        return arrayMateriel;
    }
}
