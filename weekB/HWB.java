package weekB;

import java.util.Deque;

public class HWB {

    public Integer recursiveSumDeque( Deque<Integer> d ){
        // base
        if (d.isEmpty()){return 0;}
        // if only has 1
        if (d.size()==1){
            return d.removeFirst();
        }
        // geting both first and last
        Integer first = d.removeFirst();
        Integer last = d.removeLast();
        // recursive sum
        return first + last + recursiveSumDeque(d);
    }

}