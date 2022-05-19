/**
    Interface Calculadora com assinatura dos métodos 
 */

import java.rmi.*;

public interface InterSolicitacoes extends Remote {
    public String aberturaDeConta () throws RemoteException;
    public String fechamentoDeConta (int conta) throws RemoteException;
    public String autenticaçãoDeConta(int conta) throws RemoteException;
    public String deposito (int conta, double valor) throws RemoteException;
    public String retirada (int conta, double valor) throws RemoteException;
    public String consultaSaldo (int conta) throws RemoteException;
}