// code by eleonoralion
// 16.02.2021
//
//

/* Школьный этап всероссийской олимпиады, 9-11 классы, Москва (версия CF)
A. Автобусные остановки
https://codeforces.com/gym/102811/problem/A
*/

public class Main{
    public static void main(String[] args){
        java.io.BufferedReader bf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        int K;
        int N;
        try {
            K = Integer.parseInt(bf.readLine());
            N = Integer.parseInt(bf.readLine());
            long startTime = System.currentTimeMillis();
            N%=K;
            System.out.println(Math.min(N, K-N));
            System.out.println(System.currentTimeMillis()-startTime);
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
    }
}


