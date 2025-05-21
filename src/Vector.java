public class Vector {
    private int dim;
    private int[] elementos;

   public Vector(int dim, int[] elementos){
       if(dim <=0){
           System.out.println("Dimensão inválida para vetor.");
       } else{
           this.dim = dim;
           this.elementos = new int[dim];
           for (int i = 0; i < dim; i++) {
               this.elementos[i] = elementos[i];
           }
       }

   }
   public void imprimirVetor(){
       for (int i = 0; i < dim; i++) {
            System.out.print(elementos[i]+" ");
       }
   }
   public void imprimirVetorTranposto(){
    for (int i = 0; i < dim; i++) {
         System.out.println(elementos[i]);
    }
}
   public int elementoVetor(int pos){
       return elementos[pos - 1];
   }
   public void mudarElemento(int lugar, int value){
       this.elementos[lugar - 1] = value;
   }
public int getDim() {
    return dim;
}
public void setDim(int dim) {
    this.dim = dim;
}
   
}
