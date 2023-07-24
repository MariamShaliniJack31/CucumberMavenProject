package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class FileOperations 
{
	public FileInputStream in = null;
	public FileOutputStream out = null;
	public File file = null;
		
	public void copyPaste(String srcFilePath,String desFilePath)
	{
		try {
			file = new File(srcFilePath);
			File destFile = new File(desFilePath);
			Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void move(String srcFilePath,String desFilePath)
	{
		try {  
			file = new File(srcFilePath);
			File destFile = new File(desFilePath);
			file.renameTo(destFile);
			file.delete();
		} catch(Exception e){
		System.out.println(e.getMessage());
		    	  e.printStackTrace();
		      }
		}
		
		public void copy(String srcFilePath,String desFilePath)
		{
			try{  
				file = new File(srcFilePath);
				File destFile=new File(desFilePath);
				file.renameTo(destFile);
		      }catch(Exception e){
		    	  System.out.println(e.getMessage());
		      }
		}
		public void deleteFilesByExtn(String dirFilePath,String extn) 
		{
			 try {      
		         file = new File(dirFilePath);
		         for(File fileName:file.listFiles()) {
		        	 if(fileName.getName().endsWith(extn))
		        	 {
		        		 System.out.println(fileName.delete());
		        	 }
		         }
		      } catch (Exception e) {
		    	  System.out.println(e.getMessage());
		      }
		}
		public boolean deleteFile(String srcFilePath)
		{
			boolean fileDeleted = false;
			try{
					File files = new File(srcFilePath);
					if(files.exists()){
						fileDeleted = files.delete();
					}
					return fileDeleted;
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return fileDeleted;
			}
		}
		public void read(String inputFilePath){
			try{
		         in = new FileInputStream(inputFilePath);
		         int charIndex;
		         while ((charIndex = in.read()) != -1) {
		           System.out.print((char)charIndex);
		         }
		    }catch(FileNotFoundException e) {
				System.out.println(e.getMessage());
			}catch(IOException e){
				System.out.println(e.getMessage());
			}finally{
				try{
						in.close();
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
		    }
		}
		public void createFile(String filePath){
			file = new File(filePath);
			try{
				if(file.createNewFile()){
					System.out.println("created successfully");
				}else{
					System.out.println("Already exists");
				}
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		public boolean createDirs(String direcPath){
			boolean created = false;
			try{
				file = new File(direcPath);
				created = file.mkdirs();
				return created;
			}catch(Exception e){
				System.out.println(e.getMessage());
				return created;
			}
		}
		public void write(String inputFilePath,String outputFilePath){
		     try{
		         in = new FileInputStream(inputFilePath);
		         out = new FileOutputStream(outputFilePath,true);
		         int c;
		         while ((c = in.read()) != -1) {
		            out.write(c);
		         }
		      }catch(FileNotFoundException e){
				System.out.println(e.getMessage());
		      }catch(IOException e){
				System.out.println(e.getMessage());
		      }finally{
				 try{
					in.close();
					out.close();
				 }catch(IOException e){
					System.out.println(e.getMessage());
				}
		    }
		}
		public void append(String inputFilePath,String text)
		{
			try{
		         in = new FileInputStream(inputFilePath);
		         out = new FileOutputStream(inputFilePath,true);
		         out.write(text.getBytes());
		         in.close();
		         out.close();
			}catch(FileNotFoundException e){
				System.out.println(e.getMessage());
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}finally 
			{
				try{
					in.close();
					out.close();
				}catch(IOException e){
					System.out.println(e.getMessage());
				}
		    }
		}
		
	public boolean fileFolderExists(String filePath) 
	{
			boolean exists = false;
			try{
				String[] dirArr = filePath.split("\\\\");
				String absDirPath = "";
				for(String dirName: dirArr)
				{
					absDirPath = absDirPath+dirName+"\\";
					File files = new File(absDirPath);
					if(files.exists())
					{
						exists = true;
					}
					else
					{
						exists = false;
						System.out.println("Following file or folder doesn't exists in followig path:"+filePath);
						System.exit(0);
						break;
					}
				}
			}catch(Exception e) 
			{
				System.out.println(e.getMessage());
			}
			return exists;
		}
	public Properties readProperty(String file)
	{
		Properties properties = null;
		try{
			FileInputStream fileInput = new FileInputStream(file);
			properties = new Properties();
			properties.load(fileInput);
		} catch (Exception e){
			
		}
		return properties;
	}
}