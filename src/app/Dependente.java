package app;

public class Dependente {
	private String nome;
	private String parentesco;

	public Dependente(String nome, String parentesco) {
		this.nome = nome;
		this.parentesco = parentesco;
	}

	public String getNome() {
		return nome;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
}
