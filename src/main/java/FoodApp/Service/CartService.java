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

    /* @Autowired
      public CartService(CartRepository cartRepository){
          this.cartRepository = cartRepository;
      }*/
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }



    public Cart getCartById(long Id){

        Optional<Cart> fooditemOptional = cartRepository.findById(Id);
        Cart cartItem = fooditemOptional.get();
        return cartItem;
    }


    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart addItemToCart(Long cartId, Long itemId) throws Exception {
        Cart cart = getCartById(cartId);
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception("Item not found with id " + itemId));

        cart.getItems().add(item);
        cart.setTotalPrice(cart.getTotalPrice() + item.getPriceOfItem());

        return cartRepository.save(cart);
    }


    public Cart removeItemFromCart(Long cartId, Long itemId) throws Exception {
        Cart cart = getCartById(cartId);
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new Exception("Item not found with id " + itemId));

        cart.getItems().remove(item);
        cart.setTotalPrice(cart.getTotalPrice() - item.getPriceOfItem());
        return cartRepository.save(cart);

    }
}