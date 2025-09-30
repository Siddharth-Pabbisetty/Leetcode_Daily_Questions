//Daily Problem 17th September

import java.util.*;

class FoodDetails 
{
    String name;
    String cuisine;
    int rating;
    FoodDetails(String name, String cuisine, int rating)
    {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    private Map<String, FoodDetails> foodToFood;
    private Map<String, TreeSet<FoodDetails>> cuisineToFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToFood = new HashMap<>();
        cuisineToFoods = new HashMap<>();
        for (int i = 0; i < foods.length; i++)
        {
            FoodDetails foodD = new FoodDetails(foods[i], cuisines[i], ratings[i]);
            foodToFood.put(foods[i], foodD);
            cuisineToFoods
                    .computeIfAbsent(cuisines[i], k -> new TreeSet<>( (a, b) -> {
                        if (a.rating != b.rating) return Integer.compare(b.rating, a.rating);
                        return a.name.compareTo(b.name);
                    }))
                    .add(foodD);
        }
    }

    public void changeRating(String food, int newRating) {
        FoodDetails foodD = foodToFood.get(food);
        TreeSet<FoodDetails> set = cuisineToFoods.get(foodD.cuisine);
        set.remove(foodD);
        foodD.rating = newRating;
        set.add(foodD);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}
