### 发起计算射血分数请求
http://localhost:8080/patient/num/5

### 将dcm文件移动到指定目录
http://localhost:8080/patient/moveDcmToDir/5

### 将图片移动到指定目录
http://localhost:8080/patient/moveJpgToDir/5

### 图片90张一个批次，移动到目录，为高对比度准备
http://localhost:8080/test/moveJpgToDir/5

### 调用程序对图片进行二值化处理
http://localhost:8080/test/contrast/5

### 勾画图片
http://localhost:8080/patient/sketchPicture/5

### 根据患者、切片 显示动画
http://localhost:8080/sketchAnimation?pkTBLPatientID=5&sliceLocation=-63.669

### 根据患者、切片 显示图片轮播
http://localhost:8080/sketchPicture?pkTBLPatientID=5&sliceLocation=-63.669

### 展示图表
http://localhost:8080/chart?pkTBLPatientID=5

### 手动触发定时任务
http://localhost:8080/ef/7

## 处理一个病人的执行步骤
http://localhost:8080/test/moveJpgToDir/5

http://localhost:8080/test/contrast/5

http://localhost:8080/splitPicture/5

http://localhost:8080/patient/moveJpgToDir/5

http://localhost:8080/patient/num/5

http://localhost:8080/patient/sketchPicture/5










