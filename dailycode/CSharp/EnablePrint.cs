using System;
class EnablePrint {
    public static void Main(string [] args) 
    {
        EnablePrint(200);

    }

    public void EnablePrint(int N) {
        int num = N;
        while(num%10 == 0) {
            num = num/10;
        }

        while(num>0) {
            int curr = num %10;
            Console.Write(curr);
            num = num/10;
        }
    }

    public void solution(int N) {
        int enable_print = N % 10;
        while (N>0) {
            if(enable_print == 0) {
                enable_print = (N/10)%10;
            }
            else {
                Console.Write(N%10);
            }
            N = N/10;
        }
    }
}

// 54321