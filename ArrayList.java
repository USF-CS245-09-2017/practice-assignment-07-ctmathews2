import java.util.Arrays;
 
public class ArrayList<T> implements List<T> {
 
    private T[] arr;
    private int size = 0;
     
    public ArrayList(){
        arr = (T[]) (new Object[10]);
    }
     
    public T get(int pos){
        if(pos < size){
            return arr[pos];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
     
    public void add(T obj){
        if(arr.length-size <= 5){
            grow();
        }
        arr[size++] = obj;
    }

    public void add(int pos, T obj){
    	if(arr.length-size <= 5){
            grow();
        }
        T[] temp = (T[]) (new Object[arr.length]);
        System.arraycopy(arr,0,temp,0,pos);
        temp[pos] = obj;
        for(int i = pos; i < arr.length-1; i++){
        	temp[i+1] = arr[i];
        }
        System.arraycopy(temp,0,arr,0,temp.length);
        size++;
    }
     
    public T remove(int pos){
        if(pos < size){
            T obj = arr[pos];
            arr[pos] = null;
            int temp = pos;
            while(temp < size){
                arr[temp] = arr[temp+1];
                arr[temp+1] = null;
                temp++;
            }
            size--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
         
    }
     
    public int size(){
        return size;
    }
     
    private void grow(){
        arr = Arrays.copyOf(arr, arr.length*2);
    }
     
}