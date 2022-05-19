/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.Naming;
import java.util.Scanner;

//UnicastRemoteObject permite que a implementacao da classe possa ser estabelecida como um servico remoto
public class AgenciaCliente {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            //Procura pelo servico da calculadora no IP e porta definidos
            InterSolicitacoes solicitar = (InterSolicitacoes) Naming.lookup("rmi://localhost:1099/BankService");
   
            System.out.println("1 - abrir conta");
            System.out.println("2 - fechar conta");
            System.out.println("3 - autenticar conta");
            System.out.println("4 - deposito");
            System.out.println("5 - saque");
            System.out.println("6 - consultar saldo");
            System.out.println("0 - sair");
            boolean exec = true;
            double result;
            int idConta;
            double valor;
            while (exec) {

                int key = in.nextInt();
                switch (key) {
                    case 1:
                        solicitar.aberturaDeConta();
                        break;
                    case 2:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        solicitar.fechamentoDeConta(idConta);
                        break;
                    case 3:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        solicitar.autenticaçãoDeConta(idConta);
                        break;
                    case 4:
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        solicitar.deposito(valor);
                        break;
                    case 5:
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        solicitar.retirada(valor);
                        break;
                    case 6:
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
