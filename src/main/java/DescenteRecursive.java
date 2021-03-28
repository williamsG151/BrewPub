

/** @author Ahmed Khoumsi */

import java.util.ArrayList;

/** Cette classe effectue l'analyse syntaxique
 */
public class DescenteRecursive {

  // Attributs
  private ArrayList<Terminal> terminalChain;
  int index = 0;
  int length;
  ElemAST root = null;
  ElemAST elemCourant = null;
  Terminal ULcourant = null;


/** Constructeur de DescenteRecursive :
      - recoit en argument le nom du fichier contenant l'expression a analyser
      - pour l'initalisation d'attribut(s)
 */
public DescenteRecursive(String in, ArrayList<Terminal> chain) {
    terminalChain = chain;
    length = chain.size();
}


/** AnalSynt() effectue l'analyse syntaxique et construit l'AST.
 *    Elle retourne une reference sur la racine de l'AST construit
 */
public ElemAST AnalSynt() {
    ULcourant = terminalChain.get(0);
    E();
    return null;
}

private void createAST(String attendu){
    if(attendu.equals("C")||attendu.equals("ID")){
      FeuilleAST feuille = new FeuilleAST(ULcourant);
      elemCourant = feuille;
      if(root == null){
        root = feuille;
      }
      ULcourant = terminalChain.get(index++);

    }else if(attendu.equals("S1")){
      NoeudAST noeud = new NoeudAST(ULcourant);
      if(root instanceof NoeudAST){
        noeud.setEnfG(elemCourant.getEnfD());
        elemCourant.setEnfD(noeud);
        elemCourant = noeud;
      }else {
        noeud.setEnfG(elemCourant);
        root = noeud;
        elemCourant = noeud;
      }
      ULcourant = terminalChain.get(index++);

    }else if(attendu.equals("S2")){
      NoeudAST noeud = new NoeudAST(ULcourant);
      noeud.setEnfG(root);
      root = noeud;
      elemCourant = noeud;
    }else if(attendu.equals("Pg")){

    }else if(attendu.equals("Pd")){

  }
    else{
      erreurSynt(ULcourant.chaine);
    }
}

// Methode pour chaque symbole non-terminal de la grammaire retenue
// ... 
// ...
  private void E(){
    T();
    if("S2".equals(ULcourant.type)){
      createAST("S2");
      E();
    }
  }

  private void T(){
    F();
    if("S1".equals(ULcourant.type)){
      createAST("S1");
      T();
    }
  }

  private void F(){
    if("C".equals(ULcourant.type)){
      createAST("C");
    }else if("Pg".equals(ULcourant.type)){
      createAST("Pg");
      E();
      if("Pg".equals(ULcourant.type)){
        createAST("Pd");
      }else{
        erreurSynt(ULcourant.chaine);
      }
    }else{
      erreurSynt(ULcourant.chaine);
    }
  }



/** ErreurSynt() envoie un message d'erreur syntaxique
 */
public void erreurSynt(String s)
{
    //
}



  //Methode principale a lancer pour tester l'analyseur syntaxique 
  public static void main(String[] args) {
    String toWriteLect = "";
    String toWriteEval = "";

    System.out.println("Debut d'analyse syntaxique");
    if (args.length == 0){
      args = new String [2];
      args[0] = "ExpArith.txt";
      args[1] = "ResultatSyntaxique.txt";
    }
    DescenteRecursive dr = new DescenteRecursive(args[0]);
    try {
      ElemAST RacineAST = dr.AnalSynt();
      toWriteLect += "Lecture de l'AST trouve : " + RacineAST.LectAST() + "\n";
      System.out.println(toWriteLect);
      toWriteEval += "Evaluation de l'AST trouve : " + RacineAST.EvalAST() + "\n";
      System.out.println(toWriteEval);
      Writer w = new Writer(args[1],toWriteLect+toWriteEval); // Ecriture de toWrite 
                                                              // dans fichier args[1]
    } catch (Exception e) {
      System.out.println(e);
      e.printStackTrace();
      System.exit(51);
    }
    System.out.println("Analyse syntaxique terminee");
  }

}

