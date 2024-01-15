package d_oop.common;

public class Tv { // TV 설계도
    public String color;
    public boolean power;
    public int channel;

    public void power() { power = !power; }
    public void channelUp() { channel++; }
    public void channelDown() { channel--; }
}
