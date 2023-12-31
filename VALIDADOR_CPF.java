package validador_CPF;
import java.util.ArrayList;
import java.util.Scanner;
public class validaCPF {
	

    /* 
   	VALIDADOR DE CPF
  
    NAO EXISTE a necessidade do ARRAYLIST no código, pórém o código era pra fins didaticos, para manipulação do ARRAYLIST
    */
	
	// Função que retorna o digito verificador
    public static int verificaDigito (int soma, int digito, int resto){
        resto = soma % 11;
 
        if(resto < 2){
            digito = 0;
        }else{
            digito = 11 - resto;
        }
        
        return digito;
    }
   

    public static void main(String args[]) {
    	

      ArrayList<Integer> resultados = new ArrayList<>();
      int []cpf= new int[11];
      int [] digitos = new int[2];
      int digito = 0, resto = 0, soma=0, result = 0, decremento = 10;
      String cpfOriginal = "";
      
      Scanner input = new Scanner(System.in);
      
      System.out.println("Informe o CPF: ");
      cpfOriginal = input.next();
      
      
      for (int i = 0; i < cpfOriginal.length(); i++) {
      char caractere = cpfOriginal.charAt(i);
      cpf[i] = Character.getNumericValue(caractere);
        }
      
        //Calculo primeiro digito
        for (int i = 0; i < cpf.length; i++) {
            if(i <= 8){
                result = cpf[i] * decremento;
                decremento--;
                resultados.add(result);
                	
            }
        }
        for(Integer iN:resultados) {
    		soma += iN;
    	}
        
        //Chamando a função que retorna o digito verificador
        int digitoUm = verificaDigito(soma, digito, resto);
        System.out.println("O Primeiro digito do CPF é: " + digitoUm);
        
        digitos[0] = digitoUm;
        
        // Calculo segundo digito
        resultados.clear();
        decremento = 11;
        soma = 0;
        
        for (int i = 0; i < cpf.length; i++) {
            if(i <= 9){
                result = cpf[i] * decremento;
                decremento--;
                resultados.add(result);
                	
            }
        }
        
        for(Integer iN:resultados) {
    		soma += iN;
    	}
        
        
         //Chamando a função que retorna o digito verificador
         int digitoDois = verificaDigito(soma, digito, resto);
         System.out.println("O Segundo digito do CPF é: " + digitoDois);
        
         digitos[1] = digitoDois;
        
         if (digitos[0] == cpf[9] && digitos[1] == cpf[10]) {
             System.out.println("O CPF " + cpfOriginal + " É VALIDO");
        
        } else {
             System.out.println("O CPF " + cpfOriginal + " É INVALIDO");
                
        }
        
        
    
    	}
    
    }



