import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class B_Getting_Points{

    
    // Time complexity = O(sqrt(n))
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //GCD OF TWO NUMBERS
    public static long gcd(long a, long b){
        if(a == 0){
            return b;
        }

        return gcd(b % a, a);
    }

    //LCM OF TWO NUMBERS
    public static long LCM(int a, int b){
        return  ((long) a * b) / gcd(a, b);
    }

    //    FOR TAKING FASTER INPUTS
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int decimalToBinary(int decimal) {
        if (decimal == 0) {
            return 0;
        }
        int binary = 0;
        int place = 1;
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary += remainder * place;
            place *= 10;
            decimal = decimal / 2;
        }
        return binary;
    }


    public static void main(String args[]){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            long points = sc.nextLong();
            long lecture = sc.nextLong();
            long tasks = sc.nextLong();
            long tasks_available = 1 + (n-1)/7;
            long count = 0;
            if(points >= (tasks_available/2)*(2*tasks+lecture)) {
                points -= (tasks_available/2)*(2*tasks+lecture);
                count += tasks_available/2;
                if(points > 0 && (tasks_available & 1) == 1) {
                    points -= lecture+tasks;
                    count++;
                }
            }
            else if(points < (tasks_available/2)*(lecture+2*tasks)) {
                if(points%(lecture+tasks*2) == 0)
                count += points/(lecture+2*tasks);
                else 
                count += points/(lecture+2*tasks)+1;
                points = 0;
            }
            if(points > 0) {
                if(points % lecture == 0)
                count += points/lecture;
                else 
                count += points/lecture+1;
            }
            System.out.println(n-count);
            // long check = (long)((tasks_available/2))*(2*tasks+lecture);
            // if(check <= points) {
            //     count += tasks_available/2;
            //     points -= check;
            // }
            // else {
            //     count += Math.ceil(points/(tasks*2+lecture));
            //     points -= tasks*2+lecture*count;
            // }
            // if(tasks_available % 2 == 1 && points > 0) {
            //     points -= tasks+lecture;
            //     count++;
            // }
            // if(points > 0) {
            //     count += Math.ceil(points/lecture);
            // }
            // System.out.println((n-count));
        }
        out.flush();
    }
}