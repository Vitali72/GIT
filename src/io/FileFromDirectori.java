package io;

import java.io.File;
import java.util.Scanner;

public class FileFromDirectori {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String user_i;
		System.out.println("Directory: ");
		user_i = sc.nextLine();
		File currentDir = new File(user_i);
		if (!currentDir.exists()) {
			System.out.println(" error directory ");
		} else {
			searcFile(currentDir);
		}
	}

	public static void searcFile(File dir) {

		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				int i = 0;
				if (file.isDirectory()) {
					System.out.println("directory:" + file);
					searcFile(file);

				}
				if (file.getName().endsWith(".csv")) {
					i++;
					System.out.println("     file ¹: " + i + " " + file);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	public List findFiles(String startPath, String mask)
            throws Exception {
        return find(startPath, mask, FILES);
    }
 
}
