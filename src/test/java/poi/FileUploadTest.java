package poi;

import java.io.File;

import gzhu.edu.cn.homework.utils.ParseUserFile;

public class FileUploadTest {
	
	public static void main(String[] args) {
		
		File file = new File("D:\\workspace\\homework-git\\homework\\doc\\用户导入模板.xls");
		try {
			ParseUserFile.readUserFormFile(file,1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
