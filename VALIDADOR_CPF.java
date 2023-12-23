import java.util.Scanner;

public class App {
    
    //Função que calcula o digito verificador
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
  
      int []cpf= new int[11];
      int [] resultados = new int [9];
      int [] resultadosDois = new int [10]; 
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
      
        //Calculo MOD 11 e soma dos valores para atribuição no vetor resultados
        for (int i = 0; i < cpf.length; i++) {
            if(i <= 8){
                result = cpf[i] * decremento;
                decremento--;
                resultados[i] = (result);
                soma += resultados[i];
            }
        }
        
        //Chamando a função que retorna o digito verificador
        int digitoUm = verificaDigito(soma, digito, resto);
        System.out.println("O Primeiro digito do CPF é: " + digitoUm);
        
        digitos[0] = digitoUm;
        
        // //Calculo MOD 11 e soma dos valores para atribuição no vetor resultados
        decremento = 11;
        soma = 0;
        
         for (int i = 0; i < cpf.length; i++) {
             if(i <= 9){
             result = cpf[i] * decremento;
             decremento--;
             resultadosDois[i] = (result);
             soma += resultadosDois[i];
                };
            };
        
         //Chamando a função que retorna o digito verificador
         int digitoDois = verificaDigito(soma, digito, resto);
         System.out.println("O Segundo digito do CPF é: " + digitoDois);
        
         digitos[1] = digitoDois;
        
         if (digitos[0] == cpf[9] && digitos[1] == cpf[10]) {
             System.out.println("O CPF É VALIDO");
        
        } else {
             System.out.println("O CPF é invalido");
                
         }
        
        }
    
    }
