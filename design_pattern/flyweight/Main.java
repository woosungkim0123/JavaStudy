package flyweight;

import flyweight.common.Memory;
import flyweight.normal.Terrain;
import flyweight.sub.Terrain_Flyweight;
import flyweight.sub.TreeModel;
import flyweight.sub.TreeModelFactory;

public class Main {
    public static void main(String[] args) {
        /**
         * flyweight 패턴을 사용하지 않은 경우, 나무 객체를 생성할 때마다 메모리 사용량이 증가한다.
         */
        Memory.reset();
        Terrain terrain = new Terrain();

        // A타입 나무 10개 생성
        for (int i = 0; i < 10; i++) {
            terrain.render("A", new Object(), new Object(), Math.random() * Terrain.CANVAS_SIZE, Math.random() * Terrain.CANVAS_SIZE);
        }

        // B타입 나무 10개 생성
        for (int i = 0; i < 10; i++) {
            terrain.render("B", new Object(), new Object(), Math.random() * Terrain.CANVAS_SIZE, Math.random() * Terrain.CANVAS_SIZE);
        }

        // C타입 나무 10개 생성
        for (int i = 0; i < 10; i++) {
            terrain.render("C", new Object(), new Object(), Math.random() * Terrain.CANVAS_SIZE, Math.random() * Terrain.CANVAS_SIZE);
        }

        // 메모리 사용량 출력
        Memory.print(); // Total Memory used: 3000 (30그루 x 100MB) MB
        System.out.println();

        /**
         * flyweight 패턴을 사용한 경우
         * - 공통으로 사용되는 모델 데이터(mesh, texture)와 실시간으로 변하는 데이터(위치 데이터 X, Y)를 분리하여 객체를 구성
         * - 나무를 구현할 때 나무 인스턴스 하나를 공유받고 위치 매개변수만 다르게 설정해주면 메모리를 절약할 수 있다.
         */
        Memory.reset();
        Terrain_Flyweight terrain2 = new Terrain_Flyweight();

        // A타입 나무 10개 생성
        for (int i = 0; i < 10; i++) {
            terrain2.render("A", Math.random() * Terrain_Flyweight.CANVAS_SIZE, Math.random() * Terrain_Flyweight.CANVAS_SIZE);
        }

        // B타입 나무 10개 생성
        for (int i = 0; i < 10; i++) {
            terrain2.render("B", Math.random() * Terrain_Flyweight.CANVAS_SIZE, Math.random() * Terrain_Flyweight.CANVAS_SIZE);
        }

        // C타입 나무 10개 생성
        for (int i = 0; i < 10; i++) {
            terrain2.render("C", Math.random() * Terrain_Flyweight.CANVAS_SIZE, Math.random() * Terrain_Flyweight.CANVAS_SIZE);
        }

        Memory.print(); // Total Memory used: 570 ((90 * 3) + (10 * 10) + (10 * 10) + (10 * 10)) MB = (나무 모델 3개 + 나무 30그루) MB
        System.out.println();

        Memory.reset();
        TreeModelFactory.clearCache();
    }
}
