package designquestions;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    List<Integer> prods ;
    int lastZero;
    
    public ProductOfNumbers() {
        prods = new ArrayList<>();
        lastZero = -1;
    }
    
    public void add(int num) {
        if(num == 0) {
           lastZero = prods.size();
           prods.add(1);
        } else if(prods.size() == 0)
            prods.add(num);
        else 
            prods.add(prods.get(prods.size()-1) * num);
    }
    
    public int getProduct(int k) {
        if(prods.size()-k <=  lastZero) 
            return 0;
            
        if(k == prods.size())
            return  prods.get(prods.size() - 1);
        int prod = prods.get(prods.size()-1)/prods.get(prods.size()-k-1);
        return prod;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

// // lastZero : 4
// k = 1
//     6-1 = 5 <= 4
//     60/
// 0 1 2 3    
// 2 3 5  2 
// 2 6 30 60
//     4-3 = 1-1
//     100/