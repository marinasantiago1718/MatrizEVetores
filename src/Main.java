import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        System.out.println("Matriz");
        System.out.printf("Digite a quantidade de linhas: ");
        byte rows = prompt.nextByte();
        prompt.nextLine();
        System.out.printf("Digite a quantidade de colunas: ");
        byte cols = prompt.nextByte();
        prompt.nextLine();
        float[] elements = new float[rows * cols];
        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < elements.length; i++) {
            System.out.printf("Elemento %d: ", (i+1));
            elements[i] = prompt.nextInt();
        }
        Matrix matrizA = new Matrix(rows, cols, elements);
        System.out.println("    ");
        System.out.println("Número de linhas: " + matrizA.getRows());
        System.out.println("Número de colunas: " + matrizA.getCols());
        System.out.println("    ");
        System.out.println("Matriz gerada: ");
        matrizA.imprimirMatriz();
        System.out.println("    ");
        System.out.printf("Para buscar, digite a linha: ");
        int i = prompt.nextInt();
        System.out.printf("Digite a coluna: ");
        int j = prompt.nextInt();
        System.out.printf("Número correspondente: ");
        System.out.println(matrizA.elementoMatriz(i,j));
        System.out.println("    ");
        System.out.printf("Para alterar, digite a linha: ");
        int x = prompt.nextInt();
        System.out.printf("Digite a coluna: ");
        int y = prompt.nextInt();
        System.out.printf("Digite o valor: ");
        int valor = prompt.nextInt();
        System.out.println("    ");
        System.out.println("Matriz alterada:");
        matrizA.alterarElementoMatriz(x,y,valor);
        matrizA.imprimirMatriz();
        Matrix matrizTransposta = LinearAlgebra.transpose(matrizA);
        System.out.println("    ");
        System.out.println("Matriz Transposta:");
        matrizTransposta.imprimirMatriz();
        System.out.println("    ");
        System.out.printf("Digite um escalar para multiplicar a matriz: ");
        int escalar = prompt.nextInt();
        Matrix matrizEscalar = LinearAlgebra.times(matrizA, escalar);
        System.out.println("Matriz após multiplicação por escalar:");
        matrizEscalar.imprimirMatriz();
        System.out.println("    ");
        System.out.println("Digite os elementos de outra matriz para soma:");
        float[] elementsB = new float[rows * cols];
        for (i = 0; i < elementsB.length; i++) {
            System.out.printf("Elemento %d: ", (i + 1));
            elementsB[i] = prompt.nextInt();
        }
        Matrix matrizB = new Matrix(rows, cols, elementsB);
        Matrix matrizSoma = LinearAlgebra.sum(matrizA, matrizB);
        System.out.println("    ");
        System.out.println("Matriz Soma:");
        matrizSoma.imprimirMatriz();
        System.out.println("    ");
        System.out.println("Matriz Multiplicação elemento a elemento:");
        Matrix matrizMultElem = LinearAlgebra.times(matrizA, matrizB);
        matrizMultElem.imprimirMatriz();
        System.out.println("    ");
        float[] colunaAdicional = new float[rows];
            for (i = 0; i < colunaAdicional.length; i++) {
                System.out.printf("Digite o elemento %d da a coluna adicional: ", i+1);
                colunaAdicional[i] = prompt.nextInt();
            }
            float[][] matrizAmpliada = matrizA.MatrizAmpliada(colunaAdicional);
            System.out.println("    ");
            System.out.println("Matriz ampliada:");
            for (i = 0; i < matrizAmpliada.length; i++) {
                for (j = 0; j < matrizAmpliada[i].length; j++) {
                    System.out.print(matrizAmpliada[i][j] + " ");
                }
                System.out.println();
            }
        LinearAlgebra.Gauss(matrizAmpliada);
        System.out.print("\nDigite o número máximo de iterações para Solve: ");
        int maxInteracoes = prompt.nextInt();
        System.out.print("Digite a tolerância para a convergência: ");
        float tolerancia = prompt.nextFloat();
        float[] resultados = LinearAlgebra.Solve(matrizAmpliada, maxInteracoes, tolerancia);
        System.out.println("Solução encontrada pelo método Solve:");
        for (i = 0; i < resultados.length; i++) {
            System.out.printf("X%d = %.4f\n", i + 1, resultados[i]);
        }
        System.out.println("    ");
        System.out.println("Vetor");
        System.out.printf("Digite a dimensão do vetor: ");
        int dim = prompt.nextInt();
        int[] elementos = new int[dim];
        for (int k = 0; k < dim; k++) {
            System.out.printf("Digite o número %d: ", (k+1));
            elementos[k] = prompt.nextInt();
        }
        Vector vetorA = new Vector(dim, elementos);
        System.out.println("\nVetor:");
        vetorA.imprimirVetor();
        System.out.println("    ");
        System.out.printf("\nDigite a posição a buscar no vetor: ");
        int pos = prompt.nextInt();
        System.out.printf("Valor correspondente: ");
        System.out.println(vetorA.elementoVetor(pos));
        System.out.printf("Digite a posição a mudar no vetor: ");
        int lugar = prompt.nextInt();
        System.out.printf("Digite o valor a inserir no local: ");
        int value = prompt.nextInt();
        System.out.println("    ");
        System.out.println("Vetor alterado: ");
        vetorA.mudarElemento(lugar, value);
        vetorA.imprimirVetor();
        Vector vetorTransposto = LinearAlgebra.transpose(vetorA);
        System.out.println("    ");
        System.out.println("Vetor Transposto:");
        vetorTransposto.imprimirVetorTranposto(); 
        System.out.println("\nDigite os elementos de outro vetor para soma:");
        int[] elementosB = new int[dim];
        for (i = 0; i < elementosB.length; i++) {
            System.out.printf("Elemento %d: ", (i + 1));
            elementosB[i] = prompt.nextInt();
        }
        Vector vetorB = new Vector(dim, elementosB);
        Vector vetorSoma = LinearAlgebra.sum(vetorA, vetorB);
        System.out.println("    ");
        System.out.println("Vetor Soma:");
        vetorSoma.imprimirVetor();
        Vector vetorMultElem = LinearAlgebra.times(vetorA, vetorB);
        System.out.println("    ");
        System.out.println("\nVetor Multiplicação elemento a elemento:");
        vetorMultElem.imprimirVetor();
        prompt.close();
    }
}