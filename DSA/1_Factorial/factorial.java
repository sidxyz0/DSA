class facto{
    facto(){
    }

    public int findFactorial(int n){
        if(n<0){
            System.out.println("Factorial of a negative integer does not exist");
            return 0;
        }
        if(n==0 || n==1){
            return 1;
        }
        else{
            return n*findFactorial(n-1);
        }
    }
}

public class factorial{
    public static void main(String args[]){
        facto a = new facto();
        System.out.println(a.findFactorial(4));
    }
}