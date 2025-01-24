package app;

public class Rendimento {
	private String nome;
	private boolean tributavel;
	private float valor;

    public Rendimento(String nome, boolean tributavel, float valor) {
        this.nome = nome;
        this.tributavel = tributavel;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public boolean isTributavel() {
        return tributavel;
    }

    public float getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTributavel(boolean tributavel) {
        this.tributavel = tributavel;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
