import java.util.Date;

public class Ganho {
    private String tipo;

    private Date data;

    private double valor;

    public Ganho(String tipo, Date data, double valor) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
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
}
