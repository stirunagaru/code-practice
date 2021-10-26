package backtrackingproblems;

import java.util.ArrayList;
import java.util.List;

//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]

public class GenerateParantheses {
	   List<String> pairs;
	    int n;
	    public List<String> generateParenthesis(int n) {
	         
	        pairs = new ArrayList();
	        this.n = n;
	        parentheses("", 0, 0);
	        return pairs;
	    }
	    
	    void parentheses(String s, int open, int close) {
	        if(s.length() == 2*n) {
	            pairs.add(s);
	            return;
	        }
	        if(open < n) parentheses(s+"(", open+1, close);
	        if(close < open) parentheses(s+")", open, close+1);
	    }  
}
//
//BEFORE ADDING: open < n i:--1 open:0 close:0 slen: 0 s:  with (
//BEFORE ADDING: open < n i:--2 open:1 close:0 slen: 1 s: ( with (
//BEFORE ADDING: open < n i:--3 open:2 close:0 slen: 2 s: (( with (
//BEFORE ADDING: close < open i:--4 open:3 close:0 slen: 3 s: ((( with )
//BEFORE ADDING: close < open i:--5 open:3 close:1 slen: 4 s: ((() with )
//BEFORE ADDING: close < open i:--6 open:3 close:2 slen: 5 s: ((()) with )
//slen i:--7 s:((()))
//
//AFTER ADDING: close < open i:--7 open:3 close:2 slen: 5 s: ((()) with )
//AFTER ADDING: close < open i:--7 open:3 close:1 slen: 4 s: ((() with )
//AFTER ADDING: close < open i:--7 open:3 close:0 slen: 3 s: ((( with )
//AFTER ADDING: open < n i:--7 open:2 close:0 slen: 2 s: (( with (
//
//BEFORE ADDING: close < open i:--7 open:2 close:0 slen: 2 s: (( with )
//BEFORE ADDING: open < n i:--8 open:2 close:1 slen: 3 s: (() with (
//BEFORE ADDING: close < open i:--9 open:3 close:1 slen: 4 s: (()( with )
//BEFORE ADDING: close < open i:--10 open:3 close:2 slen: 5 s: (()() with )
//slen i:--11 s:(()())
//
//AFTER ADDING: close < open i:--11 open:3 close:2 slen: 5 s: (()() with )
//AFTER ADDING: close < open i:--11 open:3 close:1 slen: 4 s: (()( with )
//AFTER ADDING: open < n i:--11 open:2 close:1 slen: 3 s: (() with (
//
//BEFORE ADDING: close < open i:--11 open:2 close:1 slen: 3 s: (() with )
//BEFORE ADDING: open < n i:--12 open:2 close:2 slen: 4 s: (()) with (
//BEFORE ADDING: close < open i:--13 open:3 close:2 slen: 5 s: (())( with )
//slen i:--14 s:(())()
//
//AFTER ADDING: close < open i:--14 open:3 close:2 slen: 5 s: (())( with )
//AFTER ADDING: open < n i:--14 open:2 close:2 slen: 4 s: (()) with (
//AFTER ADDING: close < open i:--14 open:2 close:1 slen: 3 s: (() with )
//AFTER ADDING: close < open i:--14 open:2 close:0 slen: 2 s: (( with )
//AFTER ADDING: open < n i:--14 open:1 close:0 slen: 1 s: ( with (
//
//BEFORE ADDING: close < open i:--14 open:1 close:0 slen: 1 s: ( with )
//BEFORE ADDING: open < n i:--15 open:1 close:1 slen: 2 s: () with (
//BEFORE ADDING: open < n i:--16 open:2 close:1 slen: 3 s: ()( with (
//BEFORE ADDING: close < open i:--17 open:3 close:1 slen: 4 s: ()(( with )
//BEFORE ADDING: close < open i:--18 open:3 close:2 slen: 5 s: ()(() with )
//slen i:--19 s:()(())
//AFTER ADDING: close < open i:--19 open:3 close:2 slen: 5 s: ()(() with )
//AFTER ADDING: close < open i:--19 open:3 close:1 slen: 4 s: ()(( with )
//AFTER ADDING: open < n i:--19 open:2 close:1 slen: 3 s: ()( with (
//BEFORE ADDING: close < open i:--19 open:2 close:1 slen: 3 s: ()( with )
//BEFORE ADDING: open < n i:--20 open:2 close:2 slen: 4 s: ()() with (
//BEFORE ADDING: close < open i:--21 open:3 close:2 slen: 5 s: ()()( with )
//slen i:--22 s:()()()
//AFTER ADDING: close < open i:--22 open:3 close:2 slen: 5 s: ()()( with )
//AFTER ADDING: open < n i:--22 open:2 close:2 slen: 4 s: ()() with (
//AFTER ADDING: close < open i:--22 open:2 close:1 slen: 3 s: ()( with )
//AFTER ADDING: open < n i:--22 open:1 close:1 slen: 2 s: () with (
//AFTER ADDING: close < open i:--22 open:1 close:0 slen: 1 s: ( with )
//AFTER ADDING: open < n i:--22 open:0 close:0 slen: 0 s:  with (
