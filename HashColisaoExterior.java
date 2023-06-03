import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HashColisaoExterior {
	
	public ArvoreBinariaBusca vetor[];
	public int nElementos;
	
	public HashColisaoExterior(int capacidade) {
		this.vetor = new ArvoreBinariaBusca[capacidade];
		for (int i = 0; i < vetor.length; i++) {
			this.vetor[i] = new ArvoreBinariaBusca();
		}
		this.nElementos = 0;
	}
	
	public int tamanho() {
		return this.nElementos;
	}
	
	public void imprime() {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i].imprimeEmOrdem();
		}
	}
	
	private int funcaoHashDiv(String elemento) {
		return tratarElemento(elemento) % this.vetor.length;
	}
	
	public void insere(String elemento) {
		int endereco = funcaoHashDiv(elemento);

		PalavraChave palavra = new PalavraChave(elemento);

		this.vetor[endereco].insere(palavra);
		this.nElementos++;
	}
	
	public boolean contem(String elemento) {
		int endereco = funcaoHashDiv(elemento);

		PalavraChave palavra = new PalavraChave(elemento);

		return this.vetor[endereco].busca(palavra);
	}

	public int tratarElemento(String elemento){

		String regex = "[^a-zA-Z0-9\\s]";
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(elemento);
        
        String resultado = matcher.replaceAll(" ");

		int dado = resultado.toUpperCase().charAt(0);

		return dado - 65;
	}
}