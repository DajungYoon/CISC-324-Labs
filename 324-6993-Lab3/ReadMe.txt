Dajung Yoon
Lab 3
Student #:20206993

README FILE

Most of my instructions are within the comments for each class.
Condensed version:

Writer File:
Within my writer file, once the the file is done writing, it will signal to 
the mutex file. The code then needs to check if there is a reader or a writer waiting. 
Writer gets priority. This was implemented by the lines 47 - 105.

There are multiple test cases within the writer and reader file. For the writer file, 
(line 47) if there is at least one active reader or writer, then make the writer wait first, 
if not, make sure there will be a waiting writer bu putting it into the write queue. 

Another test case (line 59)
Check if the queue is empty.

(line 74)
If there is a writer writing, then release the head in the queue
if not, then release the readers that were in queue

Once the writers are done, (line 92) the readers will then be able to write

Reader File:

The first test case that is test within the file is (line 39). 
Check if there are writers waiting and reading the file, say there are no writers left, 
then the readers can start their readingQueue. 

(Line 79) The queue needs to check if there is a last reader, but if there are still writers in queue. 
If there are still writers, since they get priority, their queue needs to get released. 

Synch File: 

As told in the lab file, as a hint, we are told to make two queues which in my code they are: readQueue, and waitQueue.

Another hint was to make multiple counters to track the readers in writers in each queue (activeReader, activeWriter, waitingReader, waitingWriter)

RandomSleep File:
This file was left alone.