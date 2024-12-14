package model;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, String nome){
        super(numero, nome);
    }

    public void reajustar(double percentual){
        double saldoAtual = this.getSaldo();
        double reajuste = saldoAtual * percentual;
        this.depositar(reajuste);
        System.out.println("Reajuste realizado com sucesso!");
    }


    @Override
    public void imprimirTipoConta(){
        System.out.println("Conta Poupança.");
    }
}
