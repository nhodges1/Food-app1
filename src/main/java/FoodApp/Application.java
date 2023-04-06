package FoodApp;

import FoodApp.Model.Item;
import FoodApp.Repository.ItemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    ItemRepository repo;
    public static Logger log = LogManager.getLogger();

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws  Exception{
        Item item1 = new Item (1, "Avocado Toast", 1, "Toast, fresh smashed avocado, lemon and sea salt", 6.00, "Gluten-free");
        repo.save(item1);
        Item item2 = new Item(2, "Spicy Poblano Omelette",1,"Eggs, Poblano peppers, red peppers, onions, shredded beef, cheese", 13.00, "Contains gluten");
        repo.save(item2);
        Item item3 = new Item(3, "Power Wrap", 1, "Egg whites, turkey, spinach, mushrooms and Mozzarella.", 10.00, "Cage-free");
        repo.save(item3);
        Item item4 = new Item(4, "Pancakes", 1, "Two pancakes topped with seasonal berries, creamy lemon curd and powdered cinnamon sugar.", 8.00, "Multi-grain");
        repo.save(item4);
        Item item5 = new Item(5, "French Toast", 1, "Custard-dipped brioche bread with whipped butter, powdered cinnamon sugar and berry compote.", 7.00, "Multi-grain");
        repo.save(item5);
        Item item6 = new Item(6, "Monterrey Club Sandwich", 1,  "Turkey, bacon, avocado, organic mixed greens, tomato, Monterey Jack and mayo on sourdough.", 13.00, "Multi-grain");
        repo.save(item6);
        Item item7 = new Item(7, "The Traditional", 1, "Scrambled eggs, bacon, seasoned potatoes, and toast", 12.00, "Contains gluten");
        repo.save(item7);
        Item item8 = new Item(8, "Cheese Burger", 2, "Sandwich, Ground beef, dill pickle chips, dill pickle relish, american", 6.00, "Contains gluten");
        repo.save(item8);
        Item item9 = new Item(9, "Cauliflower Tacos", 2, "Avocado, radishes, cilantro leaves with tender stems, and lime wedges", 15.00, "Vegan");
        repo.save(item9);
        Item item10 = new Item(10,"BBQ Ribs", 2, "Full rack of barbecue ribs with a side of fries", 25.00, "Gluten-free");
        repo.save(item10);
        Item item11 = new Item(11, "Chicken & Veggie Salad", 2, "Salad, grilled chicken breast, greens, cheese,sour cream", 13.00, "Gluten-free");
        repo.save(item11);
        Item item12 = new Item(12, "Filet Mignon", 2,"8oz filet mignon with a side of mashed potatoes and green beans", 25.00, "Gluten-free");
        repo.save(item12);
        Item item13 = new Item(13, "Chicken quesadilla",2, "Grilled chicken breast, peppers, cheese on a tortilla", 13.00, "Contains gluten");
        repo.save(item13);
        Item item14 = new Item(14, "Chicken Parmesan", 2, "Fried chicken topped with Mariana sauce and Parmesan cheese, with a side of spaghetti and mariana sauce", 20.00, "Contains gluten");
        repo.save(item14);
        Item item15 = new Item(15, "Buffalo Chicken melt",2,"Sandwich Crispy chicken tossed in sauce, cheese", 13.00, "Contains gluten");
        repo.save(item15);
    }
}
