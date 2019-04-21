import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Money implements Serializable {

    private int faceValue;

    private Area area;

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

    @Override
    protected Money clone() throws CloneNotSupportedException {
        Money cloneMoney = null;
        try {
            // 调用deepClone，而不是Object的clone方法
            cloneMoney = (Money) deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cloneMoney;
    }

    // 通过序列化深拷贝
    public Object deepClone() throws IOException, ClassNotFoundException {
        //将对象写到流里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从流里读回来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}

class Area implements Serializable{

    // 钞票单位
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    // @Override
    // protected Area clone() throws CloneNotSupportedException {
    //     Area cloneArea = (Area) super.clone();
    //     return cloneArea;
    // }
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