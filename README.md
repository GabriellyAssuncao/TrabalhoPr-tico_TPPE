UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciências e Tecnologias em Engenharias  
FGA0242 - Técnicas de Programação para Plataformas Emergentes  

---
# GRUPO 9

## 🧑‍💻 Desenvolvedores

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/GabriellyAssuncao">
        <img src="https://avatars.githubusercontent.com/u/86726332?v=4" width="180px" style="border-radius: 50%;" alt="Gabrielly Assunção"/>
        <br/><b>Gabrielly Assunção</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/laisramos123">
        <img src="https://avatars.githubusercontent.com/u/38669960?v=4" width="190px" style="border-radius: 50%;" alt="Laís Ramos"/>
        <br/><b>Laís Ramos</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Madu01">
        <img src="https://avatars.githubusercontent.com/u/64814266?v=4" width="190px" style="border-radius: 50%;" alt="Maria Eduarda Barbosa"/>
        <br/><b>Maria Eduarda Barbosa</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/NyndoND">
        <img src="https://avatars.githubusercontent.com/u/64983769?v=4" width="190px" style="border-radius: 50%;" alt="Renann"/>
        <br/><b>Renann</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/VitorB2002">
        <img src="https://avatars.githubusercontent.com/u/78763082?v=4" width="190px" style="border-radius: 50%;" alt="Vitor Borges dos Santos"/>
        <br/><b>Vitor Borges</b>
      </a>
    </td>
  </tr>
</table>





--- 

# Trabalhos práticos - semestre 2024/2

## Descrição do cenário

O Imposto de Renda de Pessoas Físicas (IRPF) é um imposto federal calculado com base na renda e despesas dedutíveis dos cidadãos brasileiros. De modo bastante resumido, o imposto considera, mensalmente, todas as rendas tributáveis recebidas pelo cidadão e todas suas deduções legais. A base de cálculo do IRPF é a diferença da renda pelas deduções de modo que o imposto devido é calculado sobre esse valor. Por fim, a alíquota efetiva é dada pelo quociente entre o imposto pago e o total de rendimentos tributáveis. Cada um desses passos está apresentado abaixo, através de um exemplo ilustrativo.


### Rendimentos  

Os rendimentos são aqueles valores recebidos pelo cidadão ao longo de um mês.  Os rendimentos são classificados como *tributáveis* quando há a incidência de imposto sobre eles, ou *não-tributáveis*, caso contrário. São exemplos de rendimentos tributáveis os salários, rendimentos de alguns tipos de investimentos, pro-labore, dentre outros. São exemplos de rendimentos não-tributáveis os ressarcimentos de despesas de trabalho, bolsas de estudos, dentre outros. Apenas os rendimentos tributáveis são considerados para efeito de cálculo do imposto de renda. 

Suponha que um cidadão possua os seguintes rendimentos: 

| Descrição do Rendimento | Tributável? | Valor            |
|:------------------------|:-----------:|-----------------:|
| Salário                 |  Sim        |     R$ 8.000,00  |
| Aluguel                 |  Sim        |     R$ 2.000,00  |
| Bolsa de estudos        |  Não        |     R$ 1.500,00  |
| **Total rendimentos:**  |             | **R$ 11.500,00** |
| **Total rend. tribut.:**|             | **R$ 10.000,00** |

### Deduções

As deduções são os valores que, legalmente, podem ser descontados para o cálculo do imposto. Para cada dependente do contribuinte (filho/filha) desconta-se o valor de R$189,59. Valores pagos à previdência oficial (Previdência Social do Governo Federal) são deduzidos em sua integralidade. Valores pagos à previdência complementar (planos de previdência privada do tipo PGBL), ao Carnê-leão e à pensões alimentícias também são deduzidos integralmente. 

Em nosso exemplo, supondo que o cidadão possua um dependente, pague R$500,00 de previdência oficial, R$1.000,00, de previdência complementar e R$1.500,00 de pensão alimentícia, tem-se a seguinte tabela de deduções. 

| Descrição da dedução  | Valor           |
|:----------------------|----------------:|
| 1 filho               | R$ 189,59       |
| Cont. Prev. oficial   | R$ 500,00       |
| Cont. Prev. privada   | R$ 1.000,00     |
| Pensão alimentícia    | R$ 1.500,00     |
| **Total de deduções** | **R$ 3.189,59** |

### Base de cálculo

A base de cálculo é o valor que será utilizado para cálculo do imposto de renda. Ele é dado pela diferença dos total de rendimentos tributáveis pelo total das deduções legais. No exemplo, a base de cálculo é calculada como demonstrado a seguir.

| Descrição                        | Valor            |
|:---------------------------------|-----------------:|
| Total de rendimentos tributáveis | R$ 10.000,00     |
| Total de deduções                | R$  3.189.59     |
| **Total**                        | **R$  6.810,41** |

### Cálculo do imposto  

A tributação do imposto de renda é realizada através de cinco faixas. Cada faixa possui uma alíquota de imposto aplicada ao valor da base de cálculo que se enquadrou naquela faixa. Os limites e as alíquotas são crescentes conforme tabela seguinte. O valor total do imposto é dado pela soma dos impostos de cada faixa.

| Faixa | Faixa de valores         | Alíquota |
|:------|:-------------------------|:--------:|
| 1a.   | Até 2.259,20             |  0.0 %   |
| 2a.   | De 2.259,21 até 2.826,65 |  7.5 %   |
| 3a.   | De 2.826,66 até 3.751,05 | 15.0 %   |
| 4a.   | De 3.751,06 até 4.664,68 | 22.5 %   |
| 5a.   | Acima de 4.664,68        | 27.5 %   |

No caso do exemplo desse trabalho, a base de cálculo do IRPF é de R$ 6.810,41. Portanto, ela contempla todas as faixas do IRPF, conforme demonstrado pela tabela a seguir: 

*Base de cálculo:* R$ 6.810,41

| Faixa | Alíquota  | Imposto devido |
|:------|:---------:|---------------:|
| 1a.   |  0.0 %    | R$   0,00      |
| 2a.   |  7.5 %    | R$  53,59      |
| 3a.   | 15.0 %    | R$ 138,66      |
| 4a.   | 22.5 %    | R$ 205,56      |
| 5a.   | 27.5 %    | R$ 590,07      |
|       | **Total** | **R$ 987,88**  |

A alíquota efetiva é dada pelo quociente entre o imposto pago e o total de rendimentos tributáveis. Embora o cidadão do exemplo se encontrar na quinta faixa (27,5%), a alíquota efetiva do imposto pago é de 9,87% ($\frac{R\$ 987,88}{R\$ 10.000,00}$).

--- 

# Enunciados dos trabalhos

Três trabalhos serão realizados sobre o cenário descrito acima. Os temas para esses trabalhos são, na sequencia, TDD, Refatoração e Depuração de código. Os grupos dos trabalhos terão, no máximo, 5 componentes. Os componentes dos grupos deverão ser informados através do formulário presente [nesse link.](https://docs.google.com/forms/d/e/1FAIpQLSevIusyB-JxQe5uP1oPuWkIPXfQzdy9H6eIeuIWkVPgc1NJ2Q/viewform)

Os trabalhos deverão ser realizados em Java e disponibilizados em repositórios do GitHub. As entregas serão feitas através dos repositórios, de modo que a data e o horário dos commits serão considerados como horário da entrega dos trabalhos. Os componentes do grupo deverão adicionar o professor como membro do repositório. 


## Entrega 1 - TDD

**Valor:** 20 pontos  
**Data de entrega:** 13/12/2024, 23:59hs.  
 
Junto desse enunciado encontra-se o código da calculadora de IRPF, iniciado em sala de aula. Esse código já contempla os testes para as seguintes funcionalidades (e suas respectivas unidades). 

| Classe                                  | Funcionalidade                    |
|:----------------------------------------|:----------------------------------|
| TesteCadastrarDependente                | Cadastrar dependentes             |
| TesteRendimentos                        | Cadastrar rendimentos             |
| TesteCalculosDeducoesDependentes        | Calcular deduções por dependentes |
| TesteCadastroContribuicaoPrevidenciaria | Calcular deducoes por previdencia |
| TesteCadastroPensaoAlimenticia          | Calcular deducoes por pensoes     |
| TesteCadastroOutrasDeducoes             | Calcular outros tipos de deducoes |
 
Ainda não estão implementados os testes e as unidades para o calcula: 
 - a base de cálculo do imposto, 
 - os impostos por faixas e o total do imposto, 
 - e a alíquota efetiva do imposto pago. 

Para essa entrega os grupos deverão criar testes triangulados (parametrizados, preferencialmente) para cada uma das unidades mencionadas acima, e os testes têm que estar integrados à suíte de testes presente no arquivo ``AllTests.java``. 


## Entrega 2 - Refatoração

**Valor:** 20 pontos  
**Data de entrega:** ~~23/12/2024~~ 24/01/2025, 23:59hs.
**Entrega:** através de push para os repositórios dos grupos.

Com base nos artefatos entregues pelo grupo na primeira parte do trabalho, os componentes deverão refatorá-los nessa segunda etapa. Todos os grupos realizarão as mesmas operações de refatoração, variando apenas os locais onde elas serão aplicadas. As operações de refatoração a serem aplicadas são **Extrair método**, **Extrair classe** e **Substituir método por objeto-método**. As classes / métodos sujeitos às refatorações para cada grupo estão listados a seguir. 

| **Grupo** | **Operação de refatoração**         | **Classe / método a ser aplicado**    |
|-----------|-------------------------------------|---------------------------------------|
| Grupo 9   | Extrair Método                      | IRPF.cadastrarDependente()            |
|           | Extrair Classe                      | IRPF                                  |
|           | Substituir método por objeto-método | IRPF.getImpostoPorFaixa()             |


Para essa entrega os grupos deverão, obrigatoriamente, alterar as classes e os métodos listados acima e preferencialmente **não alterar as implementações dos testes** já entregues na etapa 1. A suíte de testes deverá continuar sendo implementada pela classe ```AllTests.java``` 

Os grupos estão livres para decidir como aplicar a refatoração Extrair Classe mas deverão, **obrigatoriamente**, apresentar na mensagem do commit qual a justificativa para a divisão da classe em outra classe associada. Extração de classe sem a devida explicação não serão consideradas para efeitos da avaliação.  

## Entrega 3 - Projeto de código

**Valor:** 20 pontos  
**Data de entrega:** 14/02/2025, 23:59hs. 

Projeto de software é, muitas vezes, entendido como uma atividade dentro do
processo de desenvolvimento em que uma equipe define as estruturas do software e
as interações entre elas. O intuito com esse tipo de abordagem é facilitar o
desenvolvimento à partir dos artefatos gerados durante a atividade de projeto.
Os artefatos gerados servem como uma especificação do que o software deve fazer
e quais as propriedades que devem ser garantidas quando ele estiver em operação.

Contudo, a realidade é diferente. O código é também uma atividade de projeto de
software. Basta relembrar do conceito de Refatoração. Martin Fowler, em seu
livro de refatoração, define como sendo "_o aperfeiçoamento do **projeto** de
código sem alterar o seu comportamento externamente observável._"(Fowler, 1999).
Por mais detalhado que sejam os artefatos de software criados durante a
atividade de projeto de software, eles não conseguirão capturar todos os
detalhes que são considerados durante a codificação. Os menores detalhes
escapam dos modelos gerados e, geralmente, são descobertos durante a atividade
de codificação sob a forma de inconsistências, falhas ou erros. Disso segue um
conceito-chave muito importante: 

> Conceito chave:  
> Programar é uma atividade de projeto de software. 

Portanto, são os programadores quem refinam e extendem o projeto de software na
medida em que, constantemente, várias vezes ao dia, refinam e extendem o código
da aplicação. Isso não significa que a idéia inicial de um projeto deva ser
descartada. Pelo contrário, ter em mente o projeto que se deseja alcançar é
importante, pois ele se torna uma meta a ser alcançada. Essa meta de projeto
deve ser minimamente coerente para que o projeto resultante não se transforme em
um projeto desestruturado e de difícil manutenção e evolução. 

## Projeto de software

Desenvolvedores, em suas funções, realizam atividades de projeto de código, como
classes, objetos e estruturas de dados. Essas pequenas contribuições vão sendo
incorporadas ao projeto do software na medida em que são desenvolvidas. Em
escala ascendente, os níveis de projeto de software são:  
- funções: nível mais elementar das atividades de projeto, mas não menos
  importante. Se as rotinas são projetadas sem cuidado todo o sistema será
  impactado. Uma vez definido quais são as funções necessárias, trabalha-se na
  implementação interna, definindo algoritmos e o fluxo de execução. 
- classes e tipos de dados: após a definição das funções, as atividades de
  codificação que resultam em alterações no projeto concentram-se nas definições
  de interfaces para utilização dessas funções. Nesse nível busca-se projetar
  interfaces que sejam representem o conjunto das funções encapsuladas. Isso se
  dá, no contexto de orientação a objetos, por meio da definição de classes e
  interfaces. 
- módulos e componentes: o passo seguinte é organizar as classes desenvolvidas
  em conjunto de classes, compreensíveis, que guardem alguma relação de
  similaridade ou proximidade entre si. Costuma-se chamar esses agrupamentos de
  módulos ou componentes, contudo, é necessário atentar-se ao que se entende por
  módulos. Por exemplo, pode ser considerado como um conjunto de classes em
  linguagens orientadas por objetos ou como bibliotecas em linguagens
  procedurais. Nesse ponto do projeto o que se busca é a definição de interfaces
  **publicadas**, as quais deverão ser estáveis pois desempenham o papel de
  contratos entre os módulos e entre as equipes que trabalham nelas. 
- arquitetura do sistema: nesse ponto observa-se o sistema e seus subsistemas
  como um todo. O projeto arquitetural desempenha forte influência no desempenho
  e nas características do sistema como um todo. 

O projeto de software é a base sobre a qual todo o software será construído, uma
vez que essa base é bem projetada e estruturada aumentam-se as chances do
software construído ter qualidade. São características de um bom projeto de
software: 
- fácil de escrever; 
- fácil de entender; 
- fácil de manter; 
- menos provável de ter bugs e, por fim,
- mais resiliente à mudanças.

Tudo isso exposto, conclui-se que ter um projeto de software correto,
principalmente desde o início, é muito importante. É possível pensar em
características de bom projeto em nível micro, durante a codificação, de modo
que as boas práticas se acumularão e terão impactos no projeto do software como
um todo. Vários desses princípios guardam estreita relação com as operações de
refatoração de modo que é possível realizar melhorias em projetos de código
existentes aplicando uma ou uma sequência de operações. Em linhas gerais, os
princípios de um bom projeto de código são: 
- simplicidade; 
- elegância; 
- modularidade; 
- boas interfaces; 
- extensibilidade; 
- evitar duplicação; 
- portabilidade; 
- código deve ser idiomático e bem documentado.

## Enunciado: 

Com base na descrição acima, cada grupo de trabalho deverá responder as
seguintes perguntas: 

1 - Para cada um dos princípios de bom projeto de código mencionados acima,
apresente sua definição e relacione-o com os maus-cheiros de código apresentados
por Fowler em sua obra.

2 - Identifique quais são os maus-cheiros que persistem no trabalho prático 2 do
grupo, indicando quais os princípios de bom projeto ainda estão sendo violados e
indique quais as operações de refatoração são aplicáveis. Atenção: não é
necessário aplicar as operações de refatoração, apenas indicar os princípios
violados e operações possíveis de serem aplicadas. 

## Formato e Data de entrega: 

O trabalho deverá ser entregue na forma de um relatório em PDF, elaborado pelo
grupo. O trabalho será enviado ao repositório já utilizado pelos TPs 1 e 2. As
referências listadas abaixo devem ser consultadas em suas respostas. 

A data-limite de entrega é dia 14/02/2025, 23:59hs. 

