public class MaxFrequency {

  // hashing
  // Time - O(n) , Space - O(n)
  static int mostFrequent(int arr[], int n) 
    {
        // Insert all elements in hash 
        Map<Integer, Integer> hp = 
               new HashMap<Integer, Integer>(); 
          
        for(int i = 0; i < n; i++) 
        { 
            int key = arr[i]; 
            if(hp.containsKey(key)) 
            { 
                int freq = hp.get(key); 
                freq++; 
                hp.put(key, freq); 
            } 
            else
            { 
                hp.put(key, 1); 
            } 
        } 
          
        // find max frequency. 
        int max_count = 0, res = -1; 
          
        for(Entry<Integer, Integer> val : hp.entrySet()) 
        { 
            if (max_count < val.getValue()) 
            { 
                res = val.getKey(); 
                max_count = val.getValue(); 
            } 
        } 
          
        return res; 
    } 
  
  // Moore's algo
  // Time - O(n) , Space - O(1)
static int maxFreq(int []arr, int n)  
{ 
    
    // using moore's voting algorithm 
    int res = 0; 
    int count = 1; 
    for(int i = 1; i < n; i++) { 
        if(arr[i] == arr[res]) { 
            count++; 
        } else { 
            count--; 
        } 
          
        if(count == 0) { 
            res = i; 
            count = 1; 
        }          
    } 
      
    return arr[res]; 
}

  
}

