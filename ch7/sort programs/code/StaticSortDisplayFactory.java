public class StaticSortDisplayFactory 
    implements SortDisplayFactory {
  public SortDisplay makeSortDisplay(String name) {
    if ("horizontal".equals(name)) 
      return new HSortDisplay(); 
    else if ("vertical".equals(name)) 
      return new BarSortDisplay1(); 
    else if ("bottom".equals(name)) 
      return new BSortDisplay(); 
    else if ("bar".equals(name)) 
      return new BarSortDisplay(); 
    else 
      return new HSortDisplay(); 
  }
}
