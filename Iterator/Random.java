package InfiniteIterator;

import java.util.Iterator;

public class Random implements Iterable<Integer> {
    int min;
    int max;


    public Random(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return min + (int) (Math.random() * ((max - min) + 1));
            }
        };
    }
}
