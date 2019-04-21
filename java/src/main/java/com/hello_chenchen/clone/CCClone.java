class Money implements Cloneable {

    private int faceValue;

    private Area area;

    private String unit;

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public Money(int faceValue, Area area) {
        this.faceValue = faceValue;
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    protected Money clone() throws CloneNotSupportedException {
        return (Money) super.clone();
    }
}

class Area {

    // 钞票单位
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}

public class CCClone {

    public static void main(String[] args) {

        Area area = new Area();
        area.setUnit("RMB");

        // 原型实例，100RMB的钞票
        Money money = new Money(100, area);

        for (int i = 1; i <= 3; i++) {
            try {
                Money cloneMoney = money.clone();
                cloneMoney.setFaceValue(i * 100);
                System.out.println("这张是" + cloneMoney.getFaceValue() +  cloneMoney.getArea().getUnit() + "的钞票");
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }
}