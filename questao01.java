import java.util.Scanner;

public class questao01 {
        
        public static int cadastrarConta(Conta[] v, int tam) {
        
        Scanner sc =new Scanner(System.in);

            if (tam == TAM_CONTAS) {
            System.out.println("Vetor de contas cheio!");
            return tam;
        }

        Conta nova =new Conta();

        System.out.print("Digite o ID: ");
        nova.id = sc.nextInt();
        sc.nextLine();

        while (buscaId(v, tam, nova.id) != -1) {
            System.out.println("ID já cadastrado!");

            System.out.print("Digite outro ID: ");
            nova.id = sc.nextInt();
            sc.nextLine();
        }

        System.out.print("Digite o nome do cliente: ");
        nova.cliente = sc.nextLine();

        System.out.print("Digite o saldo: ");
        nova.saldo = sc.nextDouble();

        while (nova.saldo < 0) {
            System.out.println("Saldo não pode ser negativo!");

            System.out.print("Digite o saldo novamente: ");
            nova.saldo = sc.nextDouble();
        }

        System.out.print("Digite o limite: ");
        nova.limite = sc.nextDouble();

        while (nova.limite < 0) {
            System.out.println("Limite não pode ser negativo!");

            System.out.print("Digite o limite novamente: ");
            nova.limite = sc.nextDouble();
        }

        v[tam] = nova;

        return tam + 1;
    }
}


