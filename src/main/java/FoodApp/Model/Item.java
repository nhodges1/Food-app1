package FoodApp.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@ToString
@EqualsAndHashCode
//@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int foodId;
    @Column
    private String foodName;
    private int categoryId;
    private String description;
    private double priceOfItem;
    private String foodTag;


    public Item(int foodId, String foodName, int categoryId, String description, double priceOfItem, String foodTag){
        this.foodId = foodId;
        this.foodName = foodName;
        this. categoryId = categoryId;
        this.description = description;
        this.priceOfItem = priceOfItem;
        this.foodTag = foodTag;
    }

   @ManyToOne(fetch = FetchType.EAGER)
   @JsonBackReference
   private Cart cart;
}