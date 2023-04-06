package FoodApp.Controller;

import FoodApp.Model.Cart;
import FoodApp.Model.Item;
import FoodApp.Model.Account;
import FoodApp.Service.CartService;
import FoodApp.Service.ItemService;
import FoodApp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RestController
public class FoodAppController {

    AccountService accountService;
    ItemService itemService;
    CartService cartService;

    @Autowired
    public FoodAppController(AccountService accountService, ItemService itemService, CartService cartService) {
        this.itemService = itemService;
        this.accountService = accountService;
        this.cartService = cartService;
    }

    /**
     * USER ENDPOINTS
     *
     * Endpoint on POST localhost:9000/register responds with a JSON containing username and password.
     */

    @PostMapping("register")
    public Account register(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    /**
     * Endpoint on POST localhost:9000/login responds with a JSON containing username and password.
     */

    @PostMapping("login")
    public ResponseEntity<Map<String, String>> login(@RequestBody @NonNull Account account){
        Account exist = accountService.existingAccount(account.getUsername(), account.getPassword());
        if(exist != null){
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful.");
            return ResponseEntity.ok().body(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Invalid username or password.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


    /**
     * FOOD ENDPOINTS
     *
     * Endpoint on GET localhost:9000/items responds with a JSON containing all foods.
     */

    @GetMapping("items")
    public List<Item> getAllFoods() throws Exception {
        return itemService.getAllFoods();
    }

    /**
     * Endpoint on GET localhost:9000/items/{id} responds with a JSON containing item by name.
     */

    @GetMapping("items/{id}")
    public Item getItemById(@PathVariable long id){
        return itemService.getItemById(id);
    }


    /**
     * Endpoint on GET localhost:9000/items/{name} responds with a JSON containing item by name.
     */

    @GetMapping("items/name/{name}")
    public List<Item> getFoodByName(@PathVariable String name){
        return itemService.getItemByName(name);
    }


    /**
     * Endpoint on GET localhost:9000/items/{cat_id} responds with a JSON containing item by category id.
     */

    @GetMapping("items/category/{catId}")
    public List<Item> getFoodByCategory(@PathVariable long catId){
        return itemService.getItemByCategory(catId);
    }


    /**
     * Endpoint on GET localhost:9000/items/{tag} responds with a JSON containing item by tag.
     */

    @GetMapping("items/tag/{tag}")
    public List<Item> getFoodByTag(@PathVariable String tag){
        return itemService.getItemByTag(tag);
    }


    @GetMapping("carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }


    @GetMapping("cart/{id}")
    public Cart getCartById(@PathVariable long id) throws Exception{
        return  cartService.getCartById(id);
    }

    @PostMapping("cart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PostMapping("cart/{cartId}/{itemId}")
    public Cart addItemToCart(@PathVariable Long cartId, @PathVariable Long itemId) throws Exception {
        return cartService.addItemToCart(cartId, itemId);
    }

    @DeleteMapping("cart/{cartId}/{itemId}")
    public Cart removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId)throws Exception {
        return cartService.removeItemFromCart(cartId, itemId);
    }

}


