
package com.example.ivstk.sannacodetesttask.model.entity.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DayPoint {

    @SerializedName("time")
    @Expose
    private int time;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("sunriseTime")
    @Expose
    private int sunriseTime;
    @SerializedName("sunsetTime")
    @Expose
    private int sunsetTime;
    @SerializedName("moonPhase")
    @Expose
    private float moonPhase;
    @SerializedName("precipIntensity")
    @Expose
    private float precipIntensity;
    @SerializedName("precipIntensityMax")
    @Expose
    private float precipIntensityMax;
    @SerializedName("precipIntensityMaxTime")
    @Expose
    private float precipIntensityMaxTime;
    @SerializedName("precipProbability")
    @Expose
    private float precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;
    @SerializedName("temperatureHigh")
    @Expose
    private float temperatureHigh;
    @SerializedName("temperatureHighTime")
    @Expose
    private float temperatureHighTime;
    @SerializedName("temperatureLow")
    @Expose
    private float temperatureLow;
    @SerializedName("temperatureLowTime")
    @Expose
    private float temperatureLowTime;
    @SerializedName("apparentTemperatureHigh")
    @Expose
    private float apparentTemperatureHigh;
    @SerializedName("apparentTemperatureHighTime")
    @Expose
    private float apparentTemperatureHighTime;
    @SerializedName("apparentTemperatureLow")
    @Expose
    private float apparentTemperatureLow;
    @SerializedName("apparentTemperatureLowTime")
    @Expose
    private float apparentTemperatureLowTime;
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
    @SerializedName("windGustTime")
    @Expose
    private float windGustTime;
    @SerializedName("windBearing")
    @Expose
    private float windBearing;
    @SerializedName("cloudCover")
    @Expose
    private float cloudCover;
    @SerializedName("uvIndex")
    @Expose
    private float uvIndex;
    @SerializedName("uvIndexTime")
    @Expose
    private float uvIndexTime;
    @SerializedName("visibility")
    @Expose
    private float visibility;
    @SerializedName("ozone")
    @Expose
    private float ozone;
    @SerializedName("temperatureMin")
    @Expose
    private float temperatureMin;
    @SerializedName("temperatureMinTime")
    @Expose
    private float temperatureMinTime;
    @SerializedName("temperatureMax")
    @Expose
    private float temperatureMax;
    @SerializedName("temperatureMaxTime")
    @Expose
    private float temperatureMaxTime;
    @SerializedName("apparentTemperatureMin")
    @Expose
    private float apparentTemperatureMin;
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    private float apparentTemperatureMinTime;
    @SerializedName("apparentTemperatureMax")
    @Expose
    private float apparentTemperatureMax;
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    private float apparentTemperatureMaxTime;

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

    public int getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(int sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public int getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(int sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public float getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
    }

    public float getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(float precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public float getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(float precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public float getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(float precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public float getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(float precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public float getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(float temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public float getTemperatureHighTime() {
        return temperatureHighTime;
    }

    public void setTemperatureHighTime(float temperatureHighTime) {
        this.temperatureHighTime = temperatureHighTime;
    }

    public float getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(float temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public float getTemperatureLowTime() {
        return temperatureLowTime;
    }

    public void setTemperatureLowTime(int temperatureLowTime) {
        this.temperatureLowTime = temperatureLowTime;
    }

    public float getApparentTemperatureHigh() {
        return apparentTemperatureHigh;
    }

    public void setApparentTemperatureHigh(float apparentTemperatureHigh) {
        this.apparentTemperatureHigh = apparentTemperatureHigh;
    }

    public float getApparentTemperatureHighTime() {
        return apparentTemperatureHighTime;
    }

    public void setApparentTemperatureHighTime(float apparentTemperatureHighTime) {
        this.apparentTemperatureHighTime = apparentTemperatureHighTime;
    }

    public float getApparentTemperatureLow() {
        return apparentTemperatureLow;
    }

    public void setApparentTemperatureLow(float apparentTemperatureLow) {
        this.apparentTemperatureLow = apparentTemperatureLow;
    }

    public float getApparentTemperatureLowTime() {
        return apparentTemperatureLowTime;
    }

    public void setApparentTemperatureLowTime(float apparentTemperatureLowTime) {
        this.apparentTemperatureLowTime = apparentTemperatureLowTime;
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

    public float getWindGustTime() {
        return windGustTime;
    }

    public void setWindGustTime(float windGustTime) {
        this.windGustTime = windGustTime;
    }

    public float getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(float windBearing) {
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

    public float getUvIndexTime() {
        return uvIndexTime;
    }

    public void setUvIndexTime(float uvIndexTime) {
        this.uvIndexTime = uvIndexTime;
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

    public float getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(float temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public float getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(float temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public float getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(float temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public float getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(float temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public float getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(float apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public float getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(float apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public float getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(float apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public float getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(float apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("time", time).append("summary", summary).append("icon", icon).append("sunriseTime", sunriseTime).append("sunsetTime", sunsetTime).append("moonPhase", moonPhase).append("precipIntensity", precipIntensity).append("precipIntensityMax", precipIntensityMax).append("precipIntensityMaxTime", precipIntensityMaxTime).append("precipProbability", precipProbability).append("precipType", precipType).append("temperatureHigh", temperatureHigh).append("temperatureHighTime", temperatureHighTime).append("temperatureLow", temperatureLow).append("temperatureLowTime", temperatureLowTime).append("apparentTemperatureHigh", apparentTemperatureHigh).append("apparentTemperatureHighTime", apparentTemperatureHighTime).append("apparentTemperatureLow", apparentTemperatureLow).append("apparentTemperatureLowTime", apparentTemperatureLowTime).append("dewPoint", dewPoint).append("humidity", humidity).append("pressure", pressure).append("windSpeed", windSpeed).append("windGust", windGust).append("windGustTime", windGustTime).append("windBearing", windBearing).append("cloudCover", cloudCover).append("uvIndex", uvIndex).append("uvIndexTime", uvIndexTime).append("visibility", visibility).append("ozone", ozone).append("temperatureMin", temperatureMin).append("temperatureMinTime", temperatureMinTime).append("temperatureMax", temperatureMax).append("temperatureMaxTime", temperatureMaxTime).append("apparentTemperatureMin", apparentTemperatureMin).append("apparentTemperatureMinTime", apparentTemperatureMinTime).append("apparentTemperatureMax", apparentTemperatureMax).append("apparentTemperatureMaxTime", apparentTemperatureMaxTime).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(temperatureMinTime).append(sunsetTime).append(summary).append(precipIntensityMaxTime).append(visibility).append(temperatureLowTime).append(temperatureLow).append(temperatureHighTime).append(precipIntensity).append(precipIntensityMax).append(ozone).append(time).append(apparentTemperatureMaxTime).append(uvIndex).append(apparentTemperatureHighTime).append(temperatureHigh).append(windGust).append(icon).append(apparentTemperatureLowTime).append(temperatureMaxTime).append(pressure).append(cloudCover).append(apparentTemperatureMinTime).append(temperatureMin).append(precipType).append(apparentTemperatureLow).append(dewPoint).append(sunriseTime).append(windSpeed).append(humidity).append(apparentTemperatureMax).append(windBearing).append(moonPhase).append(precipProbability).append(windGustTime).append(apparentTemperatureMin).append(uvIndexTime).append(temperatureMax).append(apparentTemperatureHigh).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DayPoint) == false) {
            return false;
        }
        DayPoint rhs = ((DayPoint) other);
        return new EqualsBuilder().append(temperatureMinTime, rhs.temperatureMinTime).append(sunsetTime, rhs.sunsetTime).append(summary, rhs.summary).append(precipIntensityMaxTime, rhs.precipIntensityMaxTime).append(visibility, rhs.visibility).append(temperatureLowTime, rhs.temperatureLowTime).append(temperatureLow, rhs.temperatureLow).append(temperatureHighTime, rhs.temperatureHighTime).append(precipIntensity, rhs.precipIntensity).append(precipIntensityMax, rhs.precipIntensityMax).append(ozone, rhs.ozone).append(time, rhs.time).append(apparentTemperatureMaxTime, rhs.apparentTemperatureMaxTime).append(uvIndex, rhs.uvIndex).append(apparentTemperatureHighTime, rhs.apparentTemperatureHighTime).append(temperatureHigh, rhs.temperatureHigh).append(windGust, rhs.windGust).append(icon, rhs.icon).append(apparentTemperatureLowTime, rhs.apparentTemperatureLowTime).append(temperatureMaxTime, rhs.temperatureMaxTime).append(pressure, rhs.pressure).append(cloudCover, rhs.cloudCover).append(apparentTemperatureMinTime, rhs.apparentTemperatureMinTime).append(temperatureMin, rhs.temperatureMin).append(precipType, rhs.precipType).append(apparentTemperatureLow, rhs.apparentTemperatureLow).append(dewPoint, rhs.dewPoint).append(sunriseTime, rhs.sunriseTime).append(windSpeed, rhs.windSpeed).append(humidity, rhs.humidity).append(apparentTemperatureMax, rhs.apparentTemperatureMax).append(windBearing, rhs.windBearing).append(moonPhase, rhs.moonPhase).append(precipProbability, rhs.precipProbability).append(windGustTime, rhs.windGustTime).append(apparentTemperatureMin, rhs.apparentTemperatureMin).append(uvIndexTime, rhs.uvIndexTime).append(temperatureMax, rhs.temperatureMax).append(apparentTemperatureHigh, rhs.apparentTemperatureHigh).isEquals();
    }

}
