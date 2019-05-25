/**
 * @projectName project
 * @package cc.daleyzou.patient.controller
 * @className cc.daleyzou.patient.controller.CountController
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.patient.controller;

import cc.daleyzou.patient.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CountController
 * @description 计算射血分数 Controller类
 * @author daleyzou
 * @date 2019年05月23日 9:25
 * @version 1.0.0
 */
@Controller
public class CountController {

    @Autowired
    CountService countService;

    @RequestMapping(value = "/patient/num/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void countNum(@PathVariable Long pkTBLPatientID) {
        countService.countNum(pkTBLPatientID);
    }

    @RequestMapping(value = "/test/num/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void testCountNum(@PathVariable Long pkTBLPatientID) {
        countService.countNum(pkTBLPatientID);
    }

    @RequestMapping(value = "/patient/moveJpgToDir/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void moveJpgToDir(@PathVariable Long pkTBLPatientID) {
        countService.moveJpgToDir(pkTBLPatientID);
    }

    @RequestMapping(value = "/patient/sketchPicture/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void sketchPicture(@PathVariable Long pkTBLPatientID) {
        countService.sketchPicture(pkTBLPatientID);
    }

}
