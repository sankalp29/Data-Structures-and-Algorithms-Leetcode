/**
 * Time complexity : O(NlogN) (constructor) + O(logN) (changeRating) + O(logN) (highestRated)
 * Space complexity : O(N + D) (D = discarded food entries)
 */
class FoodRatings {
    private Map<String, PriorityQueue<FoodToRatings>> cuisineFoods;
    private Map<String, FoodToRatings> foodMap = new HashMap<>();
    Comparator<FoodToRatings> comparator = (f1, f2) -> {
        if (f1.rating == f2.rating) return (f1.food).compareTo(f2.food);
        return Integer.compare(f2.rating, f1.rating);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFoods = new HashMap<>();
        
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i], cuisine = cuisines[i];
            int rating = ratings[i];

            FoodToRatings foodRating = new FoodToRatings(food, rating, cuisine);
            cuisineFoods.putIfAbsent(cuisine, new PriorityQueue<>(comparator));
            cuisineFoods.get(cuisine).add(foodRating);

            foodMap.put(food, foodRating);
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodMap.get(food).discard();

        String cuisine = foodMap.get(food).cuisine;
        FoodToRatings foodRating = new FoodToRatings(food, newRating, cuisine);
        cuisineFoods.putIfAbsent(cuisine, new PriorityQueue<>(comparator));
        cuisineFoods.get(cuisine).add(foodRating);
        foodMap.put(food, foodRating);
    }
    
    public String highestRated(String cuisine) {
        while (!cuisineFoods.get(cuisine).isEmpty() && cuisineFoods.get(cuisine).peek().isDiscarded()) {
            cuisineFoods.get(cuisine).poll();
        }

        return cuisineFoods.get(cuisine).peek().food;
    }

    private static class FoodToRatings {
        public String food;
        public int rating;
        public boolean discarded;
        public String cuisine;

        public FoodToRatings(String food, int rating, String cuisine) {
            this.food = food;
            this.rating = rating;
            this.discarded = false;
            this.cuisine = cuisine;
        }

        public void discard() {
            discarded = true;
        }

        public boolean isDiscarded() {
            return discarded;
        }

        public String getCuisine() {
            return cuisine;
        }
    }
}