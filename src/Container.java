import java.util.ArrayList;

/**
 * Created by grizzly on 23-Nov-15.
 */
public class Container {
    protected int size =0;
    ArrayList <Integer> goods = new ArrayList<Integer>();

    public Container(Container container) {
        this.goods=new ArrayList(container.goods);
        this.size=container.size;
    }
    public Container()
    {
        this.size=0;
        this.goods.clear();
    }

    protected void setGoods(int good) {
        this.goods.add(good);
        this.size=this.size+good;
        System.out.println("Added goods.new free size="+this.size );
    }
}
