package com.filehandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {
	
public final String upload = "/home/ist/eclipse-workspace/FileHandlingSpringBoot/src/main/resources/";
public Boolean uplpoad(MultipartFile multipart)
{
	Boolean bool=false;
	try {
		
//		InputStream inputstream=multipart.getInputStream();
//		byte data[]=new byte[inputstream.available()];
//		inputstream.read();
//		
//		//write
//		FileOutputStream fos=new 
//				FileOutputStream(upload+File.separator+multipart.getOriginalFilename());
//		fos.write(data);
//		fos.flush();
//		fos.close();
		//this code can be replaced by one file
		Files.copy(multipart.getInputStream(),
				Paths.get(upload+File.separator+multipart.getOriginalFilename()), 
					StandardCopyOption.REPLACE_EXISTING);
		
		bool=true;
	}
	
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	
	return bool;
}
}
