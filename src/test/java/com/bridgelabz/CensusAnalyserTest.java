package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CensusAnalyserTest {
    //Testcase 1.1
    @Test
    void checkForExactNumberOfStates() throws IOException {
        List<String[]> myList = new ArrayList<>();
        String path = "C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianstateCensusData.CSV";
        String line = "";
        String splits = ",";
        String[] data = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        while ((line = bufferedReader.readLine()) != null) {
            data = line.split(splits);
            myList.add(data);
        }
        long counter = myList.stream().count();
        Assertions.assertEquals(11, counter, 0);
    }

}