# Problema: Compressão de dados gênicos

- Grupo: 2 a 4 pessoas
- Data de liberação: 24/09/2024
- Deadline de entrega: 18/10/2024 
- Email de contato: proffellipe.souto@fiap.com.br

Imagine que você foi contratado como Engenheiro de Software por uma empresa de bioinformática para desenvolver um software que seja capaz de comprimir dados. Pegando a definição do artigo do Wikipédia, temos que:

> 
> A compressão de dados é o ato de reduzir o espaço ocupado por dados no determinado dispositivo digital/dispositivo computacional. Essa operação é realizada através de diversos algoritmos de compressão, reduzindo a quantidade de Bytes para representar um dado, sendo esse dado uma imagem, um texto, ou um arquivo (ficheiro) qualquer.
>
> Comprimir dados destina-se também a retirar a redundância, baseando-se que muitos dados contêm informações redundantes que podem ou precisam ser eliminadas de alguma forma. Essa forma é através de uma regra, chamada de código ou protocolo, que, quando seguida, elimina os bits redundantes de informações, de modo a diminuir seu tamanho nos ficheiros. Por exemplo, a sequência "AAAAAA" que ocupa 6 bytes, poderia ser representada pela sequência "6A", que ocupa 2 bytes, economizando 67% de espaço.
> 
> Além da eliminação da redundância, os dados são comprimidos pelos mais diversos motivos. Entre os mais conhecidos estão economizar espaço em dispositivos de armazenamento, como discos rígidos, ou ganhar desempenho (diminuir tempo onde acontece essas transmissões) em transmissões.
>
> Embora possam parecer sinônimos, compressão e compactação de dados são processos distintos. A compressão, como visto, reduz a quantidade de bits para representar algum dado, enquanto a compactação tem a função de unir dados que não estejam unidos. Um exemplo clássico de compactação de dados é a desfragmentação de discos.
>
> Fonte: [Compressão de dados - Wikipedia](https://pt.wikipedia.org/wiki/Compress%C3%A3o_de_dados)

Pensando que a Sprint do trabalho tem duas semanas de duração e nosso chefe pediu uma versão preliminar em Java, sua tarefa será desenvolver um algoritmo de compressão de dados, que comprima um arquivo de texto contendo cadeia longa de nucleotídeos em um arquivo menor, sem perda de dados.

Para esse projeto implementaremos um algoritmo bem simples, conhecido como "Run-Length Encoding (RLE)". 

> 
> Codificação run-length (ou RLE) é uma forma simples de compressão sem perda de dados onde sequências longas de valores repetidos são armazenadas como um único valor e sua contagem no lugar de sua sequência original. É principalmente útil em dados com muitas repetições de valores. Considere, por exemplo, imagens gráficas simples tais quais ícones, line art, jogos da vida e animações. Não é útil em arquivos que não possuem muitas repetições, pois pode aumentar bastante o tamanho do arquivo.
>
> RLE também pode ser usado para se referir a um formato de arquivo gráfico inicial aceito pelo CompuServe para comprimir imagens em preto e branco, mas foi amplamente substituído pelo posterior Graphics Interchange Format. RLE também se refere a um formato de imagem pouco utilizado no Windows 3.x, com extensão rle, que é um Bitmap codificado em run-length, usado para comprimir a tela de inicialização do Windows 3.x.
> 
> Fonte: [Codificação run-length](https://pt.wikipedia.org/wiki/Codifica%C3%A7%C3%A3o_run-length)


A seguir temos alguns exemplos de entrada e saída desse algoritmo:

```bash
INPUT: AAAACCCTTG
OUTPUT: A4C3T2G1

INPUT: GGAACCTTCC
OUTPUT: G2A2C2T2C2

INPUT: GGGGGGGGGG
OUTPUT: G10

INPUT: TGGGGGGGGC
OUTPUT: T1G8C1

INPUT: GGGGGGGGCC
OUTPUT: G8C2

INPUT: GGGGGGGCCC
OUTPUT: G7C3
```


## Entrada/Saída
A entrada do nosso programa aceitará dois argumentos:

```bash
$ java -jar <path/to/jar/file> <path/to/input> <path/to/output>
```

### Descrição do arquivo de entrada

1. Será um arquivo com extensão .txt .
2. O tamanho irá variar entre 128KB a 1024KB.
3. A sequência de nucleotídios deve ser encarada como uma sequência única, independente do tamanho dela ou se houver quebra de linhas.
4. Utilizaremos a codificação UFT-8 para os caracteres de entrada.
5. A sua maior entrada pode ter até 1024KB.
   1. 1 KB = 1024 BYTES
   2. 1024 KB = 1024 * 1024 = 1,048,576 BYTES (1 MB)


A saída do seu programa deverá ser composta por duas partes:

1. Interface textual
2. Saída de texto

### Descrição da interface textual
A saída de texto deve se basear na interface a seguir:

```bash
$ $ java -jar <path/to/jar/file> <path/to/input> <path/to/output>

 -----------------------------------------------------------
|           LIB UNCLE PRESSER - GRUPO BATATA-DOCE           |
|-----------------------------------------------------------
|                                                           |
| INPUT  FILENAME: INPUT1.TXT                               |
| OUTPUT FILENAME: OUTPUT1.TXT                              |
|                                                           |
 -----------------------------------------------------------
|                                                           |
| INPUT FILE SIZE: 1024KB                                   |
|                                                           |
| TOTAL INPUT CHARACTERS: 1.048.576                         |
|                                                           |
| FREQUENCIES:                                              |
| A: 262_144.0  (25.00%                                     |
| C: 524_288.0  (50.00%)                                    |
| T: 131_072.0  (12.50%)                                    |
| G: 131_072.0  (12.50%)                                    |
|                                                           |
| OPTIONS:                                                  |
|                                                           |
| ALGORITHM: Run-Length Encoding (RLE)                      |
| TEXT-CODIFICATION: UTF-8                                  |
| COMPRESSION RATE: =~ 70%                                  |
|                                                           |
| OUTPUT FILE SIZE: 314,572.8 BYTES                         |
|                                                           |
 -----------------------------------------------------------
|                                                           |
| SCORE: WELL-DONE                                          |
|                                                           |
 -----------------------------------------------------------
```
### Descrição da saída de texto

1. Será um arquivo com extensão .txt .
2. O tamanho da saída será proporcional ao tamanho da entrada e de de qual for a performance do seu algoritmo $ (R_{ALG\_RLE}) $.
3. $R_{ALG\_RLE}$ é uma função de compressão, calculado a partir da divisão do tamanho do arquivo de entrada $(T_{INPUT})$ pelo tamanho do arquivo de saída $(T_{OUTPUT})$, da seguinte forma:

$$ E_{ALG\_RLE} = {T_{OUTPUT} \over T_{INPUT}} $$

## Estura do projeto

Para realizar essa atividade você e seu grupo deverá:

1. Fazer um Fork do projeto, como visto em aula
2. Desenvolver o projeto a partir da classe `src/main/java/br/com/fiap/twoespwx/libunclepresser/App.java`
3. O grupo pode criar novos diretórios desde que faça sentido. Cada decisão de projeto deverá ser justificada no relatório do Checkpoint.

```bash
fllsouto in check_point_fiap_esp_wx_s2_2024/checkpoint_1/libunclepresser on chk_pt1_writting  λ 
$ tree .

.
├── inputs
├── Makefile
├── outputs
│   └── OUTPUT1.TXT
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── br
    │           └── com
    │               └── fiap
    │                   └── twoespwx
    │                       └── libunclepresser
    │                           └── App.java
    └── test
        └── java
            └── br
                └── com
                    └── fiap
                        └── twoespwx
                            └── libunclepresser
                                └── AppTest.java

18 directories, 5 files

```

## Diretrizes para entrega do trabalho:

O presente trabalho terá sua nota dividida da seguinte forma:

- CÓDIGO: 60% de Peso
- RELATÓRIO: 40% de Peso

Serão aceitos grupos de 2 a 4 pessoas, grupos individuais serão aceitos caso a caso. A correção do código será feita levando em consideração os seguintes pontos:

- Organização do código
- Legibilidade do código
- Corretudo do código
- Completude do código
- Tratamento de erros
- Testes manuais e automatizados

E a do relatório seguirá os seguintes pontos:

- Estrutura do relatório
- Objetividade e clareza
- Domínio da escrita
- Apresentação dos resultados
- Pontualidade (Entregar depois da data definida por mim implica em Zero.)

O relatório deve ser escrito em markdown (https://www.markdownguide.org/) diretamente no arquivo [ARTICLE.md](ARTICLE.md)

## Dicas e Considerações

- Estude os commits e códigos produzidos nas aulas.
- Discutam em grupo, apenas em consenso chegamos às melhores ideias.
- Não use chatGPT ou qualquer tipo de IA/ML, chatbot, LLM ou coisa afim. Seu uso acarretará em zero para todo o grupo. 
- Não será tolerado plágios, um cientista de verdade compartilha e referencia suas fontes de forma correta. Não se constrói a Ciência de forma sozinha, apenas em comunidade. Faremos isso com cortêsia e consideração por aqueles que vieram antes de nós. Esse é o pensamento científico que adotaremos nessa e nas atividades futuras.
- Tirem dúvidas por e-mail comigo, costumo responder rápido
- Conversem entre vocês, mas não copiem um dos outros, isso também é plágio ;) .
- Se divirtam, esse é o objetivo final da ciência e desse trabalho:) .