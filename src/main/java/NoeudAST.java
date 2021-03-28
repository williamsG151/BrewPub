
/** @author Ahmed Khoumsi */

/** Classe representant une feuille d'AST
 */
public class NoeudAST extends ElemAST {

  // Attributs
  private Terminal operateur;
  private ElemAST enfG;
  private ElemAST enfD;

  /** Constructeur pour l'initialisation d'attributs
   */
  public NoeudAST(Terminal operateur, ElemAST enfG,ElemAST enfD ) {
      this.operateur = operateur;
      this.enfG = enfG;
      this.enfD = enfD;
  }

 
  /** Evaluation de noeud d'AST
   */
  public int EvalAST( ) {

    return 0;
  }


  /** Lecture de noeud d'AST
   */
  public String LectAST( ) {

    return "";
  }

}


