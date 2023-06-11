import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner chave = new Scanner(new File("./Textos/chaves.txt"), "UTF-8");
        Scanner texto = new Scanner(new File("./Textos/texto.txt"), "UTF-8");
        int linha = 0;
        
        //Pegar numero da linha (aumentando cada vez que sobe a linha
        PrintStream ps = new PrintStream("./Textos/indice1.txt", "UTF-8");
        System.setOut(ps);

        HashColisaoExterior palavrasChaves = new HashColisaoExterior(26);

        

        while (chave.hasNext()) {
            String palavra = chave.next();
        
            palavra = removerPontuacao(palavra);

            palavrasChaves.insere(palavra);
        }
        
        while (texto.hasNextLine()) {
        	linha++;
        	String textoPalavra = texto.nextLine();
        	Scanner palavraTexto = new Scanner(textoPalavra);

        	while (palavraTexto.hasNext()) {
        		String text = palavraTexto.next();

                text = removerPontuacao(text);

        		if(palavrasChaves.contem(text)) {
        			palavrasChaves.insereLinha(text,linha);
        			
        		}
        	}
        }

        palavrasChaves.imprime();

    }

    public static String removerPontuacao(String palavra) {
        palavra = palavra.replaceAll("[^-a-zA-Z0-9\u00C0-\u00FF]", "");
        String cap = palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
        return cap;
    }
}