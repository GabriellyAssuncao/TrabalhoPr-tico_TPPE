package app;

public class ImpostoPorFaixa {
    private float baseCalculo;
    private float[] limites;
    private float[] aliquotas;

     
    public ImpostoPorFaixa(float baseCalculo, float[] limites, float[] aliquotas) {
        this.baseCalculo = baseCalculo;
        this.limites = limites;
        this.aliquotas = aliquotas;
    }

    
    public float[] calcular() {
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
}
