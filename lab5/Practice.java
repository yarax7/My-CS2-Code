class Practice{
    public static void main(String[] args){
        System.out.println("Sum of digits: "+sumOfDigits(25));
        System.out.println("Factorial: "+factorial(5));
        System.out.println("Power: "+powerOfNum(5,2));
        System.out.println("Reverse String "+reverseString("Cat"));
    }

    public static int sumOfDigits(int n){
        int right=0;
        int sum=0;
       if(n>=1 && n<=100){
            if(n==0){
                return sum;
            }
        right = n%10;
        sum+=right;
        return sum + sumOfDigits(n/10);
        } else {
          System.out.println("Invalid number");
          return 0;
        }
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }

    public static int powerOfNum( int base, int exponent){
        int result=1;
        if(exponent==0){
            return 1;
        }
        result= result*base;
        return result * powerOfNum(base, exponent-1);
    }

    public static String reverseString(String s){
        int numChars=s.length();
        if(numChars==0){
            return "";
        }
        return s.charAt(s.length()-1)+ reverseString(s.substring(0, s.length()-1));
    }
}