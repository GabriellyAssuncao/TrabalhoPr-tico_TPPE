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
public class TesteTotalImposto {
	IRPF irpf;
	Object[][] rendimentos;
	Object[][] outrasDeducoes;
	float[] previdencias;
	Object[][] dependentes;
	Object[][] pensoes;
	float totalImposto;
	
	public TesteTotalImposto(Object[][] rendimentos, Object[][] outrasDeducoes, float[] previdencias, Object[][] dependentes, Object[][] pensoes, float totalImposto) {
		this.rendimentos = rendimentos.clone();
		this.outrasDeducoes = outrasDeducoes.clone();
		this.previdencias = previdencias.clone();
		this.dependentes = dependentes.clone();
		this.pensoes = pensoes.clone();
		this.totalImposto = totalImposto;
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
				{"Salário", true, 8000f}, 
				{"Aluguel", true, 2000f}, 
				{"Bolsa de estudos", false, 1500f}
		};
		Object[][] rendimentos2 = {
			    {"Salário", true, 7000f},
			    {"Aluguel de Temporada", true, 3000f},
			    {"Lucro de ações", false, 1800f}
		};
		Object[][] rendimentos3 = {
		    {"Salário", true, 6000f},
		    {"Dividendos", true, 2500f},
		    {"Bolsa de Pesquisa", false, 1200f}
		};

		Object[][] outrasDeducoes1 = {{"prev. privada", 1000f}};
		Object[][] outrasDeducoes2 = {{"Plano de saúde", 1200f}, {"Educação", 1500f}};
		Object[][] outrasDeducoes3 = {{"prev. privada", 900f}, {"Transporte", 700f}};

		float[] previdencias1 = {500f};
		float[] previdencias2 = {800f, 400f};
		float[] previdencias3 = {450f, 500f};

		Object[][] dependentes1 = {{"João", "filho"}};
		Object[][] dependentes2 = {{"Lucas", "filho"}, {"Ana", "esposa"}};
		Object[][] dependentes3 = {{"Pedro", "filho"}, {"Clara", "filha"}};

		Object[][] pensoes1 = {{"João", 1500f}};
		Object[][] pensoes2 = {{"Lucas", 1300f},{"Ana", 1800f}};
		Object[][] pensoes3 = {{"Pedro", 1000f}, {"Clara", 1400f}};

		Object[][] parametros = new Object[][] {
			{rendimentos1, outrasDeducoes1, previdencias1, dependentes1, pensoes1, 976.86f},
			{rendimentos2, outrasDeducoes2, previdencias2, dependentes2, pensoes2, 331.92f},
			{rendimentos3, outrasDeducoes3, previdencias3, dependentes3, pensoes3, 94.19f}
		};

		return Arrays.asList(parametros);
	}

	@Test
	public void test() {
		assertEquals(irpf.getTotalImposto(), totalImposto, 0.1f);
	}

}
