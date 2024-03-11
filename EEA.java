/*
Name: Rahja Hansbrough
Class: Cryptography CS 3626
Section: W01
 */
public class Main {
    public static int negativeMod(int a, int b){ //This method is used in the EEA to simulate how a negative modular equation should be solved.
        if(a > 0){// If a is not negative then do the mod function as normal
            return a%b;
        }else{
            while(a<0){// keeps adding to the negative number till a turns positive
                a = a+b;
            }
            return a;
        }
    }
    public static String EEA(int a, int b ){
        if(a>b){ // this swaps the two variables to make things more constant with all tests
            int temp = a;
            a = b;
            b = temp;
        }
        if(a == 0){// Since zero has no inverse then there is no number that can make it inverse so the function will end before calculations are done
            return "No Inverse";
        }
        int p0 = 0;//starting p0 and p1
        int p1 = 1;
        int n = b;// this variable is here to make the negativeMod divisor consistent
        do{
            int q = b/a;// gives the current quotient of p
            int r = b%a;// gives the current remainder of p
            if(r == 0){// if the function divides evenly on the first loop then there is no inverse to be found
                return "No Inverse";
            }
            int newP = negativeMod((p0 - p1*q), n);
            p0 = p1;// set p1 to p0
            p1 = newP;//set newP to p1 to set up the next loop
            b = a;//also changing b and a's values to match the next step into Euclidean algorithm
            a = r;
            if(a == 1){// Once the remainder is 1 then the conditions are met and the inverse is found
                return ""+newP;
            }
        }while(a != 0);
        return "error";
    }
    public static void main(String[] args) {
        System.out.println("Answer1: "+EEA(24,8));
        System.out.println("Answer2: "+EEA(11,29));
        System.out.println("Answer3: "+EEA(0,983));
    }
}
