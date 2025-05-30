package edu.towson.cis.cosc442.project4.coffeemaker;

/**
 * CoffeeMaker object
 * 
 * @version $Revision: 1.0 $
 */
public class CoffeeMaker {
    /** Array of recipes in coffee maker */
    private Recipe[] recipeArray;
    /** Number of recipes in coffee maker */
    private final int NUM_RECIPES = 4;
    /** Array describing if the array is full */
    private boolean[] recipeFull;
    /** Inventory of the coffee maker */
    private Inventory inventory;

    /**
     * Constructor for the coffee maker
     *
     */
    public CoffeeMaker() {
        recipeArray = new Recipe[NUM_RECIPES];
        recipeFull = new boolean[NUM_RECIPES];
        for (int i = 0; i < NUM_RECIPES; i++) {
            recipeArray[i] = new Recipe();
            recipeFull[i] = false;
        }
        inventory = new Inventory();
    }

    /**
     * Returns true if a recipe is successfully added to the
     * coffee maker
     * 
     * @param r
     * @return boolean
     */
    public boolean addRecipe(Recipe r) {
        if (r == null) {
            return false;
        }
        boolean canAddRecipe = true;

        // Check if the recipe already exists
        for (int i = 0; i < NUM_RECIPES; i++) {
            if (r.equals(recipeArray[i])) {
                canAddRecipe = false;
            }
        }

        // Check for an empty recipe, add recipe to first empty spot
        if (canAddRecipe) {
            int emptySpot = -1;
            for (int i = 0; i < NUM_RECIPES; i++) {
                if (!recipeFull[i]) {
                    emptySpot = i;
                    break;
                }
            }
            if (emptySpot != -1) {
                recipeArray[emptySpot] = r;
                recipeFull[emptySpot] = true;
            } else {
                canAddRecipe = false;
            }
        }
        return canAddRecipe;
    }

    /**
     * Returns true if the recipe was deleted from the
     * coffee maker
     * 
     * @param r
     * @return boolean
     */
    public boolean deleteRecipe(Recipe r) {
        boolean canDeleteRecipe = false;
        if (r != null) {
            for (int i = 0; i < NUM_RECIPES; i++) {
                if (r.equals(recipeArray[i])) {
                    recipeArray[i] = new Recipe();
                    recipeFull[i] = false;
                    canDeleteRecipe = true;
                }
            }
        }
        return canDeleteRecipe;
    }

    /**
     * Returns true if the recipe is successfully edited
     * 
     * @param oldRecipe
     * @param newRecipe
     * @return boolean
     */
    public boolean editRecipe(Recipe oldRecipe, Recipe newRecipe) {
        boolean canEditRecipe = false;

        // Check if new recipe name already exists (excluding the old recipe)
        boolean nameExists = false;
        for (int i = 0; i < NUM_RECIPES; i++) {
            if (recipeArray[i].getName() != null && !oldRecipe.equals(recipeArray[i])) {
                if (newRecipe.equals(recipeArray[i])) {
                    nameExists = true;
                    break;
                }
            }
        }

        if (!nameExists) {
            for (int i = 0; i < NUM_RECIPES; i++) {
                if (recipeArray[i].getName() != null) {
                    if (oldRecipe.equals(recipeArray[i])) {
                        recipeArray[i] = newRecipe;
                        canEditRecipe = true;
                        break;
                    }
                }
            }
        }

        return canEditRecipe;
    }

    /**
     * Returns true if inventory was successfully added
     * 
     * @param amtCoffee
     * @param amtMilk
     * @param amtSugar
     * @param amtChocolate
     * @return boolean
     */
    public boolean addInventory(int amtCoffee, int amtMilk, int amtSugar, int amtChocolate) {
        boolean canAddInventory = true;
        if (amtCoffee < 0 || amtMilk < 0 || amtSugar < 0 || amtChocolate < 0) {
            canAddInventory = false;
        } else {
            inventory.setCoffee(inventory.getCoffee() + amtCoffee);
            inventory.setMilk(inventory.getMilk() + amtMilk);
            inventory.setSugar(inventory.getSugar() + amtSugar);
            inventory.setChocolate(inventory.getChocolate() + amtChocolate);
        }
        return canAddInventory;
    }

    /**
     * Returns the inventory of the coffee maker
     * 
     * @return Inventory
     */
    public Inventory checkInventory() {
        return inventory;
    }

    /**
     * Returns the change of a user's beverage purchase, or
     * the user's money if the beverage cannot be made
     * 
     * @param r
     * @param amtPaid
     * @return int
     */
    public int makeCoffee(Recipe r, int amtPaid) {
        if (r == null) {
            return amtPaid;
        }
        // First check if payment is sufficient
        if (amtPaid < r.getPrice()) {
            return r.getPrice(); // Return the full price if payment is insufficient
        }

        // Then check if we have enough ingredients
        if (!inventory.enoughIngredients(r)) {
            return amtPaid; // Return the payment amount if inventory is insufficient
        }

        // If we get here, we can make the coffee
        inventory.setCoffee(inventory.getCoffee() - r.getAmtCoffee());
        inventory.setMilk(inventory.getMilk() - r.getAmtMilk());
        inventory.setSugar(inventory.getSugar() - r.getAmtSugar());
        inventory.setChocolate(inventory.getChocolate() - r.getAmtChocolate());
        return amtPaid - r.getPrice(); // Return change
    }

    /**
     * Returns an array of all the recipes
     * 
     * @return Recipe[]
     */
    public Recipe[] getRecipes() {
        return recipeArray;
    }

    /**
     * Returns the Recipe associated with the given name
     * 
     * @param name
     * @return Recipe
     */
    public Recipe getRecipeForName(String name) {
        Recipe r = new Recipe();
        for (int i = 0; i < NUM_RECIPES; i++) {
            if (recipeArray[i].getName() != null) {
                if ((recipeArray[i].getName()).equals(name)) {
                    r = recipeArray[i];
                }
            }
        }
        return r;
    }
}
