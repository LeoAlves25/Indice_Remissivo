import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Scanner chave = new Scanner(new File("./chaves.txt"), "UTF-8");
        Scanner texto = new Scanner(new File("./texto.txt"), "UTF-8");

        PrintStream ps = new PrintStream("./indice1.txt", "UTF-8");
        System.setOut(ps);

        HashColisaoExterior palavrasChaves = new HashColisaoExterior(26);

        

        while (chave.hasNext()) {
            String palavra = chave.next();
        
            palavra.replace(",", "").replace(".","").replace(";","").replace(":","").replace("?", "").replace("!", "");

            palavrasChaves.insere(palavra);
        }

        palavrasChaves.imprime();

    }
}