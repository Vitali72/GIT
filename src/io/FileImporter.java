package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import error.AnimalCreationException;
import animals.Animal;

public class FileImporter {
	public static List<Animal> importFromfile(String fileName) throws AnimalCreationException {
		List<Animal> animals = new LinkedList<>();

		File file = new File(fileName);
		StringBuilder sb = new StringBuilder();
		int nextByte = 0;
		int tmp = 0;
		try {

			FileReader fr = new FileReader(file);
			while ((tmp = fr.read()) != -1) {
				if (nextByte == 10 && tmp == 13) {
					String str = sb.toString();
					animals.add(Animal.converFromString(str));
					sb.setLength(0);
					System.out.println(str);
				} else {
					sb.append((char) nextByte);

				}
				tmp = nextByte;

			}
			String str = sb.toString();
			animals.add(Animal.converFromString(str));
			System.out.println(str);
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "Not found");
			return animals;
		} catch (IOException e) {
			System.out.println("File reading error");
		}

		return animals;

	}

	
	}



