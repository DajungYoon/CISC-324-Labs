package Part2;

public class MostFrequentlyUsed implements IPageReplacementStrategy {
   // @Override
    /**
     * Returns page faults count using MFU page replacement algorithm
     * 
     * @param numOfFramesInPhysicalMemory: the physical memory value expressed in
     *                                     number of frames. Initially, all
     *                                     numOfFramesInPhysicalMemory are free
     * @param pages:                       the pages references that need to be
     *                                     allocated to the available frames
     */
     public int GetPageFaultsCount(int numOfFramesInPhysicalMemory, int[] pages, int value) {
        // TODO implement Most Frequently Used (MFU) page replacement algorithm

        HashSet<Integer> s = new HashSet<>(value);
        HashMap<Integer, Integer> indexes = new HashMap<>();
      
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
      
            else
            {

                if (!s.contains(pages[i]))
                {

                    int mru = Integer.MIN_VALUE, val=Integer.MAX_VALUE;
                     
                    Iterator<Integer> itr = s.iterator();
                     
                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) > mru)
                        {
                            mru = indexes.get(temp);
                            val = temp;
                        }
                    }
                 
      
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
