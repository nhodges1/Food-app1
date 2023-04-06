package FoodApp.Service;

import FoodApp.Model.Cart;
import FoodApp.Model.Item;
import FoodApp.Repository.CartRepository;
import FoodApp.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;

    /* @Autowired
      public CartService(CartRepository cartRepository){
          this.cartRepository = cartRepository;
      }*/
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

//    public List<Item> getItemFromCart(foodId){}


  /*  public Cart getCartById(int Id) {

        Optional<Cart> fooditemOptional = cartRepository.findById(id);
        Cart cartItem = fooditemOptional.get();
        return cartItem;
    }*/


    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart addToCart(int foodId) {

        Item items = itemService.getItemById(foodId);
        Cart cart = new Cart(items);

        if (items == null) {
            return null;
        } else

            return cartRepository.save(cart);
    }

  /*  public void deleteCart(int Id) {

        cartRepository.deleteById(Id);
    }


    public void deleteAll() {
        cartRepository.deleteAll();
    }

   public Cart removeItemFromCart(Long cartId) throws Exception {
        Cart cart = getCartById(cartId);


        cart.setTotalPrice(cart.getTotalPrice() - item.getPriceOfItem());
        return cartRepository.save(cart);

    }*/

  /*  public Long increaseCartQuantity(Long foodId) {
        long quantity = 0;

        Item items = itemService.getItemById(foodId);
        Cart cart = new Cart();
        if (items.getFoodId() == cart.getItems().getFoodId()) {

            quantity++;
        }
        return quantity;
    }

    public Long decreaseCartQuantity(Long Id) {

        long quantity= getCartById(Id).getQuantity();

        if(quantity>0)
         {

            quantity--;
        }
        return quantity;
    }
    public Long increaseCartQuantity1(Long Id) {

        long quantity= getCartById(Id).getQuantity();




            quantity++;

        return quantity;
    }*/

}