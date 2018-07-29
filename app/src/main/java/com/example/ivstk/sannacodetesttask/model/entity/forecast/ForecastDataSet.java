
package com.example.ivstk.sannacodetesttask.model.entity.forecast;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ForecastDataSet {

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("data")
    @Expose
    private List<DataPoint> data = null;

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

    public List<DataPoint> getData() {
        return data;
    }

    public void setData(List<DataPoint> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("summary", summary).append("icon", icon).append("data", data).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(summary).append(icon).append(data).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ForecastDataSet) == false) {
            return false;
        }
        ForecastDataSet rhs = ((ForecastDataSet) other);
        return new EqualsBuilder().append(summary, rhs.summary).append(icon, rhs.icon).append(data, rhs.data).isEquals();
    }

}
