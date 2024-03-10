import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value for n(length of array) :");
        int n = scanner.nextInt();
        int num[] = new int[n];

        System.out.println("Enter the elements of the array :");
        for(int i=0; i<n; i++){
            System.out.print("Enter the element at index "+(i+1)+" :");
            num[i] = scanner.nextInt();
        }

        for(int i=0; i<n; i++){
            System.out.println("The element at index "+(i+1)+" is : "+num[i]);
        }

        scanner.close();
        System.out.println();
        System.out.println("The average of the elements of the array is : "+average(num));
        System.out.println();

        int max = num[0];
        int maxIndex = 0;
        for(int i=0; i<n; i++){
            if(num[i]>max){
                max = num[i];
                maxIndex = i;
            }
        }
        System.out.println("The maximum element of the array is : "+max+" at index "+maxIndex);
        System.out.println();

        int min = num[0];
        int minIndex = 0;
        for(int i=0; i<n; i++){
            if(num[i]<min){
                min = num[i];
                minIndex = i;
            }
        }
        System.out.println("The minimum element of the array is : "+min+" at index "+minIndex);


    }
    public static double average(int[] num){
        int sum = 0;
        for(int i=0; i<num.length; i++) {
            sum += num[i];
        }
        return (double)sum/(double)num.length;
    }
}