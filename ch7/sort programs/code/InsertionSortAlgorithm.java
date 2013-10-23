
/**
 * @author      Janani Swaminathan 
 * @version     1.0                                   
 * @since       10/23/2012  
 */

public class InsertionSortAlgorithm extends SortAlgorithm {
  public InsertionSortAlgorithm(AlgorithmAnimator animator) {
    super(animator); 
  }

/**
Sorting logic using the Insertion Sort Algorithm

@param a[] array to be sorted using insertion sort
@param i integer for holding the array position
@param j integer for holding the array position

*/
  void sort(int a[]) {
    for (int i = 0; i < a.length-1; i++)
      for (int j = i + 1; j > 0 ; j--) {
        if (a[j] < a[j-1])
          swap(a, j, j-1);
        pause();
      }
  }
}