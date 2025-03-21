/*

You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.

 

Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
Example 2:

Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
Example 3:

Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 

Constraints:

n == recipes.length == ingredients.length
1 <= n <= 100
1 <= ingredients[i].length, supplies.length <= 100
1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
All the values of recipes and supplies combined are unique.
Each ingredients[i] does not contain any duplicate values.

  */
//topological sort
class Solution {

    public List<String> findAllRecipes(
        String[] recipes,
        List<List<String>> ingredients,
        String[] supplies
    ) {
        // Store available supplies
        Set<String> hs = new HashSet<>();
        Map<String, Integer> recipeToIndex = new HashMap<>();
        Map<String, List<String>> dg = new HashMap<>();
        for (String supply : supplies) {
            hs.add(supply);
        }
        for (int idx = 0; idx < recipes.length; idx++) {
            recipeToIndex.put(recipes[idx], idx);
        }
        int[] indeg = new int[recipes.length];

        for(int r =0; r<recipes.length ; r++){
            for(String ing:ingredients.get(r)){
                if(!hs.contains(ing)){
                    dg.putIfAbsent(ing, new ArrayList<>());
                    dg.get(ing).add(recipes[r]);
                    indeg[r]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int recipeIdx = 0; recipeIdx < recipes.length; recipeIdx++) {
            if (indeg[recipeIdx] == 0) {
                q.add(recipeIdx);
            }
        }
        List<String> res = new ArrayList<>();

        while(!q.isEmpty()){
            int rind = q.poll();
            String recipe = recipes[rind];
            res.add(recipe);
            if(!dg.containsKey(recipe)) continue;
            for(String dr: dg.get(recipe)){
                if(--indeg[recipeToIndex.get(dr)]==0)
                    q.add(recipeToIndex.get(dr));
            }
        }
        return res;

        
}
}



//bfs


class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> hs = new HashSet<>();
        List<String> res = new ArrayList<String>();
        Queue<Integer> recipe = new LinkedList<>();

        for(String s:supplies) 
            hs.add(s);
       
        for(int i =0; i< recipes.length ; i++) 
            recipe.add(i);
        int lastSize = -1;
        while(lastSize < hs.size()){
            lastSize = hs.size();
            for(int i =0; i< recipe.size() ; i++){
                int cur = recipe.poll();
                boolean canMake = true;
                for(String ing: ingredients.get(cur)){
                    if(!hs.contains(ing)){
                        canMake = false;
                        break;
                    }
                }
                if(!canMake)
                    recipe.add(cur);
                else{
                    hs.add(recipes[cur]);
                    res.add(recipes[cur]);
                }

            }
        }
        return res;
        
    }
}
