package Part1;

public class PagingStatisticalProcessor {
    private long physicalMemorySize;
    private long pageSize;
    private int pageOffsetNumOfBits;

    public PagingStatisticalProcessor() {
        super();
    }

    public PagingStatisticalProcessor(long physicalMemorySize, long pageSize, int pageOffsetNumOfBits) {
        super();
        this.physicalMemorySize = physicalMemorySize;
        this.pageSize = pageSize;
        this.pageOffsetNumOfBits = pageOffsetNumOfBits;
    }

    public void PrintStatisticalInformation() {
        // TODO: according to the lab's document, please print the relevant information
    }

    public void PrintInformationAboutAProgram(long programSizeInBytes) {
        // TODO: according to the lab's document, please print the relevant information
        // about a given program
    }

    public void PrintInformationAboutAVirtualAddress(String virtalAddress) {
        // TODO: according to the lab's document, please print the relevant information
        // about a given virtual address.
    }
}
