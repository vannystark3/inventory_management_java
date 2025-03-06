package org;

import org.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ProductInventoryApplication {

    private final ProductService productService;

    @Autowired
    public ProductInventoryApplication(ProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProductInventoryApplication.class, args);
        ProductInventoryApplication app = context.getBean(ProductInventoryApplication.class);
        app.runApp();
    }

    public void runApp() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Product \n2. Delete Product \n3. List Products \n4. Get Product by ID \n5. Update Product \n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice==1){
                productService.addProduct();
            }
            else if(choice==2){
                productService.deleteProduct();
            }
            else if(choice==3){
                productService.listProducts();
            }
            else if(choice==4){
                productService.getProductById();
            }
            else if(choice==5){
                productService.updateProduct();
            }
            else if(choice==6){
                System.out.println("Application exit initiated");
                sc.close();
                return;
            }
            else{
                System.out.println("Invalid Input!");
            }
        }
    }
}
