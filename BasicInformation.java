import java.util.Scanner;

public class BasicInformation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("put students' heights here:");
        String input = sc.next();
        String[] input1 = input.split(",");
        int[] height = new int[input1.length];
        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(input1[i]);
        }

        System.out.println("All students' ID:");
        String input2 = sc.next();
        System.out.println("The student id that need to sort:");
        String sid = sc.next();
        String[] studentids = input2.split(",");

        String toStringID = "studentids = {";
        for (int i = 0; i < studentids.length; i++) {
            if (i==studentids.length-1){
                toStringID = toStringID+"\""+studentids[i]+"\"";
            }else {
                toStringID = toStringID+"\""+studentids[i]+"\",";
            }
        }
        System.out.println("heights = {"+input+"}");
        System.out.println("平均身高 average = "+avgHeight(height));

        System.out.println(toStringID+"}");
        System.out.println("Index : "+sortID(studentids,sid));



        sc.close();
    }

    public static double avgHeight(int[] h){
        double sum = 0;
        for (int i = 0; i < h.length; i++) {
            sum += h[i];
        }

        return sum/h.length;
    }

    public static int sortID(String[] studentids,String sid){
        int ip = -1;
        for (int i = 0; i < studentids.length; i++) {
            if (sid.equals(studentids[i])){
                ip = i;
            }
        }
        return ip;
    }
}
