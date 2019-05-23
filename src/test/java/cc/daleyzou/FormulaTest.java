/**
 * @projectName project
 * @package cc.daleyzou
 * @className cc.daleyzou.FormulaTest
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou;

import cc.daleyzou.patient.domain.Instance;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
}
