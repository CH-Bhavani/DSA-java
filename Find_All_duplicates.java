/*



Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []




*/





class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> y = new ArrayList<>();
        int[] count = new int[nums.length];
        for (int n : nums) count[n-1]++;
        for (int i=0; i<count.length; i++) if (count[i] == 2) y.add(i+1);
        return y;
    }
}





public  List<Integer> findDuplicates(int[]arr)
        {
          List<Integer>al=new ArrayList<>();
          HashMap<Integer,Integer>hm=new HashMap<>();
          int n=arr.length;
        
          for(int i=0;i<n;i++)
           if(hm.containsKey(arr[i]))
            hm.put(arr[i],hm.get(arr[i])+1);
           else
            hm.put(arr[i],1);
        
          for(int key:hm.keySet())
            if(hm.get(key)==2)
              al.add(key);
        
          return al;
      }





 public  List<Integer> findDuplicates(int[]arr)
        {
          List<Integer>al=new ArrayList<>();
          Arrays.sort(arr);
          int n=arr.length;
      
          for(int i=0;i<n-1;i++)
            if(arr[i]==arr[i+1])
            {
              al.add(arr[i]);
              i++;
            }     

          return al;
        }




 public List<Integer> findDuplicates(int[]arr)
        {
          int n=arr.length,i=0;
          while(i<n)
          {
             int correctIndex=arr[i]-1;
             if(arr[correctIndex]==arr[i])
	             i++;
	         else //if arr[i] is not at its correct index
             {
               int temp=arr[correctIndex];
               arr[correctIndex]=arr[i];
               arr[i]=temp;
             }      
           }  
        
           List<Integer>al=new ArrayList<>();
           for (i=0; i<n; i++) 
             if(arr[i]!=i+1)
                al.add(arr[i]);
             
	    return al;
        }
