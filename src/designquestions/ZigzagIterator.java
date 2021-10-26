package designquestions;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

    List<List<Integer>> zigZag = new ArrayList<>();
    
    int vectorPointer;
    int indexPointer;
    int total = 0;
    int readCount  = 0;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        vectorPointer = 0;   
        indexPointer = 0;
        zigZag.add(v1);
        zigZag.add(v2);
        total = v1.size() + v2.size(); // for loop more than 3;
    }

    public int next() {
        
       Integer item =0, ret = null;
       while(item < zigZag.size()){
            List<Integer> current = zigZag.get(vectorPointer);
            if(indexPointer < current.size()) {
                ret = current.get(indexPointer);
                readCount++;
            }
            item++;
            vectorPointer = (vectorPointer+1) % zigZag.size();

            if(vectorPointer == 0)  //cycle done
                indexPointer++;

            if(ret != null) 
                return ret;
        }
        return 0;
    }

    public boolean hasNext() {
        return readCount < total;
    }
}
