import java.util.Scanner;

public class questao05 {
    public static void extrato(Conta[] vContas, int tamConta, Operacao[] vOp, int tamOp) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Digite o ID da conta: ");
    int id = sc.nextInt();

    int pos = buscaId(vContas, tamConta, id);

    if (pos == -1) {
        System.out.println("Conta não encontrada!");
        return;
    }

    Operacao[] filtradas = new Operacao[tamOp];

    int tamFiltrado = filtraOperacoes(vOp, tamOp, filtradas, id);

    int inicio = Math.max(0, tamFiltrado - 5);

    double saldo = 0;

    for (int i = 0; i < inicio; i++) {saldo += filtradas[i].valor;}

    System.out.println("\nCONTA N." + id);
    System.out.println("CLIENTE: " + vContas[pos].cliente);

    System.out.println("-----------------------------------------------");
    System.out.println("ID | OPERACAO       | VALOR    | SALDO");
    System.out.println("-----------------------------------------------");

    System.out.printf("   | Saldo Anterior |          | %s%n",
            formatarSaldo(saldo));

    for (int i = inicio; i < tamFiltrado; i++) {

        Operacao op = filtradas[i];

        saldo += op.valor;

        String nome = "";

        if (op.tipo == 'D') {nome = "Deposito";
        } else if (op.tipo == 'S') {
            nome = "Saque";
        } else if (op.tipo == 'T') {
            nome = "Transferencia";
        }

        System.out.printf("%04d | %-15s | %s | %s%n",
                op.id,
                nome,
                formatarSaldo(op.valor),
                formatarSaldo(saldo));
    }

    System.out.println("-----------------------------------------------");
    System.out.println("Saldo Atual: " + formatarSaldo(saldo));
}
    
}
