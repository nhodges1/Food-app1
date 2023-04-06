package FoodApp.Repository;

import FoodApp.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    @Query("FROM Item WHERE LOWER(foodName) LIKE %:foodName%")
    List<Item> findItemByFoodName(@Param("foodName") String foodName);


    @Query("FROM Item WHERE categoryId= :categoryId")
    List<Item> findItemByCategoryId(@Param("categoryId") long categoryId);

  /*  @Query("FROM Fooditem WHERE foodId = :foodId")
    List<Fooditem> findFooditemByFoodId(@Param("foodId")Long foodId );

    @Query("FROM Fooditem WHERE categoryId = :categoryId")
    List<Fooditem> findFooditemByCategoryId(@Param("categoryId")Long categoryId );

    @Query("FROM Fooditem WHERE priceOfItem = :priceOfItem")
    List<Fooditem> findFooditemByPrice(@Param("foodId")Long priceOfItem );*/

    @Query("FROM Item WHERE description= :description")
    List<Item> findItemByDescription(@Param("description")String description);

    @Query("FROM Item WHERE foodTag= :foodTag")
    List<Item> findItemByTag(@Param("foodTag")String foodTag);

}
