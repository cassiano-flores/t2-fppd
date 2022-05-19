/**
    Interface Calculadora com assinatura dos métodos 
 */

import java.rmi.*;

public interface InterSolicitacoes extends Remote {
    public void aberturaDeConta () throws RemoteException;
    public void fechamentoDeConta (int conta) throws RemoteException;
    public void autenticaçãoDeConta(int conta) throws RemoteException;
    public Double deposito (double valor) throws RemoteException;
    public Double retirada (double valor) throws RemoteException;
    public Double consultaSaldo (int conta) throws RemoteException;
}