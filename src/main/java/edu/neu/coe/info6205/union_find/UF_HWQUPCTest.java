package edu.neu.coe.info6205.union_find;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class UF_HWQUPCTest {

	public static Integer getRandomNumber(int max) {
		Random rand = new Random();
		Integer n = rand.nextInt(max);
		return n;
	}

	public static int[] getAPair(int max) {
		int[] pair = new int[2];
		pair[0] = getRandomNumber(max);
		pair[1] = getRandomNumber(max);
		while (pair[0] == pair[1]) {
			pair[1] = getRandomNumber(max);
		}
		return pair;

	}

	public static int count(int n) {
		int netPairs = 0;
		UF_HWQUPC uf = new UF_HWQUPC(n);
		while(uf.components() != 1) {
			int[] pair = getAPair(n);
			System.out.println(Arrays.toString(pair));
			uf.connect(pair[0], pair[1]);
			netPairs++;
		}
		return netPairs;
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter no. of elements: ");
		int totalElements = reader.nextInt();
		int netPairs = 0;
		System.out.println("No. of elements tested:" + totalElements);
		for (int i = 1; i <= correctionFactor; i++) {
			netPairs+=count(totalElements);
		}
		System.out.println("No. of pairs generated:" + netPairs/correctionFactor);
		reader.close();
	}

	private final static int correctionFactor = 1000;
}
