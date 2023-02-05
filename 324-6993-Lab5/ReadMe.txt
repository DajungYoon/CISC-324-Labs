Part 1:
Taking the official L

Part 2:
FIFO: 
Step 1. traverse the pages. 
Step 2. If the memory has less pages than capacity; else Pop and Replace the topmost page in the queue which 
inserted first with the page (current) from the string and increase the page fault count.
Step 3. Push the pages in set one at a time until the size of set does 
not overflow or all page requests are satisfied. And increment the page fault and return. 
Step 4. If that current page is already available in the memory, do nothing. 
Step 5. Pop and Replace the topmost page in the queue which 
inserted first with the page from the string and increase the page fault count.

LRU:
Step 1: traverse the pages. 
Step 2: If the memory has less pages than capacity; else Pop and Replace the topmost page in the queue which 
inserted first with the page (current) from the string and increase the page fault count.
Step 3: If that current page is already available in the memory, do nothing. 
Step 4:Find the page in the set that was least recently used
Step 5:Pop and replace the page with the minimum index. Increment page fault and update current index

MFU:
Step 1: traverse the pages. 
Step 2: If the memory has less pages than capacity; else Pop and Replace the topmost page in the queue which 
inserted first with the page (current) from the string and increase the page fault count.
Step 3: If that current page is already available in the memory, do nothing. 
Step 4:Find the page in the set that was most recently used
Step 5:Pop and replace the page with the maximum index. Increment page fault and update current index

