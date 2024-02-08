package flyweight.normal;

import flyweight.common.Memory;

public class Tree {
    private long objSize = 100;
    private String type; // 나무 종류

    private Object mesh; // 메쉬 데이터
    private Object texture; // 텍스처 데이터

    // 위치 변수
    private double positionX;
    private double positionY;

    public Tree(String type, Object mesh, Object texture, double positionX, double positionY) {
        this.type = type;
        this.mesh = mesh;
        this.texture = texture;
        this.positionX = positionX;
        this.positionY = positionY;

        // 나무 객체 생성시 메모리 사용량을 증가
        Memory.size += objSize;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
}
