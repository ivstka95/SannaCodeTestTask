
package com.example.ivstk.sannacodetesttask.model.entity.forecast;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Daily {

    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("data")
    @Expose
    private List<DayPoint> data = null;

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

    public List<DayPoint> getData() {
        return data;
    }

    public void setData(List<DayPoint> data) {
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
        if ((other instanceof Daily) == false) {
            return false;
        }
        Daily rhs = ((Daily) other);
        return new EqualsBuilder().append(summary, rhs.summary).append(icon, rhs.icon).append(data, rhs.data).isEquals();
    }

}
