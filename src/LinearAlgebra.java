public class LinearAlgebra {
    public static Matrix transpose(Matrix m) {
        byte rows = m.getRows();
        byte cols = m.getCols();
        float[] elementos = new float[rows * cols];
        for (byte i = 0; i < rows; i++) {
            for (byte j = 0; j < cols; j++) {
                elementos[j * rows + i] = m.elementoMatriz(i + 1, j + 1);
            }
        }
        return new Matrix(cols, rows, elementos);
    }
    public static Vector transpose(Vector v) {
        int[] elementos = new int[v.getDim()];
        for (int i = 0; i < v.getDim(); i++) {
            elementos[i] = v.elementoVetor(i + 1);
        }
        return new Vector(v.getDim(), elementos);
    }
    public static Matrix sum(Matrix m1, Matrix m2) {
        float[] elementos = new float[m1.getRows() * m1.getCols()];
        for (byte i = 0; i < m1.getRows(); i++) {
            for (byte j = 0; j < m1.getCols(); j++) {
                elementos[i * m1.getCols() + j] = m1.elementoMatriz(i + 1, j + 1) + m2.elementoMatriz(i + 1, j + 1);
            }
        }
        return new Matrix(m1.getRows(), m1.getCols(), elementos);
    }
    public static Vector sum(Vector v1, Vector v2) {
        int[] elementos = new int[v1.getDim()];
        for (int i = 0; i < v1.getDim(); i++) {
            elementos[i] = v1.elementoVetor(i + 1) + v2.elementoVetor(i + 1);
        }
        return new Vector(v1.getDim(), elementos);
    }
    public static Matrix times(Matrix m1, Matrix m2) {
        float[] elementos = new float[m1.getRows() * m1.getCols()];
        for (byte i = 0; i < m1.getRows(); i++) {
            for (byte j = 0; j < m1.getCols(); j++) {
                elementos[i * m1.getCols() + j] = m1.elementoMatriz(i + 1, j + 1) * m2.elementoMatriz(i + 1, j + 1);
            }
        }
        return new Matrix(m1.getRows(), m1.getCols(), elementos);
    }
    public static Vector times(Vector v1, Vector v2) {
        int[] elementos = new int[v1.getDim()];
        for (int i = 0; i < v1.getDim(); i++) {
            elementos[i] = v1.elementoVetor(i + 1) * v2.elementoVetor(i + 1);
        }
        return new Vector(v1.getDim(), elementos);
    }
    public static Matrix times(Matrix m, int scalar) {
        float[] elementos = new float[m.getRows() * m.getCols()];
        for (byte i = 0; i < m.getRows(); i++) {
            for (byte j = 0; j < m.getCols(); j++) {
                elementos[i * m.getCols() + j] = m.elementoMatriz(i + 1, j + 1) * scalar;
            }
        }
        return new Matrix(m.getRows(), m.getCols(), elementos);
    }
    public static Vector times(Vector v, int scalar) {
        int[] elementos = new int[v.getDim()];
        for (int i = 0; i < v.getDim(); i++) {
            elementos[i] = v.elementoVetor(i + 1) * scalar;
        }
        return new Vector(v.getDim(), elementos);
    }
    public static Matrix dot(Matrix m1, Matrix m2) {
        float[] elementos = new float[m1.getRows() * m2.getCols()];
        for (byte i = 0; i < m1.getRows(); i++) {
            for (byte j = 0; j < m2.getCols(); j++) {
                float sum = 0;
                for (byte k = 0; k < m1.getCols(); k++) {
                    sum += m1.elementoMatriz(i + 1, k + 1) * m2.elementoMatriz(k + 1, j + 1);
                }
                elementos[i * m2.getCols() + j] = sum;
            }
        }
        return new Matrix(m1.getRows(), m2.getCols(), elementos);
    }
    public static void Gauss(float[][] Matrix) {
        int n = Matrix.length;
        int m = Matrix[0].length;
        for (int k = 0; k < n - 1; k++) {
            int linhaMax = k;
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(Matrix[i][k]) > Math.abs(Matrix[linhaMax][k])) {
                    linhaMax = i;
                }
            }
            if (k != linhaMax) {
                float[] temp = Matrix[k];
                Matrix[k] = Matrix[linhaMax];
                Matrix[linhaMax] = temp;
            }
            for (int i = k + 1; i < n; i++) {
                float fator = Matrix[i][k] / Matrix[k][k];
                for (int j = k; j < m; j++) {
                    Matrix[i][j] -= fator * Matrix[k][j];
                }
            }
        }
        System.out.println("\nMatriz após eliminação de Gauss:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%.2f ", Matrix[i][j]);
            }
            System.out.println();
        }
        for (int k = 0; k < n; k++) {
            float pivo = Matrix[k][k];
            for (int j = k; j < m; j++) {
                Matrix[k][j] /= pivo;
            }
            for (int i = 0; i < n; i++) {
                if (i != k) {
                    float fator = Matrix[i][k];
                    for (int j = k; j < m; j++) {
                        Matrix[i][j] -= fator * Matrix[k][j];
                    }
                }
            }
        }
        System.out.println("\nMatriz após eliminação de Gauss-Jordan:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%.2f ", Matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static float[] Solve(float[][] matrizAmpliada, int maxInteracoes, float tolerancia) {
        int n = matrizAmpliada.length;
        float[] x = new float[n];
        float[] xNovo = new float[n];
        for (int iteracoes = 0; iteracoes < maxInteracoes; iteracoes++) {
            for (int i = 0; i < n; i++) {
                float soma = matrizAmpliada[i][n];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        soma -= matrizAmpliada[i][j] * x[j];
                    }
                }
                xNovo[i] = soma / matrizAmpliada[i][i];
            }
            boolean convergiu = true;
            for (int i = 0; i < n; i++) {
                if (Math.abs(xNovo[i] - x[i]) > tolerancia) {
                    convergiu = false;
                    break;
                }
            }
            if (convergiu) {
                return xNovo;
            }
            for (int i = 0; i < n; i++) {
                x[i] = xNovo[i];
            }
        }
        System.out.println("O método Solve não convergiu após " + maxInteracoes + " iterações");
        return xNovo;
    }

}

