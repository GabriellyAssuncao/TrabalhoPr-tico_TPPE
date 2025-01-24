package app;

import java.util.ArrayList;
import java.util.List;

public class IRPF {

	public static final boolean TRIBUTAVEL = true;
	public static final boolean NAOTRIBUTAVEL = false;
	public static float[] limites = {2259.20f, 2826.65f, 3751.05f, 4664.68f};
	public static float[] aliquotas = {0, 0.075f, 0.15f, 0.225f, 0.275f};
	
	private List<Rendimento> rendimentos;

	private List<Dependente> dependentes;
	
	private int numContribuicaoPrevidenciaria;
	private float totalContribuicaoPrevidenciaria;
	
	private float totalPensaoAlimenticia;
	
	private String[] nomesDeducoes;
	private float[] valoresDeducoes;
	

	public IRPF() {
		rendimentos = new ArrayList<>();
		
		dependentes = new ArrayList<>();
		
		numContribuicaoPrevidenciaria = 0; 
		totalContribuicaoPrevidenciaria = 0f;
		
		totalPensaoAlimenticia = 0f;
		
		nomesDeducoes = new String[0];
		valoresDeducoes = new float[0];
	}
	
	/**
	 * Cadastra um rendimento na base do contribuinte, informando o nome do 
	 * rendimento, seu valor e se ele é tributável ou não. 
	 * @param nome nome do rendimento a ser cadastrado
	 * @param tributavel true caso seja tributável, false caso contrário
	 * @param valor valor do rendimento a ser cadastrado
	 */
	public void criarRendimento(String nome, boolean tributavel, float valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("O valor do rendimento não pode ser negativo.");
		}
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("O nome do rendimento não pode ser nulo ou vazio.");
		}

		rendimentos.add(new Rendimento(nome, tributavel, valor));
		this.totalRendimentos += valor;
	}

	/**
	 * Retorna o número de rendimentos já cadastrados para o contribuinte
	 * @return numero de rendimentos
	 */
	public int getNumRendimentos() {
		return rendimentos.size();
	}

	/**
	 * Retorna o valor total de rendimentos cadastrados para o contribuinte
	 * @return valor total dos rendimentos
	 */
	public float getTotalRendimentos() {
		float total = 0;

		for (Rendimento r : rendimentos) 
			total += r.getValor();

		return total;
	}

	/**
	 * Retorna o valor total de rendimentos tributáveis do contribuinte
	 * @return valor total dos rendimentos tributáveis
	 */
	public float getTotalRendimentosTributaveis() {
		float total = 0;

		for (Rendimento r : rendimentos) {
			if (r.isTributavel())
				total += r.getValor();
		}

		return total;
	}

	/**
	 * Método para realizar o cadastro de um dependente, informando seu grau 
	 * de parentesco
	 * @param nome Nome do dependente
	 * @param parentesco Grau de parentesco
	 */
	public void cadastrarDependente(String nome, String parentesco) {
		dependentes.add(new Dependente(nome, parentesco));
	}

	/**
	 * Método que retorna o numero de dependentes do contribuinte
	 * @return numero de dependentes
	 */
	public int getNumDependentes() {
		return dependentes.size();
	}
	
	/**
	 * Return o valor do total de deduções para o contribuinte
	 * @return valor total de deducoes
	 */
	public float getDeducao() {
		float total = 0; 
		for (Dependente d : dependentes) {
			total += 189.59f;
		}
		total += totalContribuicaoPrevidenciaria;
		
		return total;
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

	/**
	 * Realiza busca do dependente no cadastro do contribuinte
	 * @param nome nome do dependente que está sendo pesquisado
	 * @return nome do dependente ou null, caso nao conste na lista de dependentes
	 */
	public String getDependente(String nome) {
		for (Dependente d : dependentes) {
			if (d.getNome().contains(nome))
				return d.getNome();
		}
		return null;
	}

	/**
	 * Método que retorna o grau de parentesco para um dado dependente, caso ele
	 * conste na lista de dependentes
	 * @param dependente nome do dependente
	 * @return grau de parentesco, nulo caso nao exista o dependente
	 */
	public String getParentesco(String dependente) {
		for (Dependente d : dependentes) {
			if (d.getNome().equalsIgnoreCase(dependente))
				return d.getParentesco();
		}
		return null;
	}

	/**
	 * Realiza o cadastro de uma pensao alimenticia para um dos dependentes do 
	 * contribuinte, caso ele seja um filho ou alimentando. 
	 * @param dependente nome do dependente 
	 * @param valor valor da pensao alimenticia
	 */
	public void cadastrarPensaoAlimenticia(String dependente, float valor) {
		if (getParentesco(dependente) == null) {
			throw new IllegalArgumentException("Dependente não encontrado para cadastrar pensão alimentícia.");
		}
		String parentesco = getParentesco(dependente);
		if (parentesco.toLowerCase().contains("filh") || 
			parentesco.toLowerCase().contains("alimentand")) {
			totalPensaoAlimenticia += valor;
		}
	}

	/**
	 * Retorna o valor total pago em pensões alimentícias pelo contribuinte.
	 * @return valor total de pensoes alimenticias
	 */
	public float getTotalPensaoAlimenticia() {
		return totalPensaoAlimenticia;
	}

	
	/**
	 * Metodo para cadastrar deduções integrais para o contribuinte. Para cada
	 * dedução é informado seu nome e valor. 
	 * @param nome nome da deducao 
	 * @param valorDeducao valor da deducao
	 */
	public void cadastrarDeducaoIntegral(String nome, float valorDeducao) {
		String temp[] = new String[nomesDeducoes.length + 1];
		for (int i=0; i<nomesDeducoes.length; i++) {
			temp[i] = nomesDeducoes[i]; 
		}
		temp[nomesDeducoes.length] = nome;
		nomesDeducoes = temp;
		
		float temp2[] = new float[valoresDeducoes.length + 1];
		for (int i=0; i<valoresDeducoes.length; i++) {
			temp2[i] = valoresDeducoes[i]; 
		}
		temp2[valoresDeducoes.length] = valorDeducao;
		valoresDeducoes = temp2;
	}

	
	/**
	 * Método para pesquisar uma deducao pelo seu nome. 
	 * @param substring do nome da deducao a ser pesquisada
	 * @return nome da deducao, ou null caso na esteja cadastrada
	 */
	public String getOutrasDeducoes(String nome) {
		for (String d : nomesDeducoes) {
			if (d.toLowerCase().contains(nome.toLowerCase()))
				return d;
		}
		return null;
	}

	/**
	 * Obtem o valor da deducao à partir de seu nome 
	 * @param nome nome da deducao para a qual se busca seu valor
	 * @return valor da deducao
	 */
	public float getDeducao(String nome) {
		for (int i=0; i<nomesDeducoes.length; i++) {
			if (nomesDeducoes[i].toLowerCase().contains(nome.toLowerCase()))
				return valoresDeducoes[i];
		}
		return 0;
	}

	/**
	 * Obtem o valor total de todas as deduções que nao sao do tipo
	 * contribuicoes previdenciarias ou por dependentes
	 * @return valor total das outras deducoes
	 */
	public float getTotalOutrasDeducoes() {
		float soma = 0;
		for (float f : valoresDeducoes) {
			soma += f;
		}
		return soma;
	}


	// ========DESENVOLVIDOS PELO GRUPO========
	
	/**
	 * Obtem o valor do calculo base
	 * @return valor que sera utilizado para calcular do imposto de renda
	 */
	public float getBaseCalculo() {
		float rendimentosTributaveis = this.getTotalRendimentosTributaveis();
		float deducoes = this.getDeducao() + 
				this.getTotalOutrasDeducoes() + 
				this.getTotalPensaoAlimenticia();

		return rendimentosTributaveis - deducoes;
	}
	
	
	/**
	 * Obtem o valor do imposto de cada faixa
	 * @return Lista de valores referente a cada faixa
	 */
	public float[] getImpostoPorFaixa() {
		float baseCalculo = getBaseCalculo();
	
        float[] valoresTributados = new float[aliquotas.length];

        float remanescente = baseCalculo - limites[0];
        float limiteAnterior = limites[0];

        for (int i = 1; i < limites.length; i++) {
            if (remanescente > 0) {
                float faixa = Math.min(remanescente, limites[i] - limiteAnterior);
                valoresTributados[i] = faixa * aliquotas[i];
                remanescente -= faixa;
                limiteAnterior = limites[i];
            }
        }
        
        if (remanescente > 0) {
            valoresTributados[valoresTributados.length - 1] += remanescente * aliquotas[aliquotas.length - 1];
        }

        return valoresTributados;
	}
	
	
	/**
	 * Obtem o valor total do imposto 
	 * @return valor resultante da soma de todos os impostos por faixa
	 */
	public float getTotalImposto() {
		float[] impostoPorFaixa = getImpostoPorFaixa();

		float soma = 0f;
        for (float valor : impostoPorFaixa) {
            soma += valor;
        }
        return soma;
	}
	
	/**
	 * Obtem o valor total de Rendimentos Tributáveis
	 * @return valor resultante da soma de todos os rendimentos tributáveis
	 */
	public float getAliquotaEfetiva() {
		float totalImposto = getTotalImposto();
		float totalRendTrib = getTotalRendimentosTributaveis();		
		float aliquotaEfetiva = (totalImposto * 100f)/totalRendTrib;

        return aliquotaEfetiva;
	}


}
