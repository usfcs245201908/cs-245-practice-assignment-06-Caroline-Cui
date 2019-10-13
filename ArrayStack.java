import java.lang.*;

public class ArrayStack<T> implements Stack<T>
{
    public T a[];
    int top;

    public ArrayStack()
    {
        a = (T[]) new Object[20];
//        int size = 20;
        top = -1;
    }


    @Override
    public void push(T item)
    {
        if (top == (a.length-1)) resize(2*a.length);// add size
        a[++top] = item;// add item
    }

    @Override
    public T pop() throws Exception
    {
        if (empty()) //make sure the stack is not empty before pop thing out
        {
            throw new Exception("Try again! ");
        }
        T item = a[top];//pop item
        a[top] = null;
        top--;
        if (top > 0 && top == (a.length-1)/4) resize(a.length/2);//shrink size
        return item;
    }

    private void resize(int c)
    {
        assert c >= top;
        T[] temp = (T[]) new Object[c];// resize array
        for (int i = 0; i <= top; i++)
        {
            temp[i] = a[i];
        }
        a = temp;

    }

    @Override
    public T peek() throws Exception
    {
        if (empty())
        {
            throw new Exception("Try again! ");
        }
        return a[top];// return last item
    }

    @Override
    public boolean empty()
    {

        return top == -1; // check if empty
    }
}
