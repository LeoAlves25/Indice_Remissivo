import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner chave = new Scanner(new File("./chaves.txt"), "UTF-8");
        Scanner texto = new Scanner(new File("./texto.txt"), "UTF-8");
        int linha = 0;
        
        //Pegar numero da linha (aumentando cada vez que sobe a linha
        PrintStream ps = new PrintStream("./indice1.txt", "UTF-8");
        System.setOut(ps);

        HashColisaoExterior palavrasChaves = new HashColisaoExterior(26);

        

        while (chave.hasNext()) {
            String palavra = chave.next();
        
            palavra.replace(",", "").replace(".","").replace(";","").replace(":","").replace("?", "").replace("!", "");

            palavrasChaves.insere(palavra);
        }
        
        while (texto.hasNextLine()) {
        	linha++;
        	String textoPalavra = texto.nextLine();
        	Scanner palavraTexto = new Scanner(textoPalavra);

        	while (palavraTexto.hasNext()) {
        		String text = palavraTexto.next();

                text.replace(",", "").replace(".","").replace(";","").replace(":","").replace("?", "").replace("!", "");
        		if(palavrasChaves.contem(text)) {
        			palavrasChaves.insereLinha(text,linha);
        			
        		}
        	}
        }

        palavrasChaves.imprime();

    }
}