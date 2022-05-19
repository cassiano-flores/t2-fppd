/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.Naming;
import java.util.Scanner;

//UnicastRemoteObject permite que a implementacao da classe possa ser estabelecida como um servico remoto
public class CaixaEletronicoCliente {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            //Procura pelo servico da calculadora no IP e porta definidos
            InterSolicitacoes solicitar = (InterSolicitacoes) Naming.lookup("rmi://localhost:1099/BankService");
   
            System.out.println("1 - deposito");
            System.out.println("2 - saque");
            System.out.println("3 - consultar saldo");
            System.out.println("0 - sair");
            boolean exec = true;
            double result;
            int idConta;
            double valor;
            while (exec) {

                int key = in.nextInt();
                switch (key) {
                    case 1:
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        solicitar.deposito(valor);
                        break;
                    case 2:
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        solicitar.retirada(valor);
                        break;
                    case 3:
                        System.out.printf("Digite o numero da conta:\n");
                        idConta = in.nextInt();
                        solicitar.consultaSaldo(idConta);
                        break;
                    case 0:
                        exec = false;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}