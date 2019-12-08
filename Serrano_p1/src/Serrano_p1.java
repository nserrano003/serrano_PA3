import java.security.SecureRandom;
import java.util.Scanner;

public class MultiplicationProblem {
    public static void main(String[] args){
        int a,b,d,i,right,l;
        int[] diff = {10,100,1000,10000};
        SecureRandom random = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        while(true) {
            System.out.println("Choose a difficulty level between 1 and 4.");
            d = scnr.nextInt();
            System.out.println("Choose a mode: 1 for addition, 2 for multiplication, 3 for subtraction," +
                    " 4 for division, 5 for all");
            l = scnr.nextInt();
            i = 0;
            right = 0;
            while (i != 10) {
                a = random.nextInt(diff[d-1]);
                b = random.nextInt(diff[d-1]);
                right += question(a, b, l, scnr, random);
                i++;
                if (i == 10) {
                    if ((right * 100) / 10 < 80) {
                        System.out.println("Please ask your teacher for extra help.");
                    } else {
                        System.out.println("Congratulations, you are ready to go to the next level!");
                    }
                }
            }
        }
    }

    public static int question(int a, int b, int l, Scanner scnr, SecureRandom random) {
        int c;
        int r;
        String[] numbers = {"plus", "times", "minus", "divided by"};
        boolean g = false;
        if (l < 5) {
            if(b == 0 && l == 4){
                b++;
            }
            System.out.println("How much is " + a + " " + numbers[l - 1] + " " + b + " ?");
            c = scnr.nextInt();
            if (c == arith(a, b, l)) {
                g = true;
                randomresponse(g, random);
                return 1;
            } else {
                randomresponse(g, random);
                return 0;
            }
        }
        else if(l == 5) {
            r = random.nextInt(4);
            r++;
            if(b == 0 && r == 4){
                b++;
            }
            System.out.println("How much is " + a + " " + numbers[r - 1] + " " + b + " ?");
            c = scnr.nextInt();
            if (c == arith(a, b, r)) {
                g = true;
                randomresponse(g, random);
                return 1;
            } else {
                randomresponse(g, random);
                return 0;
            }
        }
        return 0;
    }

    public static void randomresponse (boolean g, SecureRandom random){
        int a = random.nextInt(4);
        a++;
        if(g == true){
            switch(a){
                case 1:
                    System.out.println("Very good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else {
            switch (a) {
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }

    public static int arith(int a, int b, int l){
        if(l == 1){
            return a+b;
        }
        else if(l == 2){
            return a*b;
        }
        else if(l == 3){
            return a-b;
        }
        else if(l == 4){
            return a/b;
        }
        return 0;
    }

}
