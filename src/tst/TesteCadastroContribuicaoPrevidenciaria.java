package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteCadastroContribuicaoPrevidenciaria {

	IRPF irpf; 
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void cadastrarUmaContribuicaoPrevidenciaria() {
		irpf.cadastrarContribuicao(1000);
		assertEquals(1, irpf.getNumContribuicoes());
		assertEquals(1000f, irpf.getTotalContribuicoes(), 0f);
		assertEquals(1000f, irpf.getDeducao(), 0f);
	}
	
	
	@Test
	public void cadastrarDuasContribuicoesPrevidenciarias() {
		irpf.cadastrarContribuicao(1000);
		irpf.cadastrarContribuicao(500);
		assertEquals(2, irpf.getNumContribuicoes());
		assertEquals(1500f, irpf.getTotalContribuicoes(), 0f);
		assertEquals(1500f, irpf.getDeducao(), 0f);
	}
	
	@Test
	public void cadastrarTresContribuicoesPrevidenciarias() {
		irpf.cadastrarContribuicao(1000);
		irpf.cadastrarContribuicao(500);
		irpf.cadastrarContribuicao(200);
		assertEquals(3, irpf.getNumContribuicoes());
		assertEquals(1700f, irpf.getTotalContribuicoes(), 0f);
		assertEquals(1700f, irpf.getDeducao(), 0f);
	}
	
	
}
