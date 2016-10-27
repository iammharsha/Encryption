package inventory.management;

public class InventoryManagement {

    public static void main(String[] args) {
       ceaser ce = new ceaser();

       String something = ce.encrypt("helloiamharsha", "cse");
       System.out.println(something);

       something = ce.decrypt(something, "cse");
       System.out.println(something);

    }
    
}
