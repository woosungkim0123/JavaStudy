package iterator.sub;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FoodListIterator implements Iterator<Food> {
    private FoodList foodList;
    private int index;

    public FoodListIterator(FoodList foodList) {
        this.foodList = foodList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < foodList.getLength();
    }

    @Override
    public Food next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Food food = foodList.getFoodAt(index);
        index++;
        return food;
    }
}
