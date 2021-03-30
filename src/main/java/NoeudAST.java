/** @author Ahmed Khoumsi */

/** Classe representant une feuille d'AST
 */
public class NoeudAST extends ElemAST {

  // Attributs
  private final Terminal operateur;
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

  public ElemAST getParent(){
    return parent;
  }

  public void setParent(ElemAST parent) {
    this.parent = parent;
  }

  /** Evaluation de noeud d'AST
   */
  public int EvalAST( ) {
    int gauche = enfG.EvalAST();
    int droit = enfD.EvalAST();
    Integer result = 0;
    switch(operateur.chaine){
      case "+":
        result = gauche + droit;
        break;
      case "-":
        result = gauche - droit;
        break;
      case "*":
        result = gauche * droit;
        break;
      case "/":
        result = gauche / droit;
        break;
      default:
        result = null;
        System.out.println("ERROR: An operator has not been defined");
    }
    return result;
  }


  /** Lecture de noeud d'AST
   */
  public String LectAST( ) {
    String result = String.format("%s %s %s", enfG.LectAST(), enfD.LectAST(), operateur.chaine);
    return result;
  }
}


