/** @author Ahmed Khoumsi */

/** Classe representant une feuille d'AST
 */
public class NoeudAST extends ElemAST {

  // Attributs
  private Terminal operateur;
  private ElemAST enfG=null;
  private ElemAST enfD=null;

  private ElemAST parent;

  /** Constructeur pour l'initialisation d'attributs
   */
  public NoeudAST(Terminal operateur) {
      this.operateur = operateur;
  }

  @Override
  public void setEnfD(ElemAST enfD) {
    this.enfD = enfD;
  }

  @Override
  public void setEnfG(ElemAST enfG){
    this.enfG = enfG;
  }

  @Override
  public ElemAST getEnfD() {
    return enfD;
  }

  @Override
  public ElemAST getEnfG(){
    return enfG;
  }

  public ElemAST getParent(){
    return parent;
  }

  public void setParent(ElemAST parent) {
    this.parent = parent;
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


