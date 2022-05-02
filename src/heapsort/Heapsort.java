package heapsort;

import java.util.Random;

public class Heapsort {

    public static void heapSort(int[] v) {
        buildMaxHeap(v);
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n);
        }
    }

    private static void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }
    }

    private static void maxHeapify(int[] v, int pos, int n) {
        int maxi;
        int l = 2 * pos;
        int right = 2 * pos + 1;
        if ((l < n) && (v[l] > v[pos])) {
            maxi = l;
        } else {
            maxi = pos;
        }
        if (right < n && v[right] > v[maxi]) {
            maxi = right;
        }
        if (maxi != pos) {
            swap(v, pos, maxi);
            maxHeapify(v, maxi, n);
        }
    }

    public static void swap(int[] v, int j, int aposJ) {
        int aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }

    

    public static void main(String args[]) {

        int tam1 = 100000;
        int vetor1[] = new int[tam1]; 
        int vetor2[] = new int[tam1];
        int vetor3[] = new int[tam1];

        for (int i = 0; i < tam1; i++) //Crescente
        {
            vetor1[i] = i;
        }

        for (int i = 0; i < tam1; i++) //Decrescente
        {
            vetor2[i] = tam1 - i;
        }

        Random valor1 = new Random(); //Aleatorio
        for (int i = 0; i < tam1; i++) {
            vetor3[i] = valor1.nextInt();
        }

        Heapsort sort = new Heapsort();

        long inicio1 = System.currentTimeMillis();
        sort.heapSort(vetor1);
        long fim1 = System.currentTimeMillis();
        System.out.println((fim1 - inicio1) + "\t");

         long inicio2 = System.currentTimeMillis(); 
         sort.heapSort(vetor2);
         long fim2 = System.currentTimeMillis();
         System.out.println((fim2-inicio2)+"\t");
        
         long inicio3 = System.currentTimeMillis(); 
         sort.heapSort(vetor3);
         long fim3 = System.currentTimeMillis();
         System.out.println((fim3-inicio3)+"\t");
    }

}
