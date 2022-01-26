import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class BibilioArbre implements Serializable {
     String Auteur,Titre;
     BibilioArbre filsDroit,filsGauche;

     BibilioArbre(){
         Auteur ="";
         Titre = "";
         filsDroit =null;
         filsGauche= null;
     }
    //La racine c'est la variable auteur

     BibilioArbre(String a, String t){
         this();
         Auteur = a;
         Titre  = t;
     }

     void inserer(String a, String t){
         if(Auteur.equals(""))
         {Auteur = a; Titre=t;}
         else{
             if(a.compareTo(Auteur)<=0) {
                 if(filsGauche != null) {
                     filsGauche.inserer(a,t);
                 }else {
                    filsGauche= new BibilioArbre(a,t);
                 }
             }else {
                if(filsDroit !=null) {
                    filsDroit.inserer(a,t);
                }else {
                    filsDroit =  new BibilioArbre(a,t);
                }
             }
         }

     }


    private static Object charger(String nomFichier) {
    }

    private void saisie() {
    }

    private void sauvegarder(String nomFichier) {
    }

    private void affiche() {
    }

    public static void main(String[] args) {
         BibilioArbre B;
        Scanner sc =  new Scanner(System.in);

        System.out.println("Entre Le nom  du fichier");
        String nomFichier = sc.nextLine();

        File f = new File(nomFichier);
        if(f.exists()) B = (BibilioArbre)BibilioArbre.charger(nomFichier);
        else B =  new BibilioArbre();

        B.saisie();
        B.affiche();
        B.sauvegarder(nomFichier);
        }



}
}
