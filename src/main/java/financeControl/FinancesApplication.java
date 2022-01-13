package financeControl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class FinancesApplication {
    public static void main(String [] args) {
        SpringApplication.run(FinancesApplication.class, args);

        System.out.println("-----------Object created by builder-----------");

        Category category = new Category(
                1l, "Salário", "Recebimento de salário ");
        System.out.println(category.toString());

        Entry entry = new Entry(2l, 4l, "Salário", "Adiantamento Quinzenal",
                "revenue", "4708,15", "15/12/2021", true);
        System.out.println(entry.toString());

        System.out.println("-----------Empty objects, filled by the set-----------");

        Category category1 = new Category();
        category1.setId(4l);
        category1.setName("Pagamento");
        category1.setDescription("Pagamento de Fatura de Cartão");
        System.out.println(category1.toString());

        Entry entry1 = new Entry();
        entry1.setId(8l);
        entry1.setCategoryId(6l);
        entry1.setName("Shopping");
        entry1.setDescription("Lazer");
        entry1.setType("expense");
        entry1.setAmount("4509,85");
        entry1.setDate("30/12/2021");
        entry1.setPaid(true);
        System.out.println(entry1.toString());


        List<Product> products = new ArrayList<>();

        Product product1 = new Product();
        product1.setId(2l);
        product1.setName("Garrafa");
        product1.setDescription("Compra");
        product1.setPrice(30.00);
        product1.setPrice(product1.getPrice() + 10);
        products.add(product1);

        Product product2 = new Product();
        product2.setId(1l);
        product2.setName("Caneca");
        product2.setDescription("Compra");
        product2.setPrice(25.00);
        product2.setPrice(product2.getPrice() + 10);
        products.add(product2);

        Product product3 = new Product();
        product3.setId(3l);
        product3.setName("Caneta");
        product3.setDescription("Compra");
        product3.setPrice(10.00);
        product3.setPrice(product3.getPrice() + 10);
        products.add(product3);


        Product product4 = new Product();
        product4.setId(4l);
        product4.setName("Boneca");
        product4.setDescription("Compra");
        product4.setPrice(5.00);
        product4.setPrice(product4.getPrice() + 10);
        products.add(product4);


        Product product5 = new Product();
        product5.setId(5l);
        product5.setName("Sapato");
        product5.setDescription("Compra");
        product5.setPrice(55.00);
        product5.setPrice(product5.getPrice() + 10);
        products.add(product5);

        products.sort(Comparator.comparing(Product::getPrice).reversed());
        System.out.println("\n Produtos mais Caros : \n" + products.stream().limit(3).toList().toString());

        products.sort(Comparator.comparing(Product::getId));
        System.out.println("\n Todos os Produtos: \n" + products.stream().toList().toString());





    }
}