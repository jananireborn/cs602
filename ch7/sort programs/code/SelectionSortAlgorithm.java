/**
 * @author      Janani Swaminathan 
 * @version     1.0                                   
 * @since       10/23/2012  
 */
public class SelectionSortAlgorithm extends SortAlgorithm {
  public SelectionSortAlgorithm(AlgorithmAnimator animator) {
    super(animator); 
  }


/**
Sorting logic using the Selection Sort Algorithm

@param a[] array to be sorted using insertion sort
@param i integer for holding the array position
@param j integer for holding the array position
@param min interger for holding the minimum value
*/

  void sort(int a[]) {
     int i, j, min;

     for (i =0; i< a.length; i++) {
        
          for (j = i+1; j<a.length; j++)
		 {  if (a[j] < a[i])
             {
		   swap(a,i,j);
		    pause();
		 } }
          		 
     }   

  }
}


