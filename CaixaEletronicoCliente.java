/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.Naming;
import java.util.Scanner;

//UnicastRemoteObject permite que a implementacao da classe possa ser estabelecida como um servico remoto
public class CaixaEletronicoCliente {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tran = "CE@";
        int cod = 0;
        try {
            //Procura pelo servico da InterSolicitacoes no IP e porta definidos
            InterSolicitacoes solicitar = (InterSolicitacoes) Naming.lookup("rmi://localhost:1099/BankService");
   
            boolean exec = true;
            int idConta;
            double valor;
            while (exec) {

                System.out.println("1 - deposito");
                System.out.println("2 - saque");
                System.out.println("3 - consultar saldo");
                System.out.println("4 - Simular erro");
                System.out.println("0 - sair");

                int key = in.nextInt();
                switch (key) {
                    case 1:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        System.out.println(solicitar.deposito(idConta, valor, tran+(cod++)));
                        break;
                    case 2:
                        System.out.printf("Digite o numero da conta\n");
                        idConta = in.nextInt();
                        System.out.printf("Digite o valor R$:\n");
                        valor = in.nextDouble();
                        System.out.println(solicitar.retirada(idConta, valor, tran+(cod++)));
                        break;
                    case 3:
                        System.out.printf("Digite o numero da conta:\n");
                        idConta = in.nextInt();
                        System.out.println(solicitar.consultaSaldo(idConta));
                        break;
                    case 4:
                        //Faz 3 requisições com o mesmo idTransação
                        //A primeira é aceita, as outras só confirmadas
                        System.out.printf(solicitar.deposito(0, 50.00, "CE@100"));
                        System.out.printf(solicitar.deposito(0, 50.00, "CE@100"));
                        System.out.printf(solicitar.deposito(0, 50.00, "CE@100"));
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