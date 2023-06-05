public class ListaEncadeada {
    public class Nodo {

        public Integer elemento;
        public Nodo proximo;

        public Nodo(Integer elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }

    }

    private Nodo inicio;
    private int nElementos;

    public ListaEncadeada() {
        this.inicio = null;
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public void limpa() {
        this.inicio = new Nodo(null);
        this.nElementos = 0;
    }

    public void imprime() {

        if (this.nElementos == 0) {
            System.out.println();
            return;
        }

        Nodo cursor = this.inicio;

        for (int i = 0; i < this.nElementos - 1; i++) {
            System.out.print(cursor.elemento + " ");
            cursor = cursor.proximo;
        }

        System.out.println(cursor.elemento);
    }

    public void insereFinal(Integer elemento) {

        Nodo novo = new Nodo(elemento);

        if (this.estaVazia()) {

            this.inicio = novo;
        } else {

            Nodo cursor = this.inicio;
            for (int i = 0; i < this.nElementos - 1; i++) {
                cursor = cursor.proximo;
            }

            cursor.proximo = novo;
        }

        this.nElementos++;
    }
}
