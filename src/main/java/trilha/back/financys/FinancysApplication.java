package trilha.back.financys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import trilha.back.financys.entities.Category;
import trilha.back.financys.entities.Entry;

@SpringBootApplication
public class FinancysApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancysApplication.class, args);

//		Category category1 = new Category();
//		category1.setId(4l);
//		category1.setName("Pagamento");
//		category1.setDescription("Pagamento de Fatura de Cartão");
//		System.out.println(category1.toString());
//
//		Entry entry1 = new Entry();
//		entry1.setId(8l);
//		entry1.setCategoryId(6l);
//		entry1.setName("Shopping");
//		entry1.setDescription("Lazer");
//		entry1.setType("expense");
//		entry1.setAmount("4509,85");
//		entry1.setDate("30/12/2021");
//		entry1.setPaid(true);
//		System.out.println(entry1.toString());

	}

}
