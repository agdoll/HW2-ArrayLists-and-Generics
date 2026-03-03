package HW1_Vectors_Generics;
import java.util.Vector;
import java.util.Random;

public class TestMain {
    public static void main(String[] args) {

        /*
        // TEST: TASK 1.1 Product class implementations
        Product p1 =  new Product("001", "Mirror",
                "Furniture", 39.99, 44, "Crystal Glass & Mirror Corp.");
        Product p2 = new Product("001", "Mirror",
                "Furniture", 39.99, 44, "Crystal Glass & Mirror Corp.");
        Product p3 = new Product("002", "White Lamp",
                "Furniture", 25.96, 30, "Ferguson Home");

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1 == p2);  // false

        System.out.println(p1.equals(p3)); // false
        System.out.println(p1 == p3); // false

        System.out.println(p1.equals(p1)); // true
        System.out.println(p1 == p1);  // true

        System.out.println(p1); // print formatting
        System.out.println(p2); // print formatting
        System.out.println(p3); // print formatting
        System.out.println();

         */

        // ---------------------------------------------------------------//

        // TEST: ProductInventory class implementations
        ProductInventory inventory = new ProductInventory();

        inventory.addProduct(new Product("P001", "Laptop",
                "Electronics", 999.99, 10, "TechCorp"));
        inventory.addProduct(new Product("P002", "T-Shirt",
                "Clothing", 19.99, 50, "FashionInc"));
        inventory.addProduct(new Product("P003", "Mouse",
                "Electronics", 29.99, 5, "TechCorp"));
        inventory.addProduct(new Product("P004", "Moisturizer",
                "Skincare", 17.99, 15, "SkinInc"));
        inventory.addProduct(new Product("P005", "Pants",
                "Clothing", 12.55, 24, "FashionInc"));
        inventory.addProduct(new Product("P006", "Cleanser",
                "Skincare", 22.99, 3, "SkinInc"));

        System.out.println();
        inventory.printAllProducts();

        System.out.println();
        // Case: adding a product null
        inventory.addProduct(null);
        // Case: adding a product already in inventory
        inventory.addProduct(new Product("P001", "Laptop",
                "Electronics", 999.99, 10, "TechCorp"));

        System.out.println();
        // Case: removing a product
        inventory.removeProduct("P002");
        // Case: removing a not existed or already removed product
        inventory.removeProduct("P002");  // already removed
        inventory.removeProduct("P008");  // not exist

        // Case: get list of electronic products
        System.out.println();
        Vector<Product> electronics = inventory.getProductsByCategory("Electronics");
        System.out.println("Electronics: " + electronics.size());
        System.out.println();
        // Case: get list of a category product not found.
        Vector<Product> furniture = inventory.getProductsByCategory("Furniture");
        System.out.println("Furniture: " + furniture.size());

        System.out.println();
        // Case: positive threshold quantity
        Vector<Product> lowStock = inventory.getLowStockProducts(10);
        System.out.println("Low stock items: " + lowStock.size());
        // Case: negative threshold quantity
        Vector<Product> lowStockNegative = inventory.getLowStockProducts(-5);

        System.out.println();
        // inventory total value
        inventory.printAllProducts();
        System.out.println("Total inventory value: $" + inventory.getTotalInventoryValue());

        // inventory capacity and size
        inventory.printCapacityInfo();

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println();

        // TEST: OrderManager, Order, and OrderItem classes implementations
        OrderManager orderManager = new OrderManager();

        Order order1 = new Order("O001", "Alice", "2024-01-15");
        order1.addItem(new OrderItem("P001", "Laptop", 1, 999.99));
        order1.addItem(new OrderItem("P003", "Mouse", 2, 29.99));
        order1.addItem(new OrderItem("P005", "Pants", 1, 12.55));
        orderManager.addOrder(order1);

        System.out.println();
        Order order2 = new Order("O002", "Bob", "2024-01-16");
        order2.addItem(new OrderItem("P002", "T-Shirt", 3, 19.99));
        orderManager.addOrder(order2);

        // case: adding a null item
        order1.addItem(null);
        // case: removing an item
        order1.removeItem("P004");
        System.out.println();
        orderManager.printAllOrders();  // order1 and order2

        System.out.println();
        // case: changing order status
        order1.updateStatus("Delivered");
        order1.printOrder();
        // case: invalid status order
        order1.updateStatus("Paused");

        System.out.println();
        System.out.println();
        orderManager.printAllOrders();
        System.out.println("Total revenue: $" + orderManager.getTotalRevenue());

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println();

        // TASK 1.3 new implementations
        System.out.println("- Before optimizing inventory capacity:* ");
        inventory.printCapacityInfo();
        System.out.println("- After optimizing inventory capacity: ");
        inventory.optimizeCapacity();  // trims capacity to match vector size

        System.out.println();
        inventory.ensureCapacity(20);
        System.out.println();
        inventory.printCapacityReport();

        // TASK 3.2 ENUMERATION
        inventory.printProductsUsingEnumeration();

        // TASK 3.3 VECTOR COMPARISON
        VectorComparisonDemo demo = new VectorComparisonDemo();
        demo.CompareVectorAndArrayList();








    }
}
