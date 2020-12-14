package hospitalisation;

public class Lits {
    int numero_lit;
    boolean estOccupe = false;

    public Lits(int numero_lit) {
        this.numero_lit = numero_lit;
    }

    public void liberer_lit() {
        this.estOccupe = false;
        System.out.println(this + "a bien été libéré");
    }

    @Override
    public String toString() {
        return "Lit{" + "numero_lit=" + numero_lit + '}';
    }

}
