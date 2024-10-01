import java.io.BufferedReader;
import java.time.Duration;
import java.time.Instant;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class C_Left_and_Right_Houses{

    
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


    public static void main(String args[]) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int count0left = 0, count0right = 0, count1left = 0, count1right = 0;
            for(int i=0;i<n;i++) {
                if(i < n/2) {
                    if(s.charAt(i) == '1')
                    count1left++;
                    else 
                    count0left++;
                }
                else {
                    if(s.charAt(i) == '0')
                    count0right++;
                    else 
                    count1right++;
                }
            }
            if(count0left >= count1left && count1right >= count0right) {
                System.out.println(n/2);
            }
            else {
                int a = count0left, b = count0right, c = count1left, d = count1right;
                int check1 = -1, check2 = -1;
                int flag = 0;
                for(int i=n/2;i<n;i++) {
                    if(s.charAt(i) == '1') {
                        count1left++;
                        count1right--;
                    }
                    else {
                        count0left++;
                        count0right--;
                    }
                    if(count0left >= count1left && count1right >= count0right) {
                        check1 = i+1;
                        flag++;
                        break;
                    }
                }
                count0left = a;
                count0right = b;
                count1left = c;
                count1right = d;
                for(int i=n/2-1;i>=0;i--) {
                    if(s.charAt(i) == '1') {
                        count1left--;
                        count1right++;
                    }
                    else {
                        count0left--;
                        count0right++;
                    }
                    if(count0left >= count1left && count1right >= count0right) {
                        check2 = i;
                        break;
                    }
                }
                double n1 = n;
                if(check1 == -1) {
                    System.out.println(check2);
                    continue;
                }
                else if(check2 == -1) {
                    System.out.println(check1);
                    continue;
                }
                if(n1/2-check2 <= check1-n1/2)
                System.out.println(check2);
                else 
                System.out.println(check1);
            }
        }
        out.flush();
    }
}