package onboarding;

import java.util.ArrayList;

public class Problem3 {

    public static int solution(int n) {

        if (n < 1) return 0;

        ArrayList<Integer> lst369 = new ArrayList<>();
        int length = (int) Math.log10(n);
        int tmp = 0, res = 0;
        int each_num, q3_each_num;


        // 0 부터 10^1 - 1까지 369 개수 합, 10^1 ~ 10^2-1까지 369 개수 합, ...
        for(int i=0; i < length; i++){
            tmp += tmp * 9 + Math.pow(10, i) * 3;
            lst369.add(tmp);
        }


        for(int i = length; i>0; i--) {

            tmp         = (int) Math.pow(10, i);
            each_num    = n/tmp;
            q3_each_num = each_num/3;
            res        += each_num * lst369.get(i-1);

            if(q3_each_num>0) {
                for (int j=0; j < q3_each_num-1; j++){
                    res += Math.pow(10,i);
                }
                res += n%tmp + 1;
            }
            n %= tmp;
        }
        res += n/3;

        return res;
    }
}
