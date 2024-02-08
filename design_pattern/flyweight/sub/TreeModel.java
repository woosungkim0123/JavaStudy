package flyweight.sub;

import flyweight.common.Memory;

// ConcreteFlyweight - Flyweight 객체는 불변성을 지녀야함 (변하면 모든 것에 영향을 미침)
public class TreeModel {
    private final long objSize = 90;

    private final String type; // 나무 종류
    private final Object mesh; // 메쉬 데이터
    private final Object texture; // 텍스처 데이터

    public TreeModel(String type, Object mesh, Object texture) {
        this.type = type;
        this.mesh = mesh;
        this.texture = texture;

        Memory.size += objSize;
    }
}
