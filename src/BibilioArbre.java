import java.io.File;
import java.io.IOException;
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
    void affiche() {
         if(filsGauche !=null)
            filsGauche.affiche();
         if(!Auteur.equals(""))
             System.out.println("aut="+Auteur+"Titre ="+ Titre);
         if(filsDroit != null)
             filsDroit.affiche();


    }

     static Object charger(String nomFichier) {
    }

     void saisie() {
         Scanner sc =  new Scanner(System.in);

         int i;
         for(i=0;i<=5;i++){
             System.out.println("Entre l'auteur");
             String auteur = sc.nextLine();

             System.out.println("Entre le Titre");
             String titre = sc.nextLine();
             inserer(auteur, titre);
         }
    }

     void sauvegarder(String nomFichier) throws IOException {

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
