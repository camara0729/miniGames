import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
	public static String sorteiaPalavra (String[] palavras) {
		Random r = new Random();
		int numero = r.nextInt(5);
		
		String aleatorio;
		aleatorio = palavras[numero];
		return aleatorio;
	}
	
	public static char[] criaGabarito (String palavra) {
		char[] gabarito;
		gabarito = palavra.toCharArray();
		return gabarito;
	}
	
	public static int contaLetra (char[] gabarito, char letra) {
		int ocorrencias = 0;
                for (int i = 0; i < gabarito.length; i++) {
                    if (gabarito[i] == letra) {
                        ocorrencias++;
                    }
                }
                return ocorrencias; // retorna o numero de vezes que a letra aparece na palavra 
	}
	
	public static void substituiLetra (char[] gabarito, char[] acertadas, char letra) {
		for(int i = 0; i < gabarito.length; i++) {
			if(gabarito[i] == letra) {
				acertadas[i] = letra;
			}
		}
	}
	
	public static void imprimeAcertos (char[] acertadas, int posicao) {
		
		if(posicao<acertadas.length){
			System.out.print(acertadas[posicao]+"\t");
			imprimeAcertos(acertadas, posicao+1);
		}
	}                                      
        
	public static void main (String[] args) {
		try (Scanner s = new Scanner(System.in)) {
            char escolha;
                    
            		//letra A da main
            
            String[] palavras = {"Pedro", "Luiz", "Sales", "Guerra", "Camara"};

            do {
                    //letra B da main
            	
                    System.out.println("Digite o seu nome: ");
                    String pessoa;
            pessoa = s.nextLine();
            while(pessoa.length() < 7) {
            	System.out.println("Erro. O nome deve conter 7 ou mais letras. Digite novamente");
            	pessoa = s.nextLine();
            }
                    
                    //letra C da main
                    String NomeAleatorio = sorteiaPalavra(palavras);
            String palavra = NomeAleatorio;
                    
                    //letra D da main
                    
            char[] gabarito;
            gabarito = criaGabarito(palavra);// o array de caracteres "gabarito" do main recebe o array de caracteres vindo da fun�ao criaGabarito.
                    
            char[] acertadas = new char[gabarito.length];// o array de char acertadas
                    for(int i = 0 ; i < acertadas.length ; i++){
                        acertadas[i] = '_';
                    }
                    
                    //letra E da main 
                    
                    int conta_letra; // esse int vai receber o numero que o metodo contaLetras retorna, e sendo zero ele abaixa o numero de tentaivas que o jogador tem para ganhar o jogo.
                    int tentativas = 5;
                    int chave = 0; // uma chave pra quando o usuario exceder u numero de tentativas que ele tem pra ganhar o jogo.
                    int ganhou = 0; // "ganhou" vai servir como uma chave para o while do jogo, se ele ganhar antes das tentativas acabarem o loop fecha e se as tentativas acabarem o loop tbm fecha.
                    String testa_acertadas;
                    while(chave != 1){
                        
                    	//letra E - a
                    	
                    	int posicao = 0;
                    	imprimeAcertos(acertadas,posicao);                   
                                          
                        //letra E - b
                        
                    	System.out.println("digite uma letra:");
                        char letra = s.next().charAt(0);
                        
                        //letra E - c
                        
                        conta_letra = contaLetra(gabarito,letra);
                        if(conta_letra == 0){
                            tentativas--;
                            System.out.println("essa letra nao esta presente na palavra, voce perdeu uma das suas 5 tentaivas e agora tem "+tentativas+" para ganhar o jogo.");
                        
                        }else if(conta_letra > 0){ // 
                            substituiLetra(gabarito, acertadas, letra);
                            //se o usu�rio acertar a letra a fun�ao acima � chamada e substitui o underscore pela letra acertada.
                        }
                        if(tentativas == 0){
                            chave = 1;  
                            
                        }else {
                        	testa_acertadas = acertadas.toString();
                        }
                        
                        //letra E - d
                        //comparar a string palavra com uma string "teste_acertadas" para poder saber se o usuario ganhou o jogo.
                        
                        testa_acertadas = acertadas.toString();
                        if(palavra.equalsIgnoreCase(testa_acertadas) == true){ 
                            chave = 1;
                        }
                        
                    }
                    
                    	//letra F
                    
                    if(ganhou == 1){
                        System.out.println("\nganhou\n");
                        //System.out.println("Parab�ns " + pessoa + "sua pontua��o foi: " + (testa_acertadas - 2 * pontua��o));
                    }else{
                        System.out.println("\nperdeu\n");
                    }
                    
                    	//letra G
                    
                    System.out.println("Deseja jogar novamente?");
                    escolha = s.next().charAt(0);
                    
            	}while(escolha == 's');
        }
	}
}
	
