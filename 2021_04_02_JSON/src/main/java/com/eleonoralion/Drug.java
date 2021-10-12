package com.eleonoralion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="CLASS: ")
@JsonSubTypes({ @JsonSubTypes.Type(value=Drug.class, name="cat") })
@JsonAutoDetect
@XmlType(name = "drugg")
@XmlRootElement
public class Drug {
    String type;
    double weight;
    int[] array;
    Trip trip;

    public Drug(){

    }

    public Drug(String type, double weight, int[] array, String description, int time, int rate) {
        this.type = type;
        this.weight = weight;
        this.array = array;

        this.trip = new Trip(description, time, rate);
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    private class Trip {
        String description;
        int time;
        int rating;

        public Trip(){}

        public Trip(String description, int time, int rating) {
            this.description = description;
            this.time = time;
            this.rating = rating;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Trip{" +
                    "description='" + description + '\'' +
                    ", time=" + time +
                    ", rating=" + rating +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Drug{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", array=" + Arrays.toString(array) +
                ", trip=" + trip +
                '}';
    }
}
