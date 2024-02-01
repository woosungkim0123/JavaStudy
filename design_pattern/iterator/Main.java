package iterator;

import iterator.sub.Food;
import iterator.sub.FoodList;

import java.util.Iterator;

class Main {
    public static void main(String[] args) {
        /**
         * Iterator pattern
         * - Food: 음식
         * - FoodList: 음식 목록, 집합체를 다루기 위해 Iterable 인터페이스를 구현
         * - FoodListIterator: 음식 목록을 순회하기 위한 Iterator 인터페이스를 구현
         */

        FoodList foodList = makeFoodList();

        // 명시적으로 Iterator를 사용
        Iterator<Food> it = foodList.iterator();
        while (it.hasNext()) {
            Food food = it.next();
            System.out.println(food.getName());
        }

        System.out.println();

        // 확장 for문 사용 (내부적으로 Iterator를 사용)
        for (Food food : foodList) {
            System.out.println(food.getName());
        }
    }

    private static FoodList makeFoodList() {
        FoodList foodList = new FoodList(3);
        foodList.appendFood(new Food("pizza"));
        foodList.appendFood(new Food("hambuger"));
        foodList.appendFood(new Food("spaghetti"));
        return foodList;
    }


}
