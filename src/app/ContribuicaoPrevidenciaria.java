package app;

public class ContribuicaoPrevidenciaria {
    private int numContribuicaoPrevidenciaria; 
	private float totalContribuicaoPrevidenciaria;

    public ContribuicaoPrevidenciaria() {
        this.numContribuicaoPrevidenciaria = 0;
        this.totalContribuicaoPrevidenciaria = 0f;
    }

	/**
	 * Cadastra um valor de contribuição previdenciária oficial
	 * @param contribuicao valor da contribuição previdenciária oficial
	 */
	public void cadastrarContribuicaoPrevidenciaria(float contribuicao) {
		if (contribuicao < 0) {
			throw new IllegalArgumentException("A contribuição previdenciária não pode ser negativa.");
		}
		numContribuicaoPrevidenciaria++;
		totalContribuicaoPrevidenciaria += contribuicao;
	}

	/**
	 * Retorna o numero total de contribuições realizadas como contribuicao 
	 * previdenciaria oficial
	 * @return numero de contribuições realizadas
	 */
	public int getNumContribuicoesPrevidenciarias() {
		return numContribuicaoPrevidenciaria;
	}

	/**
	 * Retorna o valor total de contribuições oficiais realizadas
	 * @return valor total de contribuições oficiais
	 */
	public float getTotalContribuicoesPrevidenciarias() {
		return totalContribuicaoPrevidenciaria;
	}
}
