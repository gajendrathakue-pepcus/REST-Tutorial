package com.springboot.studentdata.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.studentdata.model.Attendance;
import com.springboot.studentdata.repository.AttendanceRepository;

@Service
public class AttendanceService {

  @Autowired
  AttendanceRepository attendanceRepository;

  public List<Attendance> addAttendance(MultipartFile csvFile) {
    List<Attendance> attendanceList = new ArrayList<Attendance>();
    Attendance attendance = null;
    // List<Attendance> erronousAttendance = new ArrayList<Attendance>();
    Logger LOGGER = LoggerFactory.getLogger(AttendanceService.class);

    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
      CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT);
      Iterable<CSVRecord> iterable = csvParser.getRecords();
      for (CSVRecord csvRecord : iterable) {
        int days = Integer.parseInt(csvRecord.get(1));
        System.out.println("GOT DAYS" + days);
        String isPresent = (csvRecord.get(2)).toLowerCase();
        System.out.println("GOT present" + isPresent);
        if (days >= 1 && days <= 30) {
          {
            if (isPresent.equals("true"))
              attendance = new Attendance(Integer.parseInt(csvRecord.get(0)), days, "true",
                  Integer.parseInt(csvRecord.get(3)));
            if (isPresent.equals("false"))
              attendance = new Attendance(Integer.parseInt(csvRecord.get(0)), days, "false",
                  Integer.parseInt(csvRecord.get(3)));
          }
        } else {
          LOGGER.info("DAYS SHOULD BE FROM 1 TO 30 ");
        }
        attendanceList.add(attendance);
        attendanceRepository.save(attendance);
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return attendanceList;
  }

}
