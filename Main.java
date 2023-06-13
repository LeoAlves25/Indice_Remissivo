import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner chave = new Scanner(new File("./Textos/exemplos2/chaves4.txt"));
        Scanner texto = new Scanner(new File("./Textos/exemplos2/texto4.txt"));
        int linha = 0;
        
        //Pegar numero da linha (aumentando cada vez que sobe a linha
        PrintStream ps = new PrintStream("./Textos/exemplos2/indice4.txt", "UTF-8");
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

                if(text.length() > 0){
                    if(palavrasChaves.contem(text)) {
                        palavrasChaves.insereLinha(text,linha);
                        
                    }
                }
        	}
        }

        palavrasChaves.imprime();

    }

    public static String removerPontuacao(String palavra) {
        palavra = palavra.replaceAll("[^-a-zA-Z\u00C0-\u00FF]", "").replaceAll("[0-9]","");
        if(palavra.length() == 0) {
            return palavra;
        }
        String cap = palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
        return cap;
    }
}