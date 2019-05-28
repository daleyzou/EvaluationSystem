/**
 * @projectName project
 * @package cc.daleyzou
 * @className cc.daleyzou.FormulaTest
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou;

import cc.daleyzou.patient.domain.Instance;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * FormulaTest
 * @description TODO
 * @author daleyzou
 * @date 2019年05月23日 23:33
 * @version 1.0.0
 */
public class FormulaTest {

    @Test
    public void testCal(){
//        double ef = (double)(6392 - 4052) / 6392 * 100;
        float ef = (float)(6392 - 4052) / 6392 * 100;
        System.out.println(ef);
    }

    @Test
    public void testMap(){
        List<Instance> list = new ArrayList<>();
        Instance instance1 = new Instance();
        instance1.setSopinstanceuid("1");
        Instance instance2 = new Instance();
        instance2.setSopinstanceuid("2");
        list.add(instance1);
        list.add(instance2);
//        List<String> collect = list.stream().map(Instance::getSopinstanceuid).collect(Collectors.toList());
        String collect = list.stream().map(Instance::getSopinstanceuid).collect(Collectors.joining(","));
//        String join = String.join(",", collect);
        System.out.println(collect);
    }

    @Test
    public void testTreeMap(){
        Map<Float,String> x = new TreeMap<>();
        x.put(Float.valueOf("5.0"),"string1");
        x.put(Float.valueOf("9.0"),"string2");
        x.put(Float.valueOf("1.0"),"string3");

        Iterator<Map.Entry<Float, String>> entries = x.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<Float, String> entry = entries.next();
            System.out.println(entry.getKey());
        }
    }
}
