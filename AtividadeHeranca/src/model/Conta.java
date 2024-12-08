package model;

public class Conta {
    private int numero;
    private String nome;
    private double saldo;

    public Conta(int numero, String nome){
        this.numero = numero;
        this.nome = nome;
        this.saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        saldo = saldo + valor;
        System.out.println("Depósitp realizado com sucesso!");
    }

    public boolean sacar(double valor){
        if(valor <= saldo){
            saldo = saldo - valor;
            return true;
        }
        return false;
    }

    public void imprimirTipoConta(){
        System.out.println("Conta Comum.");
    }

}
