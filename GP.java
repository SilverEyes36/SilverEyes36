public class GP{
    private Gode head;
    public GP(){
        head = null;
    }
    public void addBack(int n){
        Gode g = new Gode();
        g.temp = n;
        Gode current = head;
        if(head == null){
            head = g;
        }else{
            while(current.next != null){
                current = current.next;
            }
            current.next = g;
        }
    }
    public void addFront(int n){
        Gode g = new Gode();
        g.temp = n;
        g.next = head;
        head = g;
    }
    public void search(int n){
        Gode current = head;

        if(head.temp == n){
            System.out.println("Found it");
        }
    }
    public void remove(int n){

    }
}
