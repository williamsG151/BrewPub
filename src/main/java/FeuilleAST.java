
/** @author Ahmed Khoumsi */

/** Classe representant une feuille d'AST
 */
public class FeuilleAST extends ElemAST {

  private Terminal terminal;
  private ElemAST parent = null;


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

  public ElemAST getParent(){
      return parent;
  }

  public void setParent(ElemAST parent){
      this.parent = parent;
  }

 /** Lecture de chaine de caracteres correspondant a la feuille d'AST
  */
  public String LectAST( ) {
    return "";
  }

}
