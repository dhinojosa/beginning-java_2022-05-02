package com.xyzcorp;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamsTest {

    @Test
    public void testTheProblemWithList() {
        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);//10+
        List<Integer> unmodifiableList = Arrays.asList(1, 2, 3, 4, 5);//5+

        List<Integer> mutableList = new ArrayList<>();
        mutableList.add(30);
        mutableList.add(50);
        mutableList.add(70);

        Collections.sort(mutableList); //This works
        //Collections.sort(immutableList);
        //Collections.sort(unmodifiableList);
    }

    @Test
    public void testUnmodifiableVsImmutable() {
        List<Integer> mutableList = new ArrayList<>();
        mutableList.add(30);
        mutableList.add(50);
        mutableList.add(60);
        mutableList.add(70);

        List<Integer> unmodifiableList =
            Collections.unmodifiableList(mutableList);
        System.out.println(unmodifiableList);

        List<Integer> immutableList = List.of(30, 10, 20, 40);
        immutableList.add(40);
    }

    @Test
    public void testStreams() {
        List<Integer> result =
            Stream.of(9, 12, 10, 18, 150)
                  .map(x -> x * 3)
                  .sorted()
                  .toList();
        System.out.println(result);
    }

    //Function: String  -> Integer
    //Supplier: ()      -> Integer
    //Consumer: Integer -> ()
    //Predicate: Person -> (true | false)
    @Test
    public void testStreamCreation() {
        List<ZonedDateTime> zonedDateTimes =
            Stream.generate(ZonedDateTime::now)
                  .limit(50)
                  .toList();
        System.out.println(zonedDateTimes);
    }

    @Test
    public void testStream() {
        Stream<Integer> integerStream =
            Stream.iterate(10, integer -> integer * 10);
        System.out.println(integerStream.limit(100).toList());
    }

    @Test
    public void testFlatMap() {
        List<Integer> list =
            Stream.of(1, 2, 3, 4, 5)
                  .filter(x -> x % 2 == 0)
                  .flatMap(i -> Stream.of(i, i * 100))
                  .toList();
        System.out.println(list);

        //5053691909
    }
}
