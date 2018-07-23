/**
* Project: rytry
* Package Name:package org.radnahs.tryOut.sears;
* File Name: Beautiful3Set.java
* Create Date: Oct 21, 2016
* Create Time: 4:03:19 PM
* Copyright: Copyright (c) 2016
* @author: Shantanu Sikdar, ssikdar
* @version 1.0
*/
package org.radnahs.tryOut.sears;

/**
 * You are given an integer . A set, , of triples  is beautiful if and only if:
 * 
 * 0<=xi,yi,zi
 * xi+yi+zi=n, Vi:1<=i<=S
 * Let X be the set of different xi's in S, Y be the set of different yi's in S, 
 * and Z be the set of different zi's in S in . Then |X|=|Y|=|Z|=|S|.
 * 
 * The third condition means that all xi's are pairwise distinct. The same goes for yi and zi.
 * 
 * Given , find any beautiful set having a maximum number of elements. 
 * Then print the cardinality of  (i.e., ) on a new line, followed by  lines 
 * where each line contains  space-separated integers describing the respective 
 * values of , , and .
 * 
 * Input Format

A single integer, .

Constraints

Output Format

On the first line, print the cardinality of  (i.e., ). 
For each of the  subsequent lines, print three space-separated numbers per line describing the respective values of , , and  for triple  in .

Sample Input

3
Sample Output

3
0 1 2
2 0 1
1 2 0
Explanation

In this case, . We need to construct a set, , of non-negative integer triples () where .  has the following triples:

We then print the cardinality of this set, , on a new line, followed by  lines where each line contains three space-separated values describing a triple in .
 * 
 * @author ssikdar
 *
 */

public class Beautiful3Set {

	public static void main(String[] args) {
		
	}

}
