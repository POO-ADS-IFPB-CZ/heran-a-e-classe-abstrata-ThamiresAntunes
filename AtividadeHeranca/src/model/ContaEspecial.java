package model;

public class ContaEspecial extends Conta{
    private double limite;

    public ContaEspecial(int numero, String nome, double limite){
        super(numero, nome);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor){
        if(valor <= this.getSaldo() || valor <= this.getSaldo() + limite){
            this.setSaldo( this.getSaldo() - valor );
            return true;
        }
        return false;
    }

    @Override
    public void imprimirTipoConta(){
        System.out.println("Conta Especial.");
    }

    @Override
    public String mostrarConta(){
        return "Conta{" +
                "Número=" + getNumero() +
                ", Nome='" + getNome() + '\'' +
                ", Saldo=" + getSaldo() +
                ", Limite=" + limite +
                '}';
    }
}
