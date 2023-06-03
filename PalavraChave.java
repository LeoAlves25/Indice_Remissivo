class PalavraChave {
    String chave;
    ListaEncadeada ocorrencias;
    
    public PalavraChave(String chave) {
        this.chave = chave;
        this.ocorrencias = new ListaEncadeada();
    }
}
