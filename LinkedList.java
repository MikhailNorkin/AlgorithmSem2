package Task3;


import java.util.Comparator;

public class LinkedList<T> {

    public Node head;


    public Node getHead() {
        return head;
    }

    public class Node{
        public T value;
        public Node next;

    }

    public void directReturn(){

        Node node = head;
        //посчитаем сколько всего у нас нод:
        int NN = 0;
        while (node != null){
            NN = NN + 1;
            node = node.next;
        }    

        // если нод меньше двух, то разворачивать нечего
        if (NN < 2){
            return;
        }

        //поменяем значение у первой ноды на последнюю ноду, приближаясь к центру
        T buf1 = null;
        T buf2 = null;
        for (int i = 1; i <= NN/2 ; i++) {
            int N = 0;
            Node node2 = head;
            while (node2 != null){
                N = N + 1;
                if (N == i){
                    buf1 = node2.value;
                }else if (N == NN - i + 1 ){
                    buf2 = node2.value;
                    node2.value = buf1;
                    break;   
                }
                node2 = node2.next;
            } 
            N = 0;
            Node node3 = head;
            while (node3!= null){
                N = N + 1;
                if (N == i){
                    node3.value = buf2;
                    break;
                }    
                node3 = node3.next;
            }
        }     
    }

    /**
     * Поиск элемента в связанном списке
     * @param value
     * @return
     */
    public Node contains(T value){
        Node node = head;
        while (node != null){
            if (node.value.equals(value))
                return node;
            node = node.next;
        }
        return null;
    }

    public void directSort(Comparator<T> comparator){
        Node node = head;
        while (node != null){

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null){
                if (comparator.compare(minValueNode.value, node2.value) > 0){
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node){
                T buff = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buff;
            }

            node = node.next;
        }
    }


    public void addFirst(T value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head;
        }
        head = node;
    }

    public void removeFirst(){
        if (head != null){
            head = head.next;
        }
    }

    /**
     * Добавить элемент в конец связанного списка
     * @param value
     */
    public void addLast(T value){
        Node node = new Node();
        node.value = value;
        if (head == null)
            head = node;
        else {
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = node;
        }
    }

    public void removeLast(){
        if (head == null)
            return;
        Node node = head;
        while (node.next != null){
            if (node.next.next == null){
                node.next = null;
                return;
            }
            node = node.next;
        }
        head = null;

    }


}
