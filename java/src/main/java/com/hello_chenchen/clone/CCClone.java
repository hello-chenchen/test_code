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
        Money cloneMoney = (Money) super.clone();
        cloneMoney.area = this.area.clone();  // 增加Area的拷贝
        return cloneMoney;
    }
}

class Area implements Cloneable{

    // 钞票单位
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    protected Area clone() throws CloneNotSupportedException {
        Area cloneArea = (Area) super.clone();
        return cloneArea;
    }
}

public class CCClone {

    public static void main(String[] args) {

        Area area = new Area();
        area.setUnit("RMB");

        // 原型实例，100RMB的钞票
        Money money = new Money(100, area);

        try {
            Money cloneMoney = money.clone();
            cloneMoney.setFaceValue(200);
            area.setUnit("美元");

            System.out.println("原型实例的面值：" + money.getFaceValue() + money.getArea().getUnit());
            System.out.println("原型实例的面值：" + money.getFaceValue() + area.getUnit());
            System.out.println("拷贝实例的面值：" + cloneMoney.getFaceValue() + cloneMoney.getArea().getUnit());
            System.out.println("money.getArea() == cloneMoney.getArea(): " + (money.getArea() == cloneMoney.getArea()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}