
package com.example.ivstk.sannacodetesttask.model.entity.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DataPoint {

    @SerializedName("time")
    @Expose
    private int time;
    @Expose
    private float precipProbability;
    @SerializedName("temperature")
    @Expose
    private float temperature;
    @SerializedName("humidity")
    @Expose
    private float humidity;
    @SerializedName("pressure")
    @Expose
    private float pressure;
    @SerializedName("windSpeed")
    @Expose
    private float windSpeed;


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(float precipProbability) {
        this.precipProbability = precipProbability;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("time", time)
                .append("precipProbability", precipProbability)
                .append("temperature", temperature)
                .append("humidity", humidity)
                .append("pressure", pressure)
                .append("windSpeed", windSpeed).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pressure).append(temperature)
                .append(windSpeed).append(time).append(humidity).append(precipProbability).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataPoint) == false) {
            return false;
        }
        DataPoint rhs = ((DataPoint) other);
        return new EqualsBuilder().append(temperature, rhs.temperature)
                .append(windSpeed, rhs.windSpeed)
                .append(time, rhs.time)
                .append(pressure, rhs.pressure)
                .append(humidity, rhs.humidity)
                .append(precipProbability, rhs.precipProbability).isEquals();
    }
}
