/**
 * Implementação das funções assinadas na interface
 */

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

//UnicastRemoteObject permite que a implementacao da classe possa ser estabelecida como um servico remoto
public class AdministracaoImp extends UnicastRemoteObject implements InterSolicitacoes {

    private Map<Integer, Double> contas;

    public AdministracaoImp() throws RemoteException{
        contas = new TreeMap<Integer,Double>();
    }

    @Override
    public void aberturaDeConta() throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void fechamentoDeConta(int conta) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void autenticaçãoDeConta(int conta) throws RemoteException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Double deposito(double valor) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double retirada(double valor) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Double consultaSaldo(int conta) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    
}
