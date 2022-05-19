/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

import java.util.*;

//UnicastRemoteObject permite que a implementacao da classe possa ser estabelecida como um servico remoto
public class AdministracaoImp extends UnicastRemoteObject implements InterSolicitacoes {

    private Map<Integer, Double> contas;
    private int idConta;

    public AdministracaoImp() throws RemoteException{
        contas = new TreeMap<Integer,Double>();
        idConta = 0;
    }

    @Override
    public String aberturaDeConta() throws RemoteException {
        contas.put(idConta++, 0.00);
        return "\nConta aberta\n";
    }

    @Override
    public String fechamentoDeConta(int conta) throws RemoteException {
        contas.remove(conta);
        return "\nConta removida\n";
        
    }

    @Override
    public String autenticaçãoDeConta(int conta) throws RemoteException {
        if(contas.containsKey(conta)){
            return "\nConta validada\n";
        }else{
            return "\nConata não existe\n";
        }
    }

    @Override
    public String deposito(int id, double valor) throws RemoteException {
        double novovalor = contas.get(id)+valor;
        contas.remove(id);
        contas.put(id, novovalor);
        return "\nDeposito realizado\n";
    }

    @Override
    public String retirada(int id, double valor) throws RemoteException {
        double novovalor = contas.get(id)-valor;
        contas.remove(id);
        contas.put(id, novovalor);
        return "\nSaque realizado\n";
    }

    @Override
    public String consultaSaldo(int conta) throws RemoteException {
        return "\nSaldo: " + contas.get(conta) + "\n";
    }

}
