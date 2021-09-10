package com.bridgelabz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * purpose-to create Indian States Census Analyser and States Code
 * using CSV file
 *
 * @author Sunil
 * @version 16.0
 * @since 10/09/2021
 */
public class StateCensusAnalyser {
    /*
    Method to analyse data from the indian census comma separated file
    */
    public void analyseCensusData() throws FileNotFoundException {
        String path = "C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianstateCensusData.CSV";
        String line = "";
        String splits = ",";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(splits);
                System.out.println("State: " + data[0] + ", Population: " + data[1] + ", Area: " + data[2] + ", Density: " + data[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(" Welcome to Indian State Census Analyser");

    }
}