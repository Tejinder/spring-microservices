package com.example.demo;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
class Item {

	public Item() {
       
    }
	public Item(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

@RepositoryRestResource
interface ItemRepository extends JpaRepository<Item, Long> {}

@Component
class ItemInitializer implements CommandLineRunner {

    private final ItemRepository itemRepository;

    ItemInitializer(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok")
                .forEach(item -> itemRepository.save(new Item(item)));
        
       /*
        itemRepository.save(new Item("Lining"));
        itemRepository.save(new Item("PUMA"));
        itemRepository.save(new Item("Bad Boy"));
        itemRepository.save(new Item("Air Jordan"));
        itemRepository.save(new Item("Nike"));
        itemRepository.save(new Item("Adidas"));
        itemRepository.save(new Item("Reebok"));
       
	*/
       // itemRepository.findAll().forEach(System.out::println);
        
        List<Item> itemList = itemRepository.findAll();
        for(Item item: itemList)
        {
        	System.out.println(item.getName());
        }
        
        
    }
}