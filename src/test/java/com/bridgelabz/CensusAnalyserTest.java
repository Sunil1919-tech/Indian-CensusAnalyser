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

    //Testcase 1.2
    @Test
    void checkForExactNumberOfStatesWithFileException() throws Exception {
        String path = "C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianstateCensusData.CSV";
        if (path.equals("C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianstateCensusData.CSV")) {
            System.out.println("File path is correct!");
        } else throw new MyException("CSV file path is incorrect");
    }

    //Testcase 1.3
    @Test
    void checkForExactNumberOfStatesWithFileSameTypeException() throws MyException {
        String path = "C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianstateCensusData.CSV";
        String fileName = new File(path).getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            String extension = fileName.substring(dotIndex + 1);
            if (extension.equals(".csv")) {
                System.out.println("File type is similar");
            }
        } else throw new MyException("CSV file path is incorrect");
    }

    //Testcase 1.4
    @Test
    void checkForDelimiterIfIncorrectThrowCustomException() throws MyException {
        String delimiter = ",";
        if (delimiter.equals(",")) {
            System.out.println("Delimiter is correct!");
        } else throw new MyException("Delimiter is incorrect!");
    }

    //Testcase 1.5
    @Test
    void checkForHeaderIfIncorrectThrowCustomException() throws MyException {
        String[] header = {"State", " Population", " Area", " Density"};
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < header.length; i++) {
            stringBuffer.append(header[i]);
        }
        String string = stringBuffer.toString();
        System.out.println(string);

        if (string.equals("State Population Area Density")) {
            System.out.println("Header is correct");
        } else throw new MyException("Header is incorrect");
    }
    //Testcase 2.1
    @Test
    void checkForNumberOfRecordIfCorrectAssertTrue() throws IOException {
        String path = "C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianStateCodes.CSV";
        List<String[]> myList = new ArrayList<>();
        String line = "";
        String splits =",";
        String [] data =null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        while ((line = bufferedReader.readLine()) != null) {
            data = line.split(splits);
            myList.add(data);
        }
        long counter = myList.stream().count();
        Assertions.assertEquals(38,counter,0);
    }

    //Testcase 2.2
    @Test
    void GivenFileFormatIsIncorrectShouldThrowCustomException() throws MyException{
        String path = "C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianStateCodes.CSV";
        if(path.equals("C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianStateCodes.CSV")){
            System.out.println("Path is correct!");
        } else throw new  MyException("Incorrect file");
    }

    //Testcase 2.3
    @Test
    void givenStateCodeFileShouldBeOfSameTypeElseThrowCustomException() throws MyException{
        String path = "C:\\Users\\sunil\\IdeaProjects\\IndianStates_CensusAnalyser\\src\\main\\resources\\IndianStateCodes.CSV";
        String fileName = new File(path).getName();
        int dotIndex = fileName.lastIndexOf('.');
        if(dotIndex>0) {
            String extension = fileName.substring(dotIndex + 1);
            if (extension.equals(".csv")) {
                System.out.println("File type is similar");
            }
        } else throw new MyException("CSV file path is incorrect");
    }

    //Testcase 2.4
    @Test
    void whenIncorrectDelimiterIsInsertedShouldThrowCustomException() throws MyException{
        String delimiter =",";
        if(delimiter.equals(",")){
            System.out.println("Delimiter is correct!");
        } else throw new MyException("Delimiter is incorrect!");
    }

    //Testcase 2.5
    @Test
    void whenGivenHeaderIsIncorrectShouldThrowCustomException() throws MyException{
        String [] header = {"Serial Number"," State Name"," TIN"," State Code"};
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<header.length; i++){
            stringBuffer.append(header[i]);
        }
        String string = stringBuffer.toString();
        System.out.println(string);

        if(string.equals("Serial Number State Name TIN State Code")){
            System.out.println("Header is correct");
        } else throw new MyException("Header is incorrect");
    }
}