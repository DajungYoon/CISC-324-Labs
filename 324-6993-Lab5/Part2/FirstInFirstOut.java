package Part2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstInFirstOut implements IPageReplacementStrategy {
    //@Override
    /**
     * Returns page faults count using FIFO page replacement algorithm
     * 
     * @param numOfFramesInPhysicalMemory: the physical memory value expressed in
     *                                     number of frames. Initially, all
     *                                     numOfFramesInPhysicalMemory are free
     * @param pages:                       the pages references that need to be
     *                                     allocated to the available frames
     */

    public int GetPageFaultsCount(int numOfFramesInPhysicalMemory, int[] pages, int value ) {
        
        HashSet<Integer> s = new HashSet<>(value);
        Queue<Integer> indexes = new LinkedList<>() ;
      
        int page_faults = 0;

        for (int i=0; i<numOfFramesInPhysicalMemory; i++)
        {
            // Check the algorithm can hold the certain amount of pages
            if (s.size() < value)
            {
                //then insert the value
                if (!s.contains(pages[i]))
                {
                    s.add(pages[i]);
                    page_faults++;
                    indexes.add(pages[i]);
                }
            }
      
            //if the set is full, then perform the FIFO algorithm
            else
            {
                if (!s.contains(pages[i]))
                {
                    //insert the value from the queue into the index
                    int val = indexes.peek();
                    indexes.poll();
                    s.remove(val);
                    s.add(pages[i]);
                    indexes.add(pages[i]);
                    page_faults++;
                }
            }
        }

        return 0;
    }

 
}
