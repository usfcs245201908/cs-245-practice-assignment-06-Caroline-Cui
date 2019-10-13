import java.lang.*;
import java.util.*;

public class ArrayQueue<T> implements Queue<T>
{
    public T arr[];
//    int size;
    public int count;
    public int first;
    public int last;

    public ArrayQueue()
    {
        arr = (T[]) new Object[20];
        first = 0;
        count = 0;
//        size = 20;
        last = 0;

    }

    private void resize(int capacity)
    {
        assert capacity >= count;
        T[] temp = (T[]) new Object[capacity];//resize queue
        for (int i = 0; i < count; i++) {
            temp[i] = arr[(first + i) % arr.length];
        }
        arr = temp;
        first = 0;
        last  = count;
    }

    @Override
    public T dequeue() throws Exception
    {
        if (empty())//check if empty
        {
            throw new NoSuchElementException("Try again!! ");
        }
        T fe = arr[first];
        arr[first] = null;
        first++;//pop the first item in the queue
//        first = (first + 1) % size;
        count--;
        if (first == arr.length) first = 0;
        if (count > 0 && count == (arr.length-1)/4) resize(arr.length/2);// shrink size
        return fe;
    }

    @Override
    public void enqueue(T item)
    {
        if (count == arr.length-1) resize(2* arr.length);// add length
        arr[last++] = item;// add item
//        last = (last +1) % size;
        if (last == arr.length) last = 0;
        count++;

//        arr[++last] = item;
//        count++;

    }

    @Override
    public boolean empty()
    {
        return count == 0;// check empty
    }
}
