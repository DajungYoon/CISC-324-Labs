package Part2;

public interface IPageReplacementStrategy {
    //added in int capacity
    public int GetPageFaultsCount(int numOfFramesInPhysicalMemory, int[] pages, int value);
}
