package hello;

import java.util.ArrayList;
import java.util.Arrays;

class SimpleArrayList
{
	//�洢array������
	private Object[] elementData;
	
	//Ĭ������
	public static final int default_capacity = 10;
	
	//array��Ԫ�صĸ���
	private int size;
	
	//Ĭ�Ϲ��캯��
	public SimpleArrayList(){
		this.elementData = new Object[default_capacity];//10
	}
	
	//���ι��캯��,�Լ�ָ��������С
	public SimpleArrayList(int initialCapacity) {
		if(initialCapacity <= 0){
			//������Ч
			throw new IllegalArgumentException("IllegalArgument Error");
		}
		this.elementData = new Object[initialCapacity];
	}
	
	//���Ԫ��
	//����ֵ:�Ƿ���ӳɹ�
	public boolean Add(Object obj)
	{
		if (null == obj) {
			throw new IllegalArgumentException("invalid Argument!");
		}
		//��array����
		ensureCapacityInternal(size + 1);
		elementData[size++] = obj;
		
		return true;
	}
	
	public void clear()
	{
		//��elementData��Ԫ��ָ��NULL,��ʹ�������ջ�������
		for (int i = 0; i < elementData.length; i++) {
			elementData[i] = null;
		}
		
		//arrayԪ�ظ�������
		size = 0;
	}
	
	//�Ƴ�array�е�Ԫ��
	public boolean remove(Object obj)
	{
		//����elementData,����Ԫ��
		for (int index = 0; index < size; index++) {
			if(obj.equals(elementData[index]))//�Ƿ����
			{
				 fastRemove(index);
                 return true;
			}
		}
		return false;
	}
	
	private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
        	//��index�������Դ���ǰ�ƶ�
            System.arraycopy(elementData, index+1, elementData, index,numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }
	
	//����Ԫ���ܴ�С
	 public int size() {
	        return size;
	 }
	 
	 public Object get(int index) {
	        if(index > size)
	        	throw new IllegalArgumentException();

	        return elementData[index];
	    }
	
	//�漰��������ݿռ�����,��ʱ�Ȳ�����
	private void ensureCapacityInternal(int minCapacity) {
		//�������,��ǰ���������޷�����������ʱ
       if(minCapacity - elementData.length > 0)
       {
    	   //����Ϊ��ǰ������1.5��
    	   int oldCapacity = elementData.length;
    	   int newCapacity = oldCapacity *3/2;
    	   
    	   //�ڲ�����������,��elementData��Ԫ�ؿ�����������
    	   elementData = Arrays.copyOf(elementData, newCapacity);
       }
    }
};


public class Hello {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<E>
		SimpleArrayList myList =  new SimpleArrayList();
		for (int i = 0; i < 6; i++) {
			myList.Add(i*2);
		}
		
		for (int i = 0; i < myList.size(); i++) {
			System.out.println("value is "+myList.get(i));
		}
		
		System.out.println("hello world");
	}
}
