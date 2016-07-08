package zhinan.liang.action.model;

import java.io.Serializable;

/**
 * Created by liang on 2016/6/27.
 */
public class GuizeModel implements Serializable{
    private boolean one;
    private boolean two;
    private boolean three;
    private boolean four;
    private boolean five;
    private boolean six;

    public boolean isOne() {
        return one;
    }

    public void setOne(boolean one) {
        this.one = one;
    }

    public boolean isTwo() {
        return two;
    }

    public void setTwo(boolean two) {
        this.two = two;
    }

    public boolean isThree() {
        return three;
    }

    public void setThree(boolean three) {
        this.three = three;
    }

    public boolean isFour() {
        return four;
    }

    public void setFour(boolean four) {
        this.four = four;
    }

    public boolean isFive() {
        return five;
    }

    public void setFive(boolean five) {
        this.five = five;
    }

    public boolean isSix() {
        return six;
    }

    public void setSix(boolean six) {
        this.six = six;
    }
}
