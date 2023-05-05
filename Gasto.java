
import java.util.Date;

public class Gasto {
    private String tipo;

    private Date data;

    private double valor;

    private String formaPagamento;

    public Gasto(String tipo, Date data, double valor, String formaPagamento) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getFormaPagamento() { return formaPagamento; }
}
