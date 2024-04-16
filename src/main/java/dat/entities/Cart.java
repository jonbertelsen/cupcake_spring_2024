package dat.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart
{
    private List<CartItem> cartItemList = new ArrayList<>();

    public List<CartItem> getCartItemList()
    {
        return cartItemList;
    }

    public void add(Top top, Bottom bottom, int quantity)
    {
        CartItem cartItem = new CartItem(top, bottom, quantity);
        cartItemList.add(cartItem);
    }

    public int getTotalPrice()
    {
        int sum = 0;
        for (CartItem cartItem : cartItemList)
        {
            sum += cartItem.getPrice();
        }
        return sum;
    }

    public int getCount()
    {
        return cartItemList.size();
    }

    public void delete(int rowIndex)
    {
        cartItemList.remove(rowIndex);
    }
}
