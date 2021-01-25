package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

  public static void main(String[] args) throws ParseException {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    List<Product> lProducts = new ArrayList<>();

    System.out.print("Enter the number of products: ");
    int n = sc.nextInt();
    sc.nextLine();

    for (int i = 1; i <= n; i++) {
      System.out.println("Product #"+i+" data:");
      System.out.print("Common, used or imported (c/u/i)?");
      char type = sc.next().charAt(0);
      sc.nextLine();
      System.out.print("Name: ");
      String name = sc.nextLine();
      System.out.print("Price: ");
      double price = sc.nextDouble();
      if (type=='i'){
        System.out.print("Customs fee: ");
        double customsFee = sc.nextDouble();
        lProducts.add(new ImportedProduct(name, price, customsFee));
      } else if (type=='u'){
        System.out.print("Manufacture Date (yyyy-MM-dd): ");
        sc.nextLine();
        String manufactureDate = sc.nextLine();
        lProducts.add(new UsedProduct(name, price, sdf.parse(manufactureDate)));
      } else {
        lProducts.add(new Product(name, price));
      }
    }

    System.out.println();
    System.out.println("PRICE TAGS:"+"\n");
    for (Product product : lProducts) {
      System.out.println(product.priceTag());
    }

    sc.close();

  }

}
