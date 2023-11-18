package com.example.UK_Holiday.Service;

import aj.org.objectweb.asm.TypeReference;
import com.example.UK_Holiday.Entity.EnglandWalesHoliday;
import com.example.UK_Holiday.Entity.ReadFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ReadJson {
    public EnglandWalesHoliday readHolidayFile(String dataPath) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = TypeReference.class.getResourceAsStream(dataPath);
        ReadFile holidayData = objectMapper.readValue(inputStream, ReadFile.class);
        return holidayData.getEngland_and_wales();
    }

}
