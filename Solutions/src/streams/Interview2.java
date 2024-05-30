package streams;

public class Interview2 {

    public static void main(String[] args) {

//
//        Write a program to left rotate the array by the given number.
//                Input:
//        {1,2,3,4,5,6,7,8}
//        int numOfRotation = 3;
//        output: 4,5,6,7,8,1,2,3

        int[] input = {1,2,3,4,5,6,7,8};
        int rotateBy = 3;

        int[] temp = new int[input.length];
        int counter =0;
        for(int i =rotateBy;i<input.length;i++){
            temp[counter] = input[i];
            counter++;
        }

        for(int i =0;i<rotateBy;i++){
            temp[counter] = input[i];
            counter++;
        }

        for(int i =0;i<temp.length;i++){
            System.out.print(temp[i] +" ");
        }




    }
}
