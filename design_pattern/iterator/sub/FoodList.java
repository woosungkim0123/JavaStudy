package iterator.sub;

import java.util.Iterator;

public class FoodList implements Iterable<Food> {
    private Food[] foods;
    private int last = 0;

    public FoodList(int maxsize) {
        this.foods = new Food[maxsize];
    }

    public Food getFoodAt(int index) {
        return foods[index];
    }

    public void appendFood(Food food) {
        foods[last] = food;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Food> iterator() {
        return new FoodListIterator(this);
    }
}
