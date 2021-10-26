package intresting;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
//         result.add(new ArrayList<>());
//         result.get(0).add(1);
        
//         for(int r = 1; r < numRows; r++) {
//             List<Integer> cur = new ArrayList<>();
//             List<Integer> prev = result.get(r-1);
//             cur.add(1);
            
//             for (int j = 1; j < r; j++) cur.add(prev.get(j-1) + prev.get(j));
            
//             cur.add(1);
//             result.add(cur);
//         }
        
//         return result;
        
        List<List<Integer>> allRows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            row.add(0,1);
            for(int j=1; j<row.size()-1;j++){
                row.set(j, row.get(j)+row.get(j+1));
            }
            allRows.add(new ArrayList<>(row));
        }
        return allRows;
    }
}
