package dat.entities;

public class CartItem
{
    private Top top;
    private Bottom bottom;
    private int quantity;

    public CartItem(Top top, Bottom bottom, int quantity)
    {
        this.top = top;
        this.bottom = bottom;
        this.quantity = quantity;
    }

    public Top getTop()
    {
        return top;
    }

    public Bottom getBottom()
    {
        return bottom;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public int getPrice()
    {
        return quantity * (top.getPrice() + bottom.getPrice());
    }
}
