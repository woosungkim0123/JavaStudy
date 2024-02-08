package flyweight.normal;

public class Terrain {

    // 지형 타일 크기
    public static final int CANVAS_SIZE = 10000;

    // 나무 렌더링
    public void render(String type, Object mesh, Object texture, double position_x, double position_y) {

        Tree tree = new Tree(
                type, // 나무 종류
                mesh, // mesh
                texture, // texture
                Math.random() * CANVAS_SIZE, // position_x
                Math.random() * CANVAS_SIZE // position_y
        );

        System.out.println("X:" + tree.getPositionX() + " Y:" + tree.getPositionY() + " 위치에 " + type + " 나무 생성 완료");
    }
}
