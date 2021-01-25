package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class ProgramTax {

  public static void main(String[] args) {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<TaxPayer> lTaxPayers = new ArrayList<>();

    System.out.print("Enter the number of tax payers:");

    int numberTax = sc.nextInt();
    

    for (int i=1;i<=numberTax;i++){
      System.out.println("Tax payer #"+i+" data:");
      System.out.print("Individual or company (i/c)?");
      char type = sc.next().charAt(0);
      sc.nextLine();
      System.out.print("Name: ");
      String name = sc.nextLine();
      System.out.print("Anual income: ");
      double anualIncome = sc.nextDouble();

      if (type == 'i'){
        System.out.print("Health expenditures: ");
        double healthExpenditures = sc.nextDouble();
        lTaxPayers.add(new Individual(name, anualIncome, healthExpenditures));
      } else {
        System.out.print("Number of employees:");
        int numberOfEmployees = sc.nextInt();
        lTaxPayers.add(new Company(name, anualIncome, numberOfEmployees));
      }
    }

    System.out.println();
    System.out.println("TAXES PAID: ");
    double sum = 0;
    for (TaxPayer taxPayer : lTaxPayers) {
      System.out.println(taxPayer.getName()+": $ "+String.format("%.2f", taxPayer.tax()));
      sum +=taxPayer.tax();
    }
    System.out.println("TOTAL TAXES: $ "+String.format("%.2f", sum));

    sc.close();

  }
  
}
