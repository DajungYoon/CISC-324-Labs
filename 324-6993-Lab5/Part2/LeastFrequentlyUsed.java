package Part2;

public class LeastFrequentlyUsed implements IPageReplacementStrategy {
    //@Override
    /**
     * Returns page faults count using LRU page replacement algorithm
     * 
     * @param numOfFramesInPhysicalMemory: the physical memory value expressed in
     *                                     number of frames. Initially, all
     *                                     numOfFramesInPhysicalMemory are free
     * @param pages:                       the pages references that need to be
     *                                     allocated to the available frames
     */
    public int GetPageFaultsCount(int numOfFramesInPhysicalMemory, int[] pages, int value) {
        // TODO implement Least Frequently Used (LRU) page replacement algorithm
         HashSet<Integer> s = new HashSet<>(value);
        HashMap<Integer, Integer> indexes = new HashMap<>();
      
        // Start from initial page
        int page_faults = 0;
        for (int i=0; i<numOfFramesInPhysicalMemory; i++)
        {

            if (s.size() < value)
            {

                if (!s.contains(pages[i]))
                {
                    s.add(pages[i]);

                    page_faults++;
                }
      
                indexes.put(pages[i], i);
            }
      
            // If the set is full then do the LRU algorithm
            else
            {

                if (!s.contains(pages[i]))
                {
  
                    int lru = Integer.MAX_VALUE, val=Integer.MIN_VALUE;
                     
                    Iterator<Integer> itr = s.iterator();
                     
                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru)
                        {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }
                 
                    //same process as FIFO
                    s.remove(val);
                    indexes.remove(val);
                    s.add(pages[i]);
                    page_faults++;
                }
    
                indexes.put(pages[i], i);
            }
        }
      
        return 0;
    }
        
}
