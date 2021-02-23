package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class ProgramProduct {

	public static void main(String[] args) {


		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter with path");
		String strPath = sc.nextLine();

		File line = new File(strPath);
		String path = line.getParent();
	

		boolean success = new File(path + "\\out").mkdir();
		System.out.println("Director is ok?"+success);

		String file = path+"\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {

			
			String itemCsv = br.readLine();

			while (itemCsv != null){
				String [] fields = itemCsv.split(",");
				
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity));

				itemCsv = br.readLine();

			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
				for (Product product : list) {
					bw.write(product.getName()+","+String.format("%.2f", product.totalPrice()));
					bw.newLine();
				}

				System.out.println(file + " CREATED!");
				
			}
			catch (IOException e) {
				e.printStackTrace();
				}
		}

		catch (IOException e) {
			System.out.println("Erro " + e.getMessage());
		}

		finally{
			sc.close();
		}

	}

}
