

/** @author Ahmed Khoumsi */

import java.util.ArrayList;

/** Cette classe effectue l'analyse lexicale
 */
public class AnalLex {

  String sentence;
  int length;
  int index = 0;
  int state = 0;
  Terminal result = null;
  String UL = "";
  String type = null;
  Boolean error = false;

  //Expressions régulières
  String ID = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  String C = "0123456789";
  String S = "+*/-";
  String P = "()";

  ArrayList<Terminal> terminalChain;


  /**
   * Constructeur pour l'initialisation d'attribut(s)
   */
  public AnalLex(String sentence) {
    this.sentence = sentence.replaceAll("\\s+", "");
    length = this.sentence.length();
    terminalChain = new ArrayList<>();
  }


  /**
   * resteTerminal() retourne :
   * false  si tous les terminaux de l'expression arithmetique ont ete retournes
   * true s'il reste encore au moins un terminal qui n'a pas ete retourne
   */
  public boolean resteTerminal() {
    return !((index >= length) || error );
  }

  /**
   * prochainTerminal() retourne le prochain terminal
   * Cette methode est une implementation d'un AEF
   */
  public Terminal prochainTerminal() {

    while(state != -1){
      String current = String.format("%c", sentence.charAt(index));
      if (state == 0) {
        if (C.contains(current)) {
          state = 99;
          UL += current;
        }else{
          erreurLex(current);
          result = new Terminal("ERROR", type);
          state = -1;
          error = true;
        }
      } else if (state == 99) {
        closeUL();
      }
    }
    resetValues();
    return result;
  }

  private void closeUL(){
    result = new Terminal(UL, type);
    terminalChain.add(result);
    state = -1;
    index++;
  }

  private void resetValues(){
    UL = "";
    state = 0;
  }

  /**
   * ErreurLex() envoie un message d'erreur lexicale
   */
  public void erreurLex(String s) {

  }

  
  //Methode principale a lancer pour tester l'analyseur lexical
  public static void main(String[] args) {
    String toWrite = "";
    System.out.println("Debut d'analyse lexicale");
    if (args.length == 0){
    args = new String [2];
            args[0] = "ExpArith.txt";
            args[1] = "ResultatLexical.txt";
    }
    Reader r = new Reader(args[0]);

    AnalLex lexical = new AnalLex(r.toString()); // Creation de l'analyseur lexical

    // Execution de l'analyseur lexical
    Terminal t = null;
    while(lexical.resteTerminal()){
      t = lexical.prochainTerminal();
      toWrite +=t.chaine + "\n" ;  // toWrite contient le resultat
    }				   //    d'analyse lexicale
    System.out.println(toWrite); 	// Ecriture de toWrite sur la console
    Writer w = new Writer(args[1],toWrite); // Ecriture de toWrite dans fichier args[1]
    System.out.println("Fin d'analyse lexicale");
  }
}
