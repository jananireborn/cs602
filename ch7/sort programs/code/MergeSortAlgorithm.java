
public class MergeSortAlgorithm extends SortAlgorithm{
  void sort(int a[]) {
    mergeSort(a);
    }
  protected int[] mergeSort(int a[]){
    if (a.length >1 ){
      int aLeftLength = a.length/2;
      int aRightLength = a.length - aLeftLength;
      int aLeft[] = new int[aLeftLength];
      int aRight[] = new int[aRightLength];
      int j = 0;
      //copy elements of array to a left and right half arrays
      for (int i = 0; i < aLeftLength; i++)
        aLeft[i] = a[i];
      for (int i = aLeftLength; i < a.length; i++){
        aRight[j] = a[i];
        j++;
      }
      //recursively call mergeSort until length = 1;
      aLeft = mergeSort(aLeft);
      aRight = mergeSort(aRight);
      int i = 0;
      j = 0;
      int k = 0;
      //compare size of elements and swap
      while (aLeft.length !=j && aRight.length !=k){
        if (aLeft[j] <= aRight[k]){
          //the left element is bigger then the right so put in next spot of master array a[]
          a[i] = aLeft[j];
          i++;
          j++;
        }
        else{
          //the right element is bigger then the left so put right in next spot of a[]
          a[i] = aRight[k];
          i++;
          k++;
        }
        
      }
      //fill up the remaining spots in a[]
      while (aLeft.length !=j){
        a[i] = aLeft[j];
        i++;
        j++;
      }
      while (aRight.length != k){
        a[i] = aRight[k];
        i++;
        k++;
      }
    }
    pause();
    return a;
  }
  protected MergeSortAlgorithm(AlgorithmAnimator animator) {
    super(animator);
    // TODO Auto-generated constructor stub
  }

}