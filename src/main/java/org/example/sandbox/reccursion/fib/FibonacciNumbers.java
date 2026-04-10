package org.example.sandbox.reccursion.fib;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbers {

    private Map<Integer, BigInteger> map = new HashMap<>();

    public BigInteger fib(int n) {

        // base cases
        if (n == 0){
            return BigInteger.ZERO;
        }

        if (n == 1){
            return BigInteger.ONE;
        }

        return memo(n - 1).add(memo(n-2));
    }

    private BigInteger memo(int n){

         BigInteger value = map.get(n);

         if (value != null){
             return value;
         }

         value = fib(n);
         map.put(Integer.valueOf(n), value);

         return value;
    }
}
