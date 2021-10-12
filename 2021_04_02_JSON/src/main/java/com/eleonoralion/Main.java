package com.eleonoralion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) {
        new Main().go();
    }

    public void go(){
        ObjectMapper objectMapper = new ObjectMapper();

        Drug drug = new Drug("Psyho", 250.0f, new int[]{1,2,3}, "Nice trip, love lsa", 8, 19);

        try {
            //String result = objectMapper.writeValueAsString(drug);
            StringWriter stringWriter = new StringWriter();
            objectMapper.writeValue(stringWriter, drug);


            String result = stringWriter.toString();
            System.out.println(result);


            Drug d = objectMapper.readValue(result, Drug.class);
            System.out.println(d);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            StringWriter stringWriter = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(Drug.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(drug, stringWriter);

            System.out.println(stringWriter.toString());


        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
