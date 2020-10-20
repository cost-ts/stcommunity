package normaltest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @author: ST
 * @Date: 2020-10-15
 * @Time: 10:20
 */
public class TemporaryTest {
    @Test
    public void removeIf() {

        List<Integer> list1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
            }
        };

        List<Integer> list2 = new ArrayList<Integer>() {
            {
                add(6);
                add(7);
                add(8);
                add(9);
            }
        };

        System.out.println("list1" + list1 + ":" + "list2" + list2);

        // 去除重复值
        list1.removeIf(list2::contains);

        List<Integer> list3;
        list3 = new ArrayList<>(list1);

        System.out.println("list3" + list3);
    }

    @Test
    public void split(){

        String[] idArrays;

        String ids = "abc123,def456,ghi789";

        idArrays = ids.split(",");

        System.out.println("idArrays = " + Arrays.toString(idArrays));

    }
}
