package flyweight.sub;

import flyweight.common.Memory;

// 공유하지 않는 상태를 가지는 객체
public class Tree_Flyweight {
    private long objSize = 10;

    private final TreeModel treeModel;

    private double positionX;
    private double positionY;

    public Tree_Flyweight(TreeModel treeModel, double positionX, double positionY) {
        this.treeModel = treeModel;
        this.positionX = positionX;
        this.positionY = positionY;

        Memory.size += objSize;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
}
