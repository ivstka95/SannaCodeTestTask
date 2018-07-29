
package com.example.ivstk.sannacodetesttask.model.entity.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class HourPoint {

    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("precipIntensity")
    @Expose
    private float precipIntensity;
    @SerializedName("precipProbability")
    @Expose
    private float precipProbability;
    @SerializedName("temperature")
    @Expose
    private float temperature;
    @SerializedName("apparentTemperature")
    @Expose
    private float apparentTemperature;
    @SerializedName("dewPoint")
    @Expose
    private float dewPoint;
    @SerializedName("humidity")
    @Expose
    private float humidity;
    @SerializedName("pressure")
    @Expose
    private float pressure;
    @SerializedName("windSpeed")
    @Expose
    private float windSpeed;
    @SerializedName("windGust")
    @Expose
    private float windGust;
    @SerializedName("windBearing")
    @Expose
    private float windBearing;
    @SerializedName("cloudCover")
    @Expose
    private float cloudCover;
    @SerializedName("uvIndex")
    @Expose
    private float uvIndex;
    @SerializedName("visibility")
    @Expose
    private float visibility;
    @SerializedName("ozone")
    @Expose
    private float ozone;
    @SerializedName("precipType")
    @Expose
    private String precipType;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(float precipIntensity) {
        this.precipIntensity = precipIntensity;
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

    public float getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(float apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
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

    public float getWindGust() {
        return windGust;
    }

    public void setWindGust(float windGust) {
        this.windGust = windGust;
    }

    public float getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(int windBearing) {
        this.windBearing = windBearing;
    }

    public float getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(float cloudCover) {
        this.cloudCover = cloudCover;
    }

    public float getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(float uvIndex) {
        this.uvIndex = uvIndex;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public float getOzone() {
        return ozone;
    }

    public void setOzone(float ozone) {
        this.ozone = ozone;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("time", time).append("summary", summary).append("icon", icon).append("precipIntensity", precipIntensity).append("precipProbability", precipProbability).append("temperature", temperature).append("apparentTemperature", apparentTemperature).append("dewPoint", dewPoint).append("humidity", humidity).append("pressure", pressure).append("windSpeed", windSpeed).append("windGust", windGust).append("windBearing", windBearing).append("cloudCover", cloudCover).append("uvIndex", uvIndex).append("visibility", visibility).append("ozone", ozone).append("precipType", precipType).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(summary).append(windGust).append(icon).append(pressure).append(visibility).append(cloudCover).append(apparentTemperature).append(precipType).append(precipIntensity).append(dewPoint).append(temperature).append(ozone).append(windSpeed).append(time).append(humidity).append(windBearing).append(uvIndex).append(precipProbability).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HourPoint) == false) {
            return false;
        }
        HourPoint rhs = ((HourPoint) other);
        return new EqualsBuilder().append(summary, rhs.summary).append(windGust, rhs.windGust).append(icon, rhs.icon).append(pressure, rhs.pressure).append(visibility, rhs.visibility).append(cloudCover, rhs.cloudCover).append(apparentTemperature, rhs.apparentTemperature).append(precipType, rhs.precipType).append(precipIntensity, rhs.precipIntensity).append(dewPoint, rhs.dewPoint).append(temperature, rhs.temperature).append(ozone, rhs.ozone).append(windSpeed, rhs.windSpeed).append(time, rhs.time).append(humidity, rhs.humidity).append(windBearing, rhs.windBearing).append(uvIndex, rhs.uvIndex).append(precipProbability, rhs.precipProbability).isEquals();
    }

}
