package com.jarvissoft.anti.cpu.app.utility.upload;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jarvissoft.anti.cpu.app.utility.constants.MessageConstants;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by JARVISSOFT on 4/28/2017.
 */
public class UploadingUtility {

	public static void saveImage(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + "/resources/assets/uploadStudentImages/";

		InputStream inputStream = null;
		OutputStream outputStream = null;

		String fileName = commonsMultipartFile.getOriginalFilename();

		try {
			inputStream = commonsMultipartFile.getInputStream();
			System.out.println(UPLOAD_DIRECTORY + fileName);
			File newFile = new File(UPLOAD_DIRECTORY + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String saveCustomerProfile(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String adhar) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.CUSTOMER_DOCUMENT_DIRECTORY + adhar + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		System.out.println(dir.getPath());
		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				System.out.println("if not exists");
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY + "profile.jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY + "profile.jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}

	public static String saveSubAdminProfile(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String email) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.SUBADMIN_PROFILE_DIRECTORY + email + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		System.out.println(dir.getPath());
		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				System.out.println("if not exists");
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY + "profile.jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY + "profile.jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}

	public static String saveSocietyRegisterationReciept(CommonsMultipartFile commonsMultipartFile,
			HttpServletRequest request, String email) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.SOCIETY_DOCUMENT_DIRECTORY
				+ "registerCopy/" + email + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		System.out.println(dir.getPath());
		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				System.out.println("if not exists");
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY + "registrationReciept.jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY + "registrationReciept.jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}

	public static String saveSocietyAgrement(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String email) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.SOCIETY_DOCUMENT_DIRECTORY
				+ "agreementCopy/" + email + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY + "agreement.pdf");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY + "agreement.pdf");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}

	public static String saveSocietyAdSense(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String email) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.SOCIETY_DOCUMENT_DIRECTORY + "adSense/"
				+ email + "/";

		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY);
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY);
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}

	
	//
	
	
	
	
	public static String saveProductImage(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String itemName) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.PRODUCT_IMAGE_DIRECTORY + itemName + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		System.out.println(dir.getPath());
		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				System.out.println("if not exists");
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY +""+itemName+".jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY +""+itemName+".jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}
	
	
	
	
	
	
	
	
	public static String saveSocietyBranchProfile(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String email) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.SOCIETY_BRANCH_DOCUMENT_DIRECTORY
				+ "profile/" + email + "/";

		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY + "Profile.jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY + "Profile.jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}

	
	///
	
	
	public static String savePhotoImage(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String name) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.EMPPHOTO_PRODUCT_IMAGE_DIRECTORY + name + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		System.out.println(dir.getPath());
		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				System.out.println("if not exists");
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY +""+name+"photo.jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY +""+name+"photo.jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}
	
	
	public static String saveAdharImage(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String name) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.ADHAR_PRODUCT_IMAGE_DIRECTORY + name + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		System.out.println(dir.getPath());
		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				System.out.println("if not exists");
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY +""+name+"Adharcard.jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY +""+name+"Adharcard.jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}
	
	

	public static String savePanCardImage(CommonsMultipartFile commonsMultipartFile, HttpServletRequest request,
			String name) {
		String UPLOAD_DIRECTORY = request.getRealPath("") + MessageConstants.PANCARD_PRODUCT_IMAGE_DIRECTORY + name + "/";
		Path path1 = null;
		File dir = new File(UPLOAD_DIRECTORY);

		System.out.println(dir.getPath());
		if (!dir.exists()) {
			if (dir.mkdir() == true) {
				System.out.println("if not exists");
				byte[] b2 = commonsMultipartFile.getBytes();
				path1 = Paths.get(UPLOAD_DIRECTORY +""+name+"Pancard.jpg");
				try {
					Files.write(path1, b2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			byte[] b2 = commonsMultipartFile.getBytes();
			path1 = Paths.get(UPLOAD_DIRECTORY +""+name+"Pancard.jpg");
			try {
				Files.write(path1, b2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path1.getFileName().toString();
	}
	
	
	
	
	
	
	
	
	
	
	
}