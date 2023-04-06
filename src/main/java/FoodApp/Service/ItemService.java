package FoodApp.Service;

import FoodApp.Model.Item;
import FoodApp.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    ItemRepository itemRepository;
    @Autowired
    ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }


    public List<Item> getAllFoods() {
        List<Item> list = itemRepository.findAll();
        return list;
    }

    public Item getItemById(long foodId){

      Optional<Item> fooditemOptional = itemRepository.findById(foodId);
      Item fooditem = fooditemOptional.get();
      return fooditem;
    }

    public List<Item> getItemByName(String foodName){
        return itemRepository.findItemByFoodName(foodName);
    }

    public List<Item> getItemByCategory(long catId){

        List<Item> fooditemOptional = itemRepository.findItemByCategoryId(catId);
        //Item fooditem = fooditemOptional.get();
        return fooditemOptional;
    }


    public List<Item> getItemByTag(String tag){
        return itemRepository.findItemByTag(tag);
    }
}
