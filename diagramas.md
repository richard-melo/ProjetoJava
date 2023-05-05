//diagramas

+--------------------------------+
|             Main               |
+--------------------------------+
| - gastos: Gasto[]              |
| - ganhos: Ganho[]              |
| - qtdGastos: int               |
| - qtdGanhos: int               |
+--------------------------------+
| + main(String[]): void        |
| + exibirMenu(): int            |
| + cadastraGasto(): void        |
| + cadastraGanho(): void        |
| + relatorioGastos(): void      |
| + relatorioGanhos(): void      |
| + relatorioMensal(): void      |
+--------------------------------+

+------------------------+
|          Gasto         |
+------------------------+
| - tipo: String          |
| - data: Date            |
| - valor: double         |
| - formaPagamento: String|
+------------------------+
| + Gasto(String, Date,   |
|         double, String) |
| + getTipo(): String     |
| + getData(): Date       |
| + getValor(): double    |
| + getFormaPagamento():  |
|      String             |
+------------------------+

+------------------------+
|          Ganho         |
+------------------------+
| - tipo: String          |
| - data: Date            |
| - valor: double         |
+------------------------+
| + Ganho(String, Date,   |
|         double)         |
| + getTipo(): String     |
| + getData(): Date       |
| + getValor(): double    |
+------------------------+
