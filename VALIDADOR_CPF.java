public class MyClass {
    public static void main(String args[]) {
  
      int []cpf={3,8,6,7,8,1,4,6,8,6,9};
      int [] resultados = new int [11];
      int addResultados=0, digito = 0, resto = 0, soma=0, result = 0, decremento = 10;
      
        //LENDO O CPF E CALCULANDO O RESULTADO DOS PRIMEIROS CALCULOS
        for (int i = 0; i < cpf.length; i++) {
            if(i <= 8){
                result = cpf[i] * decremento;
                decremento--;
                System.out.print(result + " ");
                resultados[i] = (result);

            }
        }

        //SOMA VETOR RESULTADOS
        System.out.println();
        for(int i = 0; i < resultados.length; i++){
            soma = soma + resultados[i];
            System.out.println(resultados[i] + " ");
             
        }
        System.out.println(soma);
        resto = soma % 11;
        System.out.println(resto);
        
        if(resto < 2){
            digito = 0;
        }else{
            digito = 11 - resto;
        }
        
        addResultados = digito * 2

           


        System.out.println(soma + " Primeiro digito e: " + digito);
        }
    
    }