package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IRPFTest {

    @Test
    public void testCalcularImpostoFaixa1() {
        IRPF irpf = new IRPF();
        float imposto = irpf.calcularImpostoPorFaixa(20000.00f);
        assertEquals(0, imposto, 0.01);
    }

    @Test
    public void testCalcularImpostoFaixa2() {
        IRPF irpf = new IRPF();
        float imposto = irpf.calcularImpostoPorFaixa(25000.00f);
        assertEquals((25000.00f - 22847.76f) * 0.075f, imposto, 0.01);
    }

    @Test
    public void testCalcularImpostoFaixa3() {
        IRPF irpf = new IRPF();
        float imposto = irpf.calcularImpostoPorFaixa(40000.00f); 
        assertEquals((40000.00f - 33919.80f) * 0.15f + (33919.80f - 22847.76f) * 0.075f, imposto, 0.01);
    }

    @Test
    public void testCalcularImpostoFaixa4() {
        IRPF irpf = new IRPF();
        float imposto = irpf.calcularImpostoPorFaixa(50000.00f);
        assertEquals((50000.00f - 45012.60f) * 0.225f + (45012.60f - 33919.80f) * 0.15f + (33919.80f - 22847.76f) * 0.075f, imposto, 0.01);
    }

    @Test
    public void testCalcularImpostoFaixa5() {
        IRPF irpf = new IRPF();
        float imposto = irpf.calcularImpostoPorFaixa(60000.00f);
        assertEquals((60000.00f - 55976.16f) * 0.275f + (55976.16f - 45012.60f) * 0.225f
                + (45012.60f - 33919.80f) * 0.15f + (33919.80f - 22847.76f) * 0.075f, imposto, 0.01);
    }
}
