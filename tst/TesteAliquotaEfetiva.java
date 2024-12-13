package tst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteAliquotaEfetiva {
	IRPF irpf;
	Object[][] rendimentos;
	Object[][] outrasDeducoes;
	float[] previdencias;
	Object[][] dependentes;
	Object[][] pensoes;
	float aliquotaEfetiva;
	
	public TesteAliquotaEfetiva(Object[][] rendimentos, Object[][] outrasDeducoes, float[] previdencias, Object[][] dependentes, Object[][] pensoes, float aliquotaEfetiva) {
		this.rendimentos = rendimentos.clone();
		this.outrasDeducoes = outrasDeducoes.clone();
		this.previdencias = previdencias.clone();
		this.dependentes = dependentes.clone();
		this.pensoes = pensoes.clone();
		this.aliquotaEfetiva = aliquotaEfetiva;
	}
	
	@Before
	public void setup() {
		irpf = new IRPF();
		
		for(int i = 0; i < rendimentos.length; i++) {
			if((boolean) rendimentos[i][1])
				irpf.criarRendimento(rendimentos[i][0].toString(), irpf.TRIBUTAVEL, (float)rendimentos[i][2]);
			else
				irpf.criarRendimento(rendimentos[i][0].toString(), irpf.NAOTRIBUTAVEL, (float)rendimentos[i][2]);
		}

		for(int i = 0; i < outrasDeducoes.length; i++)
			irpf.cadastrarDeducaoIntegral(outrasDeducoes[i][0].toString(), (float)outrasDeducoes[i][1]);
		
		for(int i = 0; i < previdencias.length; i++)
			irpf.cadastrarContribuicaoPrevidenciaria(previdencias[i]);
		
		for(int i = 0; i < dependentes.length; i++)
			irpf.cadastrarDependente(dependentes[i][0].toString(), dependentes[i][1].toString());
		
		for(int i = 0; i < pensoes.length; i++)
			irpf.cadastrarPensaoAlimenticia(pensoes[i][0].toString(), (float)pensoes[i][1]);
	}
	
	@Parameters
	public static Iterable getParameters() {
		Object[][] rendimentos1 = {
				{"Salário", true, 9400f}, 
				{"Aluguel", true, 3000f}, 
				{"Bolsa de estudos", false, 2500f}
		};
		Object[][] rendimentos2 = {
			    {"Salário", true, 11000f},
			    {"Aluguel de Temporada", true, 2500f},
			    {"Lucro de ações", false, 2900f}
		};
		Object[][] rendimentos3 = {
		    {"Salário", true, 7000f},
		    {"Dividendos", true, 3600f},
		    {"Bolsa de Pesquisa", false, 2300f}
		};

		Object[][] outrasDeducoes1 = {{"prev. privada", 2300f}};
		Object[][] outrasDeducoes2 = {{"Plano de saúde", 1300f}, {"Educação", 2500f}};
		Object[][] outrasDeducoes3 = {{"prev. privada", 800f}, {"Transporte", 600f}};

		float[] previdencias1 = {600f};
		float[] previdencias2 = {900f, 500f};
		float[] previdencias3 = {550f, 600f};

		Object[][] dependentes1 = {{"João", "filho"}};
		Object[][] dependentes2 = {{"Lucas", "filho"}, {"Ana", "esposa"}};
		Object[][] dependentes3 = {{"Pedro", "filho"}, {"Clara", "filha"}};

		Object[][] pensoes1 = {{"João", 1600f}};
		Object[][] pensoes2 = {{"Lucas", 1400f},{"Ana", 1800f}};
		Object[][] pensoes3 = {{"Pedro", 1200f}, {"Clara", 1100f}};

		Object[][] parametros = new Object[][] {
			{rendimentos1, outrasDeducoes1, previdencias1, dependentes1, pensoes1, 9.873f},
			{rendimentos2, outrasDeducoes2, previdencias2, dependentes2, pensoes2, 6.646f},
			{rendimentos3, outrasDeducoes3, previdencias3, dependentes3, pensoes3, 5.480f}
		};

		return Arrays.asList(parametros);
	}

	@Test
	public void test() {
		assertEquals(irpf.getAliquotaEfetiva(), aliquotaEfetiva, 0.1f);
	}

}
