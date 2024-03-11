import java.util.*;
public class BlueRayCollection {
    private Node head;
    public BlueRayCollection(){
        head = null;
    }
    public void add(String t, String d, int y, double c){
        Node disk = new Node();
        disk.data = new BlueRayDisk(t,d,y,c);
        if(head == null){
            head = disk;
        }else{
            Node current = head;
            while(current.next != null)
                current = current.next;
            current.next = disk;
        }
    }
    public void show_all(){
        Node current = head;
        String data = " ";
        while(current != null){
            data += current.data.toString() + "\n";
            current = current.next;
        }
        System.out.println(data);
    }
    public String search(String t){
        Node current = head;
        String not = "Not Found";
        while(current != null){
            if(current.data.getTitle().equals(t)){
                System.out.println(current.data);
                return"";
            }
            current = current.next;
        }
        System.out.println(not);
        return not;
    }
    public boolean remove(String t){
        Node current = head;
        Node previous = current;
        if(current == null){
            return false;
        }else{
            while(current != null){
                if(current.data.getTitle().equals(t)){
                    head = current.next;
                    return true;
                }
                previous = current;
                current = current.next;
                if(current.next == null){
                    return false;
                }
                previous.next = current.next;
            }
            return false;
        }
    }
}
