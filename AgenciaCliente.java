/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.Naming;
import java.util.Scanner;

//UnicastRemoteObject permite que a implementacao da classe possa ser estabelecida como um servico remoto
public class AgenciaCliente {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tran = "AG@";
        int cod = 0;
        try {
            //Procura pelo servico da interface InterSolicitacoes no IP e porta definidos
            InterSolicitacoes solicitar = (InterSolicitacoes) Naming.lookup("rmi://localhost:1099/BankService");
            
            boolean exec = true;
            int idConta;
            double valor;
            while (exec) {

                System.out.println("1 - abrir conta");
                System.out.println("2 - fechar conta");
                System.out.println("3 - autenticar conta");
                System.out.println("4 - deposito");
                System.out.println("5 - saque");
                System.out.println("6 - consultar saldo");
                System.out.println("0 - sair");

                int key = in.nextInt();
                switch (key) {
                    case 1:
                        System.out.println(solicitar.aberturaDeConta(tran+(cod++)));
                        break;
                    case 2:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        System.out.println(solicitar.fechamentoDeConta(idConta));
                        break;
                    case 3:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        System.out.println(solicitar.autenticaçãoDeConta(idConta)); 
                        break;
                    case 4:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        System.out.println(solicitar.deposito(idConta, valor, tran+(cod++)));
                        break;
                    case 5:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        System.out.println(solicitar.retirada(idConta, valor, tran+(cod++)));
                        break;
                    case 6:
                        System.out.printf("Digite o numero da conta:\n");
                        idConta = in.nextInt();
                        System.out.println(solicitar.consultaSaldo(idConta));
                        break;
                    case 0:
                        exec = false;
                    default:
                        break;
                }

                in.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
