package flyweight.sub;

public class Terrain_Flyweight {

    // 지형 타일 크기
    public static final int CANVAS_SIZE = 10000;

    // 나무 렌더링
    public void render(String type, double position_x, double position_y) {
        // 1. 캐시 되어 있는 나무 모델 가져오기
        TreeModel model = TreeModelFactory.getInstance(type);

        // 2. 재사용한 나무 모델에 변화하는 속성인 위치 값으로 나무 생성
        Tree_Flyweight tree = new Tree_Flyweight(model, position_x, position_y);

        System.out.println("X:" + tree.getPositionX() + " Y:" + tree.getPositionY() + " 위치에 " + type + " 나무 생성 완료");
    }
}
