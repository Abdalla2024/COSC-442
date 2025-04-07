package edu.towson.cis.cosc442.project4.coffeemaker;

/**
 * Inventory for the coffee maker
 * 
 * @author Josh
 * @version $Revision: 1.0 $
 */
public class Inventory {

    private int coffee;
    private int milk;
    private int sugar;
    private int chocolate;

    public Inventory() {
        setCoffee(15);
        setMilk(15);
        setSugar(15);
        setChocolate(15);
    }

    /**
     * Method getChocolate.
     * 
     * @return int
     */
    public int getChocolate() {
        return chocolate;
    }

    /**
     * Method setChocolate.
     * 
     * @param chocolate int
     */
    public void setChocolate(int chocolate) {
        if (chocolate >= 0) {
            this.chocolate = chocolate;
        }
    }

    /**
     * Method getCoffee.
     * 
     * @return int
     */
    public int getCoffee() {
        return coffee;
    }

    /**
     * Method setCoffee.
     * 
     * @param coffee int
     */
    public void setCoffee(int coffee) {
        if (coffee >= 0) {
            this.coffee = coffee;
        }
    }

    /**
     * Method getMilk.
     * 
     * @return int
     */
    public int getMilk() {
        return milk;
    }

    /**
     * Method setMilk.
     * 
     * @param milk int
     */
    public void setMilk(int milk) {
        if (milk >= 0) {
            this.milk = milk;
        }
    }

    /**
     * Method getSugar.
     * 
     * @return int
     */
    public int getSugar() {
        return sugar;
    }

    /**
     * Method setSugar.
     * 
     * @param sugar int
     */
    public void setSugar(int sugar) {
        if (sugar >= 0) {
            this.sugar = sugar;
        }
    }

    /**
     * Returns true if there are enough ingredients to make
     * the beverage.
     * 
     * @param r
     * @return boolean
     */
    public boolean enoughIngredients(Recipe r) {
        if (r == null) {
            return false;
        }
        boolean isEnough = true;
        if (this.coffee < r.getAmtCoffee()) {
            isEnough = false;
        }
        if (this.milk < r.getAmtMilk()) {
            isEnough = false;
        }
        if (this.sugar < r.getAmtSugar()) {
            isEnough = false;
        }
        if (this.chocolate < r.getAmtChocolate()) {
            isEnough = false;
        }
        return isEnough;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    public String toString() {
        return "Coffee: " + getCoffee() + "\n" +
                "Milk: " + getMilk() + "\n" +
                "Sugar: " + getSugar() + "\n" +
                "Chocolate: " + getChocolate() + "\n";
    }
}
