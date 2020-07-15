package Bridge_21;

class RedColor implements IColor {
    @Override
    public void fillWithColor(int border) {
        System.out.print("Red color with " + border + " inch border");
    }
}
