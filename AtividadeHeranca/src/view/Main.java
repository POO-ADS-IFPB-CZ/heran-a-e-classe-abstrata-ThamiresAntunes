package view;

import model.Conta;
import model.ContaEspecial;
import model.ContaPoupanca;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conta conta = null;
        Scanner scanner = new Scanner(System.in);
        int opcao, tipoConta;
        double valor;
        do{
            System.out.println("--Menu Conta Bancaria--");
            System.out.println("1 - Abrir uma conta | 2 - Depositar | 3 - Sacar | 4 - Ver Saldo | 0 - Sair |  ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Escolha o tipo de conta que deseja criar: ");
                    System.out.println("1 - Conta Comum | 2 - Conta Especial | 3 - Conta Poupança ");
                    tipoConta = scanner.nextInt();
                    switch (tipoConta){
                        case 1: conta = new Conta(1, "José"); break;
                        case 2: conta = new ContaEspecial(3, "Maria", 100); break;
                        case 3: conta = new ContaPoupanca(5, "Pedro");
                    }
                case 2:
                    System.out.println("Digite o valor do deposito ");
                    valor = scanner.nextDouble();
                    conta.depositar(valor); break;
                case 3:
                    System.out.println("Digite o valor do saque ");
                    valor = scanner.nextDouble();
                    conta.sacar(valor); break;
                case 4:
                    System.out.println("Saldo Atual da Conta: R$" + conta.getSaldo()); break;
                case 0: break;
                default:
                    System.out.println("Opção inválida...");
            }

        }
        while(opcao != 0);


    }
}