import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Double.isNaN;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Gasto[] gastos = new Gasto[100];
    static Ganho[] ganhos = new Ganho[100];
    static int qtdGastos = 0;
    static int qtdGanhos = 0;

    public static void main(String[] args) {
        int opcao = 0;
        do {
            opcao = exibirMenu();
            switch (opcao) {
                case 1 -> cadastraGasto();
                case 2 -> cadastraGanho();
                case 3 -> relatorioGastos();
                case 4 -> relatorioGanhos();
                case 5 -> relatorioMensal();
                case 6 -> System.out.println("Valeu valeu");
                default -> System.out.println("Ops opção errada");
            }
        } while (opcao != 6);
    }

    public static int exibirMenu() {
        System.out.println("\nGestão Financeira\n");
        System.out.println("1 - Cadastra Gasto");
        System.out.println("2 - Cadastra Ganho");
        System.out.println("3 - Relatório de Gastos");
        System.out.println("4 - Relatório de Ganhos");
        System.out.println("5 - Relatório Mensal");
        System.out.println("6 - Sair");
        System.out.print("\nEscolha uma opção: ");
        return sc.nextInt();
    }

    public static void cadastraGasto() {
        String tipo = "";
        Date data = null;
        double valor = 0;
        String formaPagamento = "";

        System.out.println("\nCadastra Gasto");
        System.out.println("1 - Habitação");
        System.out.println("2 - Entretenimento");
        System.out.println("3 - Alimentação");
        System.out.println("4 - Transporte");
        System.out.println("5 - SEU GASTO");
        System.out.println("6 - Voltar");

        System.out.print("\nSelecione o tipo de gasto: ");
        String opcao = sc.next();
        switch (opcao.toUpperCase()) {
            case "1" -> tipo = "Habitação";
            case "2" -> tipo = "Entretenimento";
            case "3" -> tipo = "Alimentação";
            case "4" -> tipo = "Transporte";
            case "5" -> {
                System.out.print("Qual tipo de gasto? ");
                sc.nextLine();
                tipo = sc.nextLine();
            }
            case "6" -> {
                return;
            }
            default -> {
                System.out.println("Ops opção errada");
                return;
            }
        }

        System.out.print("Informe a data (dd/mm/yyyy): ");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = format.parse(sc.next());
        } catch (ParseException e) {
            System.out.println("Data inválida");
            return;
        }

        System.out.print("Informe o valor: R$ ");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        try {
            valor = df.parse(sc.next()).doubleValue();
        } catch (ParseException e) {
            System.out.println("Valor inválido");
            return;
        }

        System.out.println("1 - Cheque");
        System.out.println("2 - Pix");
        System.out.println("3 - Débito");

        System.out.print("Selecione a forma de pagamento: ");
        opcao = sc.next();
        switch (opcao) {
            case "1" -> formaPagamento = "Cheque";
            case "2" -> formaPagamento = "Pix";
            case "3" -> formaPagamento = "Débito";
            default -> {
                System.out.println("Ops opção errada");
                return;
            }
        }

        Gasto gasto = new Gasto(tipo, data, valor, formaPagamento);
        gastos[qtdGastos] = gasto;
        qtdGastos++;
        System.out.println("Gasto adicionado com sucesso");
    }

    public static void cadastraGanho() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o valor do ganho: ");
        double valor = sc.nextDouble();
        if (valor <= 0 || isNaN(valor)) {
            System.out.println("Valor inválido! O ganho não será cadastrado.");
            return;
        }
        sc.nextLine(); // consome a quebra de linha deixada pelo nextDouble()

        System.out.print("Informe o tipo do ganho: ");
        String tipo = sc.nextLine();

        System.out.print("Informe a data do ganho (dd/mm/aaaa): ");
        String dataString = sc.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data;

        try {
            data = format.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Data inválida! O ganho não será cadastrado.");
            return;
        }

        Ganho ganho = new Ganho(tipo, data, valor);
        ganhos[qtdGanhos] = ganho;
        qtdGanhos++;

        System.out.println("Ganho cadastrado com sucesso!");
    }

    public static void relatorioGastos() {
        double totalGasto = 0.0;
        System.out.println("=== Relatório de Gastos ===");
        for (Gasto gasto : gastos) {
            if (gasto != null) {
                System.out.println("Tipo: " + gasto.getTipo());
                System.out.println("Valor: R$ " + gasto.getValor());
                System.out.println("Data: " + gasto.getData());
                System.out.println("Forma de Pagamento: " + gasto.getFormaPagamento());
                System.out.println("--------------------------");
                totalGasto += gasto.getValor();
            }
        }

        System.out.println("Total de Gastos: R$ " + totalGasto);
    }

    public static void relatorioGanhos() {
        double totalGanho = 0.0;

        System.out.println("=== Relatório de Ganhos ===");
        for (Ganho ganho : ganhos) {
            if (ganho != null) {
                System.out.println("Tipo: " + ganho.getTipo());
                System.out.println("Valor: R$" + ganho.getValor());
                System.out.println("Data: " + ganho.getData());
                System.out.println("--------------------------");
                totalGanho += ganho.getValor();
            }
        }

        System.out.println("Total de Ganhos: R$ " + totalGanho);
    }

    public static void relatorioMensal() {
        System.out.println("---- Relatório Mensal ----");

        System.out.print("Informe o mês desejado (1-12): ");
        int mes = sc.nextInt();

        double totalGastos = 0.0;
        double totalGanhos = 0.0;

        for (Gasto gasto : gastos) {
            if (gasto != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(gasto.getData());
                int mesGasto = cal.get(Calendar.MONTH) + 1;
                if (mesGasto == mes) {
                    totalGastos += gasto.getValor();
                }
            }
        }

        for (Ganho ganho : ganhos) {
            if (ganho != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(ganho.getData());
                int mesGanho = cal.get(Calendar.MONTH) + 1;
                if (mesGanho == mes) {
                    totalGanhos += ganho.getValor();
                }
            }
        }

        System.out.println("Total de Gastos: R$" + totalGastos);
        System.out.println("Total de Ganhos: R$" + totalGanhos);
        System.out.println("Saldo: R$" + (totalGanhos - totalGastos));

        System.out.println("--------------------------");
    }
}