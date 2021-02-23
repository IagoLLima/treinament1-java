package entities;

public class Product {

  private String name;
  private Double price;
  private int quantity;

  public Product (){}

  public Product(String name, Double price) {
    this.name = name;
    this.price = price;
  }

  public Product(String name, Double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }

  public String priceTag (){
    StringBuilder sb = new StringBuilder();
    sb.append(name+" $ ");
    sb.append(String.format("%.2f",price));
    return sb.toString();
  }

  public double totalPrice (){
    return quantity*price;
  }  
  
}
