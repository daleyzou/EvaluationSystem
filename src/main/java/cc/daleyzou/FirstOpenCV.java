/**
 * @projectName project
 * @package cc.daleyzou
 * @className cc.daleyzou.FirstOpenCV
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * FirstOpenCV
 * @description TODO
 * @author daleyzou
 * @date 2019年05月24日 16:18
 * @version 1.0.0
 */
public class FirstOpenCV {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //注意程序运行的时候需要在VM option添加该行 指明opencv的dll文件所在路径
        //-Djava.library.path=$PROJECT_DIR$\opencv\x64
    }

//    public static void main(String[] args) {
//        Mat mat = Imgcodecs.imread("C:/opencv.png");
//        System.out.println(mat);
//    }

//    public static void main(String[] args) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Mat image = Imgcodecs.imread("D:\\Graduation\\EasyPACS\\tmp\\learnnouse\\1.2.840.113619.2.234.90587033889.4351.1330343039751.374.png");
//        Imgproc.cvtColor(image, image, Imgproc.COLOR_RGB2GRAY);
//        Imgproc.adaptiveThreshold(image, image, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 25, 10);
//        Imgcodecs.imwrite("D:\\Graduation\\EasyPACS\\tmp\\learnnouse\\1.2.840.113619.2.234.90587033889.4351.1330343039751.374_result.png", image);
//    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat src = Imgcodecs.imread("D:/Graduation/EasyPACS/tmp/learnnouse/1.2.840.113619.2.234.90587033889.4351.1330343039751.374.png");
        Mat dst = src.clone();
        Imgproc.cvtColor(dst, dst, Imgproc.COLOR_BGRA2GRAY);
        Imgproc.adaptiveThreshold(dst, dst, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C,
                Imgproc.THRESH_BINARY_INV, 3, 3);

        java.util.List<MatOfPoint> contours = new java.util.ArrayList<MatOfPoint>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(dst, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_NONE,
                new Point(0, 0));
        System.out.println(contours.size());
        Mat resultSrc = Imgcodecs.imread("D:/Graduation/EasyPACS/tmp/learnnouse/yuanlai.png");

        for (int i = 0; i < contours.size(); i++)
        {
            Imgproc.drawContours(resultSrc, contours, i, new Scalar(0,0,255), 1);
        }

        Imgcodecs.imwrite("D:/Graduation/EasyPACS/tmp/learnnouse/test.png", resultSrc);
    }
}
