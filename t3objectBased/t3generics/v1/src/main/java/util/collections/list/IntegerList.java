package util.collections.list;

public class IntegerList {
    
    private List<Integer> delegate;

    public IntegerList(){
        this.delegate = new List<Integer>();
    }

    public Integer sum(){
        Iterator<Integer> iterator = this.delegate.iterator();
        Integer sum = 0;
        while (iterator.hasNext()){
            sum += iterator.next();
        }
        return sum;
    }

    public Optional<Integer> min(){
        if
    }




}
