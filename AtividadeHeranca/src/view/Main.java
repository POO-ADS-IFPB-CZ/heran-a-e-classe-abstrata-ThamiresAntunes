package view;

import model.Conta;
import model.ContaEspecial;
import model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //metodo para listar as contas do array
    public static void listarContas(List<Conta> lista){
        for(Conta conta : lista){
            System.out.println(conta.mostrarConta());
        }
    }

    //menu para criar as contas 
    public static Conta menuCriarConta(){
        Scanner scanner = new Scanner(System.in);
        Conta conta = null;
        int tipoConta;

        System.out.println("Qual tipo de conta que deseja criar: ");
        System.out.println("1 - Conta Comum | 2 - Conta Especial | 3 - Conta Poupança | 0 - Sair ");
        tipoConta = scanner.nextInt();

        if(tipoConta == 0){
            System.out.println("Saindo do menu e salvando nova conta...");
            return null;
        }

        System.out.println("Informe o numero da conta: ");
        int num = scanner.nextInt();
        System.out.println("Informe o nome do titular da conta: ");
        String nome = scanner.next();
        double limite = 0;
        if (tipoConta == 2) {
            System.out.println("Informe o limite da conta: ");
            limite = scanner.nextDouble();
        }

        switch (tipoConta) {
            case 1:
                conta = new Conta(num, nome);
                break;
            case 2:
                conta = new ContaEspecial(num, nome, limite);
                break;
            case 3:
                conta = new ContaPoupanca(num, nome);
                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido...");
        }

        return conta;

    }

    //menu com as operações da conta
    public static void menuOperarConta(Conta conta){
        int opcao = 1;
        Scanner scanner = new Scanner(System.in);

        while(opcao != 0){

            System.out.println("--Menu Conta Bancaria--");
            System.out.println(" 1 - Depositar | 2 - Sacar | 3 - Ver Saldo | 0 - Salvar |  ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor do deposito ");
                    conta.depositar(scanner.nextDouble());
                    break;
                case 2:
                    System.out.println("Digite o valor do saque ");
                    conta.sacar(scanner.nextDouble());
                    break;
                case 3:
                    System.out.println("Saldo Atual da Conta: R$" + conta.getSaldo());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida...");
            }
        }

    }

    public static void main(String[] args) {

        List<Conta> listaConta = new ArrayList<>();
        Conta conta = null;
        do{
            conta = menuCriarConta();
            if(conta != null){
                menuOperarConta(conta);
                listaConta.add(conta);
                System.out.println("A conta de " + conta.getNome() + " foi criada e salva na lista");
            }

        }
        while(conta != null);
        listarContas(listaConta);

    }
}
