package tst;

import app.IRPF;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class TestExcecao {
    private String nome;
    private boolean tributavel;
    private float valor;
    private Class<? extends Exception> expectedException;

    public TestExcecao(String nome, boolean tributavel, float valor, Class<? extends Exception> expectedException) {
        this.nome = nome;
        this.tributavel = tributavel;
        this.valor = valor;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {null, true, 1000.0f, IllegalArgumentException.class},
                {"", true, 1000.0f, IllegalArgumentException.class},
                {"Salário", true, -5000.0f, IllegalArgumentException.class}
        });
    }

    @Test
    public void testCriarRendimento() {
        IRPF irpf = new IRPF();
        try {
            irpf.criarRendimento(nome, tributavel, valor);
            if (expectedException != null) {
                // Falha o teste se exceção esperada não for lançada
                throw new AssertionError("Exceção esperada: " + expectedException.getSimpleName());
            }
        } catch (Exception e) {
            assertEquals("Exceção inesperada", expectedException, e.getClass());
        }
    }
}

