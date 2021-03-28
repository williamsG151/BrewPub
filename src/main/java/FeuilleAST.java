
/** @author Ahmed Khoumsi */

/** Classe representant une feuille d'AST
 */
public class FeuilleAST extends ElemAST {

  private Terminal terminal;



/**Constructeur pour l'initialisation d'attribut(s)
 */
  public FeuilleAST(Terminal courrant) {
        this.terminal = courrant;
  }


  /** Evaluation de feuille d'AST
   */
  public int EvalAST( ) {
    return 0;
  }


 /** Lecture de chaine de caracteres correspondant a la feuille d'AST
  */
  public String LectAST( ) {
    return "";
  }

}
